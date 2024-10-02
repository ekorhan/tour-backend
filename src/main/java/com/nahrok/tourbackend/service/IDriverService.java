package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.driver.DriverCreateRequest;
import com.nahrok.tourbackend.model.driver.DriverDetail;

import java.util.List;

public interface IDriverService {
    Long create(DriverCreateRequest request);

    DriverDetail getDriverDetail(Long driverId);

    List<DriverDetail> getDrivers();
}
