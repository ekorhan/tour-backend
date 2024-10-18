package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.CreateCustomerRequest;
import com.nahrok.tourbackend.model.CustomerDetail;

import java.util.List;

public interface ICustomerService {
    Long createCustomer(CreateCustomerRequest request);

    CustomerDetail getCustomerDetails(Long customerId);

    List<CustomerDetail> getCustomers();

    List<CustomerDetail> searchCustomer(String anyName);

    CustomerDetail updateCustomer(CustomerDetail request);
}
