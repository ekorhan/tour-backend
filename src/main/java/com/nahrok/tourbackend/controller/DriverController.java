package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.driver.DriverCreateRequest;
import com.nahrok.tourbackend.model.driver.DriverDetail;
import com.nahrok.tourbackend.service.IDriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
public class DriverController {
    private final IDriverService driverService;

    public DriverController(IDriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/create")
    public Long create(@RequestBody DriverCreateRequest request) {
        return driverService.create(request);
    }

    @GetMapping
    public DriverDetail driverDetail(@RequestParam("driverId") Long driverId) {
        return driverService.getDriverDetail(driverId);
    }

}
