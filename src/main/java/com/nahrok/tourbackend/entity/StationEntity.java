package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class StationEntity extends BaseEntity {
    private String stationName;
    private String stationType;
    private String address;
    private String city;
    private String district;
    private String zip;
    private String country;
}
