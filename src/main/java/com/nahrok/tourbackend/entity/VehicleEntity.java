package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class VehicleEntity extends BaseEntity {
    private String plate;
    private int capacity;
    private String typeOfVehicle;
}
