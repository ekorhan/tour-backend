package com.nahrok.tourbackend.model.station;

import lombok.Data;

@Data
public class StationDetail {
    private Long id;
    private String stationName;
    private String stationType;
    private String address;
    private String city;
    private String district;
    private String zip;
    private String country;
}
