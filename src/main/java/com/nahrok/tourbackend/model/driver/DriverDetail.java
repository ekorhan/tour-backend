package com.nahrok.tourbackend.model.driver;

import lombok.Data;

@Data
public class DriverDetail {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String zip;
    private String country;
    private String gender;
    private String dateOfBirth;
}
