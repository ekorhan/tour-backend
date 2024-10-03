package com.nahrok.tourbackend.controller;

import com.nahrok.tourbackend.model.CustomerDetailResponse;
import com.nahrok.tourbackend.model.tour.TourCreateRequest;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;
import com.nahrok.tourbackend.service.ITourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tour")
public class TourController {
    private final ITourService tourService;

    public TourController(ITourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/create")
    public Long tourCreate(@RequestBody TourCreateRequest request) {
        return tourService.tourCreate(request);
    }

    @PostMapping("/edit")
    public Long edit(@RequestBody TourCreateRequest request) {
        return tourService.tourEdit(request);
    }

    @GetMapping
    public TourDetailResponse tourDetail(@RequestParam("tourId") Long tourId) {
        return tourService.getTour(tourId);
    }

    @GetMapping("tours")
    public List<TourDetailResponse> getTour() {
        return tourService.tours();
    }

    @GetMapping("search")
    public List<TourDetailResponse> search(@RequestParam("anyName") String anyName) {
        return tourService.searchTour(anyName);
    }

}
