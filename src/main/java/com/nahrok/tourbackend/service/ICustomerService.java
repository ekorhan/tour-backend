package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetailResponse;

public interface ICustomerService {
    Long createCustomer(CreateCustomerRequest request);
    CustomerDetailResponse getCustomerDetails(Long customerId);
}
