package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.CustomerEntity;
import com.nahrok.tourbackend.entity.CustomerTourRelEntity;
import com.nahrok.tourbackend.entity.PaymentEntity;
import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;
import com.nahrok.tourbackend.model.customer_tour.TourCustomer;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;
import com.nahrok.tourbackend.repo.CustomerRepository;
import com.nahrok.tourbackend.repo.CustomerTourRelRepository;
import com.nahrok.tourbackend.repo.PaymentRepository;
import com.nahrok.tourbackend.service.ICustomerTourService;
import com.nahrok.tourbackend.service.ITourService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerTourServiceImpl implements ICustomerTourService {

    private final CustomerTourRelRepository customerTourRelRepository;
    private final PaymentRepository paymentRepository;
    private final ITourService tourService;
    private final CustomerRepository customerRepository;

    public CustomerTourServiceImpl(CustomerTourRelRepository customerTourRelRepository, PaymentRepository paymentRepository, ITourService tourService, CustomerRepository customerRepository) {
        this.customerTourRelRepository = customerTourRelRepository;
        this.paymentRepository = paymentRepository;
        this.tourService = tourService;
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomerToTour(CreateCustomerTourRequest request) {
        TourDetailResponse tour = tourService.getTour(request.getTourId());
        if (Objects.isNull(tour)) {
            return;
        }

        Double tourPrice = Double.parseDouble(tour.getTourPrice());

        CustomerTourRelEntity relEntity = new CustomerTourRelEntity();
        relEntity.setCustomerId(request.getCustomerId());
        relEntity.setTourId(request.getTourId());

        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setDeposit(request.getPaid());
        paymentEntity.setPaid(request.getPaid());
        paymentEntity.setRemainingAmount(tourPrice - request.getPaid());
        paymentEntity.setTotalAmount(tourPrice);

        paymentEntity = paymentRepository.save(paymentEntity);

        relEntity.setPaymentId(paymentEntity.getId());

        customerTourRelRepository.save(relEntity);
    }

    @Override
    public void updateCustomerPayment(UpdatePaymentRequest request) {
        CustomerTourRelEntity relEntity = customerTourRelRepository
                .findByIdOrCustomerAndTourId(request.getId(), request.getCustomerId(), request.getTourId());

        PaymentEntity paymentEntity = paymentRepository.findById(relEntity.getPaymentId()).orElse(null);

        if (paymentEntity != null) {
            paymentEntity.setPaid(request.getAmount() + paymentEntity.getPaid());
            paymentEntity.setRemainingAmount(paymentEntity.getRemainingAmount() - request.getAmount());
            paymentRepository.save(paymentEntity);
        }
    }

    @Override
    public List<TourCustomer> getTourCustomers(Long tourId) {
        List<TourCustomer> response = new ArrayList<>();

        List<CustomerTourRelEntity> rel = customerTourRelRepository.findByTourId(tourId);
        List<CustomerEntity> customers = customerRepository.findAllByIdIn(rel.stream().map(CustomerTourRelEntity::getCustomerId).toList());

        customers.forEach(e -> {
            TourCustomer tourCustomer = new TourCustomer();
            tourCustomer.setPassengerName(e.getFirstName() + " " + e.getLastName());
            tourCustomer.setId(e.getId());
            tourCustomer.setPhoneNumber(e.getPhoneNumber());
            response.add(tourCustomer);
        });

        return response;
    }
}
