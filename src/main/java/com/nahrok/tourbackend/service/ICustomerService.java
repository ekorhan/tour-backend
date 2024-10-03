package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetailResponse;

import java.util.List;

public interface ICustomerService {
    Long createCustomer(CreateCustomerRequest request);

    CustomerDetailResponse getCustomerDetails(Long customerId);

    List<CustomerDetailResponse> getCustomers();

    List<CustomerDetailResponse> searchCustomer(String anyName);
}
