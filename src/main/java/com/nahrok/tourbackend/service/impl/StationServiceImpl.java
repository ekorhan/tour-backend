package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.StationEntity;
import com.nahrok.tourbackend.mapper.station.StationCreateMapper;
import com.nahrok.tourbackend.mapper.station.StationDetailMapper;
import com.nahrok.tourbackend.model.station.StationCreateRequest;
import com.nahrok.tourbackend.model.station.StationDetail;
import com.nahrok.tourbackend.repo.StationRepository;
import com.nahrok.tourbackend.service.IStationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements IStationService {
    private final StationRepository stationRepository;
    private final StationCreateMapper stationCreateMapper;
    private final StationDetailMapper stationDetailMapper;

    public StationServiceImpl(StationRepository stationRepository,
                              StationCreateMapper stationCreateMapper,
                              StationDetailMapper stationDetailMapper) {
        this.stationRepository = stationRepository;
        this.stationCreateMapper = stationCreateMapper;
        this.stationDetailMapper = stationDetailMapper;
    }

    @Override
    public Long create(StationCreateRequest request) {
        return stationRepository.save(stationCreateMapper.modelToEntity(request)).getId();
    }

    @Override
    public StationDetail getStation(Long stationId) {
        Optional<StationEntity> entity = stationRepository.findById(stationId);
        return entity.map(stationDetailMapper::entityToModel).orElse(null);
    }

    @Override
    public List<StationDetail> getStations() {
        List<StationEntity> stationEntities = stationRepository.findAll();
        return stationDetailMapper.entityToModel(stationEntities);
    }
}
