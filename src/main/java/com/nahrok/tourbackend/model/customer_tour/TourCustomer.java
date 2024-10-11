package com.nahrok.tourbackend.model.customer_tour;

import lombok.Data;

@Data
public class TourCustomer {
    private Long id;
    private String passengerName;
    private String birthDate;
    private String phoneNumber;
    private String eMail;
    private String identity;
}
