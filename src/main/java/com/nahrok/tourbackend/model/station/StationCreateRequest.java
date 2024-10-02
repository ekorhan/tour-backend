package com.nahrok.tourbackend.model.station;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StationCreateRequest {
    private String stationName;
    private String stationType;
    private String address;
    private String city;
    private String district;
    private String zip;
    private String country;
}
