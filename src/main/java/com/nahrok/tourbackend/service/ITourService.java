package com.nahrok.tourbackend.service;

import com.nahrok.tourbackend.model.tour.TourCreateRequest;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;

import java.util.List;

public interface ITourService {
    Long tourCreate(TourCreateRequest request);

    TourDetailResponse getTour(Long tourId);

    List<TourDetailResponse> tours();
}
