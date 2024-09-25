package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;

public interface ICustomerTourService {
    void addCustomerToTour(CreateCustomerTourRequest request);

    void updateCustomerPayment(UpdatePaymentRequest request);
}
