package com.nahrok.tourbackend.model.tour;

import com.nahrok.tourbackend.model.CharVal;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TourCreateRequest {
    private Long id;
    private String tourName;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String tourDescription;
    private String tourImage;
    private Long startingStationId;
    private Long destinationId;
    private Long vehicleId;
    private Long driverId;
    private String tourPrice;
    private String tourCategory;
    private String tourType;
    private Integer capacity;

    private List<CharVal> charVal;
    private String season;
    private String accommodation;
    private String visa;
    private String gift;
}
