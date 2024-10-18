package com.nahrok.tourbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetail {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String countryCode;
    private String phoneNumber;
}
