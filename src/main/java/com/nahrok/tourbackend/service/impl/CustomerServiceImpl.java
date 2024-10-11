package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.CustomerEntity;
import com.nahrok.tourbackend.mapper.customer.CustomerCreateMapper;
import com.nahrok.tourbackend.mapper.customer.CustomerDetailMapper;
import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetail;
import com.nahrok.tourbackend.repo.CustomerRepository;
import com.nahrok.tourbackend.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerCreateMapper customerCreateMapper;
    private final CustomerDetailMapper customerDetailMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerCreateMapper customerCreateMapper,
                               CustomerDetailMapper customerDetailMapper) {
        this.customerRepository = customerRepository;
        this.customerCreateMapper = customerCreateMapper;
        this.customerDetailMapper = customerDetailMapper;
    }

    @Override
    public Long createCustomer(CreateCustomerRequest request) {
        return customerRepository.save(customerCreateMapper.modelToEntity(request)).getId();
    }

    @Override
    public CustomerDetail getCustomerDetails(Long customerId) {
        Optional<CustomerEntity> entity = customerRepository.findById(customerId);
        return entity.map(customerDetailMapper::entityToModel).orElse(null);
    }

    @Override
    public List<CustomerDetail> getCustomers() {
        return customerDetailMapper.entityToModel(customerRepository.findAll());
    }

    @Override
    public List<CustomerDetail> searchCustomer(String anyName) {
        return customerDetailMapper.entityToModel(customerRepository.searchCustomer(anyName.toLowerCase(Locale.ROOT)));
    }

    @Override
    public CustomerDetail updateCustomer(CustomerDetail request) {
        CustomerEntity entity = customerRepository.findById(request.getId()).orElse(null);

        if (Objects.isNull(entity)) {
            return null;
        }

        if (Objects.nonNull(request.getFirstName())) {
            entity.setFirstName(request.getFirstName());
        }
        if (Objects.nonNull(request.getLastName())) {
            entity.setLastName(request.getLastName());
        }
        if (Objects.nonNull(request.getEmail())) {
            //entity.setEmail(request.getEmail());
        }
        if (Objects.nonNull(request.getCountryCode())) {
            entity.setCountryCode(request.getCountryCode());
        }
        if (Objects.nonNull(request.getPhoneNumber())) {
            entity.setPhoneNumber(request.getPhoneNumber());
        }

        return customerDetailMapper.entityToModel(customerRepository.save(entity));
    }
}
