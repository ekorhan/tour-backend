package com.nahrok.tourbackend.controller;


import com.nahrok.tourbackend.model.station.StationCreateRequest;
import com.nahrok.tourbackend.model.station.StationDetail;
import com.nahrok.tourbackend.service.IStationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("station")
public class StationController {
    private final IStationService stationService;

    public StationController(IStationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/create")
    public Long create(@RequestBody StationCreateRequest request) {
        return stationService.create(request);
    }

    @GetMapping
    public StationDetail stationDetail(@RequestParam("stationId") Long stationId) {
        return stationService.getStation(stationId);
    }

    @GetMapping("/stations")
    public List<StationDetail> stations() {
        return stationService.getStations();
    }
}
