package com.nahrok.tourbackend.model.driver;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DriverCreateRequest {
    private String firstName;
    private String lastName;
    private String countryCode;
    private String phoneNumber;
    private String address;
    private String city;
    private String zip;
    private String country;
    private String gender;
    private String dateOfBirth;
}
