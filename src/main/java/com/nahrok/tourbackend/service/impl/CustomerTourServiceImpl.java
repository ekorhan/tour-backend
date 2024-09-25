package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.CustomerTourRelEntity;
import com.nahrok.tourbackend.entity.PaymentEntity;
import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;
import com.nahrok.tourbackend.model.customer_tour.Payment;
import com.nahrok.tourbackend.repo.CustomerTourRelRepository;
import com.nahrok.tourbackend.repo.PaymentRepository;
import com.nahrok.tourbackend.service.ICustomerTourService;
import org.springframework.stereotype.Service;

@Service
public class CustomerTourServiceImpl implements ICustomerTourService {

    private final CustomerTourRelRepository customerTourRelRepository;
    private final PaymentRepository paymentRepository;

    public CustomerTourServiceImpl(CustomerTourRelRepository customerTourRelRepository, PaymentRepository paymentRepository) {
        this.customerTourRelRepository = customerTourRelRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addCustomerToTour(CreateCustomerTourRequest request) {
        /**
         * customer info
         * tour info
         * customer info about this tour for example payment
         */

        Payment payment = request.getPayment();

        CustomerTourRelEntity relEntity = new CustomerTourRelEntity();
        relEntity.setCustomerId(request.getCustomerId());
        relEntity.setTourId(request.getTourId());

        PaymentEntity paymentEntity = new PaymentEntity();

        paymentEntity.setDeposit(payment.getDeposit());
        paymentEntity.setPaid(payment.getPaid());
        paymentEntity.setRemainingAmount(payment.getRemainingAmount());
        paymentEntity.setTotalAmount(payment.getTotalAmount());

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
