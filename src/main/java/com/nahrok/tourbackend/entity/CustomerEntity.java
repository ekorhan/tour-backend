package com.nahrok.tourbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class CustomerEntity extends BaseEntity {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String countryCode;

    @Column
    private String phoneNumber;
}
