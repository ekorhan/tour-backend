package com.nahrok.tourbackend.model.customer_tour;

import lombok.Data;

@Data
public class Payment {
    private Double deposit;
    private Double paid;
    private Double totalAmount;
    private Double remainingAmount;
}
