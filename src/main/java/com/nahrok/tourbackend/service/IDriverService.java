package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.driver.DriverCreateRequest;
import com.nahrok.tourbackend.model.driver.DriverDetail;

public interface IDriverService {
    Long create(DriverCreateRequest request);

    DriverDetail getDriverDetail(Long driverId);
}
