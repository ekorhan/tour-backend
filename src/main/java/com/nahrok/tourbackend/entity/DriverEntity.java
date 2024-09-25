package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class DriverEntity extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String zip;
    private String country;
    private String gender;
    private Date dateOfBirth;
}
