package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.vehicle.VehicleModel;

import java.util.List;

public interface IVehicleService {
    Long create(VehicleModel request);

    VehicleModel getVehicleDetail(Long vehicleId);

    List<VehicleModel> getVehicles();
}
