package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.DriverEntity;
import com.nahrok.tourbackend.entity.TourCharValEntity;
import com.nahrok.tourbackend.entity.TourEntity;
import com.nahrok.tourbackend.general.EnumGnlChars;
import com.nahrok.tourbackend.mapper.tour.TourCreateMapper;
import com.nahrok.tourbackend.mapper.tour.TourDetailMapper;
import com.nahrok.tourbackend.mapper.vehicle.VehicleMapper;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public TourServiceImpl(TourRepository tourRepository,
                           TourCharValRepository tourCharValRepository, VehicleRepository vehicleRepository, DriverRepository driverRepository, IStationService stationService,
                           TourCreateMapper tourCreateMapper,
                           TourDetailMapper tourDetailMapper, VehicleMapper vehicleMapper) {
        this.tourRepository = tourRepository;
        this.tourCharValRepository = tourCharValRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
        this.stationService = stationService;
        this.tourCreateMapper = tourCreateMapper;
        this.tourDetailMapper = tourDetailMapper;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long tourCreate(TourCreateRequest request) {
        TourEntity tourEntity = tourCreateMapper.modelToEntity(request);

        tourEntity = tourRepository.save(tourEntity);

        Long tourId = tourEntity.getId();

        List<TourCharValEntity> charValEntities = new ArrayList<>();
        Map<EnumGnlChars.TourChars, String> valMap = EnumGnlChars.TourChars.valMap(request.getCharVal());
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

        return tourId;
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

    private TourDetailResponse getTourResponse(TourEntity e) {
        TourDetailResponse r = tourDetailMapper.entityToModel(e);
        Optional<DriverEntity> driver = driverRepository.findById(e.getDriverId());
        if (driver.isPresent()) {
            DriverEntity driverEntity = driver.get();
            r.setDriverName(driverEntity.getFirstName() + " " + driverEntity.getLastName());
        }
        StationDetail startingStation = stationService.getStation(e.getStartingStationId());
        StationDetail destination = stationService.getStation(e.getDestinationId());
        r.setStartingStation(startingStation.getStationName());
        r.setDestination(destination.getStationName());

        r.setVehicle(vehicleRepository.findById(e.getVehicleId()).map(vehicleMapper::entityToModel).orElse(null));
        return r;
    }
}
