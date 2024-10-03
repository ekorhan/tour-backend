package com.nahrok.tourbackend.model.tour;

import com.nahrok.tourbackend.model.driver.DriverDetail;
import com.nahrok.tourbackend.model.station.StationDetail;
import com.nahrok.tourbackend.model.vehicle.VehicleModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TourDetailResponse {
    private Long id;
    private String tourName;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String tourDescription;
    private String tourImage;
    private StationDetail startingStation;
    private StationDetail destination;
    private VehicleModel vehicle;
    private DriverDetail driver;
    private String tourPrice;
    private String tourCategory;
    private String tourType;
    private Integer capacity;
}
