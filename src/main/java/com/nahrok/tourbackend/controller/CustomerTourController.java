package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.UpdatePaymentRequest;
import com.nahrok.tourbackend.model.customer_tour.CreateCustomerTourRequest;
import com.nahrok.tourbackend.model.customer_tour.TourCustomer;
import com.nahrok.tourbackend.service.ICustomerTourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("tourCustomers")
    public List<TourCustomer> tourCustomers(@RequestParam("tourId") Long tourId) {
        return customerTourService.getTourCustomers(tourId);
    }

}

