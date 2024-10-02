package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.VehicleEntity;
import com.nahrok.tourbackend.mapper.vehicle.VehicleMapper;
import com.nahrok.tourbackend.model.vehicle.VehicleModel;
import com.nahrok.tourbackend.repo.VehicleRepository;
import com.nahrok.tourbackend.service.IVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public Long create(VehicleModel request) {
        return vehicleRepository.save(vehicleMapper.modelToEntity(request)).getId();
    }

    @Override
    public VehicleModel getVehicleDetail(Long vehicleId) {
        Optional<VehicleEntity> entity = vehicleRepository.findById(vehicleId);
        return entity.map(vehicleMapper::entityToModel).orElse(null);
    }

    @Override
    public List<VehicleModel> getVehicles() {
        return vehicleMapper.entityToModel(vehicleRepository.findAll());
    }
}
