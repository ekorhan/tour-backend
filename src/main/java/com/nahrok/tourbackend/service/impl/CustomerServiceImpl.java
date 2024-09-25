package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.CustomerEntity;
import com.nahrok.tourbackend.mapper.customer.CustomerCreateMapper;
import com.nahrok.tourbackend.mapper.customer.CustomerDetailMapper;
import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetailResponse;
import com.nahrok.tourbackend.repo.CustomerRepository;
import com.nahrok.tourbackend.service.ICustomerService;
import org.springframework.stereotype.Service;

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
    public CustomerDetailResponse getCustomerDetails(Long customerId) {
        Optional<CustomerEntity> entity = customerRepository.findById(customerId);
        return entity.map(customerDetailMapper::entityToModel).orElse(null);
    }
}
