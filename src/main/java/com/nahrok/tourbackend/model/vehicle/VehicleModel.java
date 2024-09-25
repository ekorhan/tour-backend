package com.nahrok.tourbackend.model.vehicle;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VehicleModel {
    private String plate;
    private int capacity;
    private String typeOfVehicle;
}
