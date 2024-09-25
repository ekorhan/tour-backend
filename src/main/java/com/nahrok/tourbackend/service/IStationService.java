package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.station.StationCreateRequest;
import com.nahrok.tourbackend.model.station.StationDetail;

import java.util.List;

public interface IStationService {
    Long create(StationCreateRequest request);

    StationDetail getStation(Long stationId);

    List<StationDetail> getStations();
}
