package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.CustomerTourRelEntity;
import com.nahrok.tourbackend.entity.PaymentEntity;
import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;
import com.nahrok.tourbackend.repo.CustomerTourRelRepository;
import com.nahrok.tourbackend.repo.PaymentRepository;
import com.nahrok.tourbackend.service.ICustomerTourService;
import com.nahrok.tourbackend.service.ITourService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerTourServiceImpl implements ICustomerTourService {

    private final CustomerTourRelRepository customerTourRelRepository;
    private final PaymentRepository paymentRepository;
    private final ITourService tourService;

    public CustomerTourServiceImpl(CustomerTourRelRepository customerTourRelRepository, PaymentRepository paymentRepository, ITourService tourService) {
        this.customerTourRelRepository = customerTourRelRepository;
        this.paymentRepository = paymentRepository;
        this.tourService = tourService;
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
}
