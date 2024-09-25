package com.nahrok.tourbackend.model.customer_tour;

import lombok.Data;

@Data
public class CreateCustomerTourRequest {
    private Long customerId;
    private Long tourId;
    private Payment payment;
}

