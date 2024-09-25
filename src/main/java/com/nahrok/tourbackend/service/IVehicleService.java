package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.vehicle.VehicleModel;

public interface IVehicleService {
    Long create(VehicleModel request);

    VehicleModel getVehicleDetail(Long vehicleId);
}
