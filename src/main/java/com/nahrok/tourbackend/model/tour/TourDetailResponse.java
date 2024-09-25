package com.nahrok.tourbackend.model.tour;

import com.nahrok.tourbackend.model.vehicle.VehicleModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TourDetailResponse {
    private Long id;
    private String tourName;
    private String tourDescription;
    private String tourImage;
    private String startingStation;
    private String destination;
    private VehicleModel vehicle;
    private String driverName;
    private String tourPrice;
    private String tourCategory;
    private String tourType;
    private Integer capacity;
}
