package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.TourCharValEntity;
import com.nahrok.tourbackend.entity.TourEntity;
import com.nahrok.tourbackend.general.EnumGnlChars;
import com.nahrok.tourbackend.mapper.driver.DriverDetailMapper;
import com.nahrok.tourbackend.mapper.tour.TourCreateMapper;
import com.nahrok.tourbackend.mapper.tour.TourDetailMapper;
import com.nahrok.tourbackend.mapper.vehicle.VehicleMapper;
import com.nahrok.tourbackend.model.CharVal;
import com.nahrok.tourbackend.model.station.StationDetail;
import com.nahrok.tourbackend.model.tour.TourCreateRequest;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;
import com.nahrok.tourbackend.repo.DriverRepository;
import com.nahrok.tourbackend.repo.TourCharValRepository;
import com.nahrok.tourbackend.repo.TourRepository;
import com.nahrok.tourbackend.repo.VehicleRepository;
import com.nahrok.tourbackend.service.IStationService;
import com.nahrok.tourbackend.service.ITourService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TourServiceImpl implements ITourService {
    private final TourRepository tourRepository;

    private final TourCharValRepository tourCharValRepository;

    private final VehicleRepository vehicleRepository;

    private final DriverRepository driverRepository;

    private final IStationService stationService;

    private final TourCreateMapper tourCreateMapper;

    private final TourDetailMapper tourDetailMapper;

    private final VehicleMapper vehicleMapper;

    private final DriverDetailMapper driverDetailMapper;

    public TourServiceImpl(TourRepository tourRepository,
                           TourCharValRepository tourCharValRepository, VehicleRepository vehicleRepository, DriverRepository driverRepository, IStationService stationService,
                           TourCreateMapper tourCreateMapper,
                           TourDetailMapper tourDetailMapper, VehicleMapper vehicleMapper, DriverDetailMapper driverDetailMapper) {
        this.tourRepository = tourRepository;
        this.tourCharValRepository = tourCharValRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
        this.stationService = stationService;
        this.tourCreateMapper = tourCreateMapper;
        this.tourDetailMapper = tourDetailMapper;
        this.vehicleMapper = vehicleMapper;
        this.driverDetailMapper = driverDetailMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long tourCreate(TourCreateRequest request) {
        TourEntity tourEntity = tourCreateMapper.modelToEntity(request);

        tourEntity = tourRepository.save(tourEntity);

        Long tourId = tourEntity.getId();

        addTourCharVal(tourId, request.getCharVal());

        return tourId;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long tourEdit(TourCreateRequest request) {
        return tourCreate(request);
    }

    private void addTourCharVal(Long tourId, List<CharVal> charVal) {
        List<TourCharValEntity> charValEntities = new ArrayList<>();
        Map<EnumGnlChars.TourChars, String> valMap = EnumGnlChars.TourChars.valMap(charVal);
        for (Map.Entry<EnumGnlChars.TourChars, String> entry : valMap.entrySet()) {
            TourCharValEntity charValEntity = new TourCharValEntity();
            EnumGnlChars.TourChars tourChar = entry.getKey();
            charValEntity.setTourId(tourId);
            charValEntity.setCharId(tourChar.getId());
            charValEntity.setVal(entry.getValue());
            charValEntity.setValType(tourChar.getClazz());

            charValEntities.add(charValEntity);
        }
        tourCharValRepository.saveAll(charValEntities);
    }

    @Override
    public TourDetailResponse getTour(Long tourId) {
        Optional<TourEntity> entity = tourRepository.findById(tourId);

        return entity.map(this::getTourResponse).orElse(null);
    }

    @Override
    public List<TourDetailResponse> tours() {
        List<TourEntity> tourEntity = tourRepository.findAll();
        List<TourDetailResponse> response = new ArrayList<>();

        for (TourEntity e : tourEntity) {
            getTourResponse(e);
            TourDetailResponse r = getTourResponse(e);
            response.add(r);
        }


        return response;
    }

    @Override
    public List<TourDetailResponse> searchTour(String anyName) {
        return tourDetailMapper.entityToModel(tourRepository.searchTour(anyName.toLowerCase(Locale.ROOT)));
    }

    private TourDetailResponse getTourResponse(TourEntity e) {
        TourDetailResponse r = tourDetailMapper.entityToModel(e);
        r.setDriver(driverRepository.findById(e.getDriverId()).map(driverDetailMapper::entityToModel).orElse(null));
        StationDetail startingStation = stationService.getStation(e.getStartingStationId());
        r.setStartingStation(startingStation);
        StationDetail destination = stationService.getStation(e.getDestinationId());
        r.setDestination(destination);

        r.setVehicle(vehicleRepository.findById(e.getVehicleId()).map(vehicleMapper::entityToModel).orElse(null));
        return r;
    }
}
