package com.nahrok.tourbackend.model;

import lombok.Data;

@Data
public class UpdatePaymentRequest {
    private Long id;
    private Long customerId;
    private Long tourId;
    private Double amount;
}
