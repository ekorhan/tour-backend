package com.nahrok.tourbackend.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CreateCustomerRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String countryCode;
    private String phoneNumber;
}
