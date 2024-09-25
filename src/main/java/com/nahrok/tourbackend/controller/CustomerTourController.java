package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;
import com.nahrok.tourbackend.service.ICustomerTourService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customerTour")
public class CustomerTourController {
    private final ICustomerTourService customerTourService;

    public CustomerTourController(ICustomerTourService customerTourService) {

        this.customerTourService = customerTourService;
    }

    @PostMapping("addCustomerToTour")
    public void addCustomerToTour(@RequestBody CreateCustomerTourRequest request) {
        customerTourService.addCustomerToTour(request);
    }

    @PostMapping("updateCustomerPayment")
    public void updateCustomerPayment(@RequestBody UpdatePaymentRequest request) {
        customerTourService.updateCustomerPayment(request);
    }

}

