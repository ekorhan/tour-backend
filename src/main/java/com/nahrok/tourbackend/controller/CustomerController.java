package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetailResponse;
import com.nahrok.tourbackend.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Long create(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping
    public CustomerDetailResponse getCustomerDetails(@RequestParam("customerId") Long customerId) {
        return customerService.getCustomerDetails(customerId);
    }

}
