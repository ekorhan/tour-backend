package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetail;
import com.nahrok.tourbackend.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CustomerDetail getCustomerDetails(@RequestParam("customerId") Long customerId) {
        return customerService.getCustomerDetails(customerId);
    }

    @GetMapping("list")
    public List<CustomerDetail> customers() {
        return customerService.getCustomers();
    }

    @GetMapping("search")
    public List<CustomerDetail> search(@RequestParam("anyName") String anyName) {
        return customerService.searchCustomer(anyName);
    }

    @PostMapping("edit")
    public CustomerDetail updateCustomer(@RequestBody CustomerDetail request) {
        return customerService.updateCustomer(request);
    }

}
