package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;
import com.nahrok.tourbackend.model.customer_tour.TourCustomer;

import java.util.List;

public interface ICustomerTourService {
    void addCustomerToTour(CreateCustomerTourRequest request);

    void updateCustomerPayment(UpdatePaymentRequest request);

    List<TourCustomer> getTourCustomers(Long tourId);
}
