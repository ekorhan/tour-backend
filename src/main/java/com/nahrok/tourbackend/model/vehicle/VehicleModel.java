package com.nahrok.tourbackend.model.vehicle;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VehicleModel {
    private Long id;
    private String vehicleName;
    private String plate;
    private int capacity;
    private String typeOfVehicle;
}
