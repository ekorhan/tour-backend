package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.vehicle.VehicleModel;
import com.nahrok.tourbackend.service.IVehicleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
public class VehicleController {
    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public Long create(@RequestBody VehicleModel request) {
        return vehicleService.create(request);
    }

    @GetMapping
    public VehicleModel vehicleDetail(@RequestParam("vehicleId") Long vehicleId) {
        return vehicleService.getVehicleDetail(vehicleId);
    }
}
