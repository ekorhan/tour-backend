package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.DriverEntity;
import com.nahrok.tourbackend.mapper.driver.DriverCreateMapper;
import com.nahrok.tourbackend.mapper.driver.DriverDetailMapper;
import com.nahrok.tourbackend.model.driver.DriverCreateRequest;
import com.nahrok.tourbackend.model.driver.DriverDetail;
import com.nahrok.tourbackend.repo.DriverRepository;
import com.nahrok.tourbackend.service.IDriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements IDriverService {
    private final DriverRepository driverRepository;
    private final DriverCreateMapper driverCreateMapper;
    private final DriverDetailMapper driverDetailMapper;

    public DriverServiceImpl(DriverCreateMapper driverCreateMapper,
                             DriverRepository driverRepository,
                             DriverDetailMapper driverDetailMapper) {
        this.driverCreateMapper = driverCreateMapper;
        this.driverRepository = driverRepository;
        this.driverDetailMapper = driverDetailMapper;
    }

    @Override
    public Long create(DriverCreateRequest request) {
        DriverEntity entity = driverCreateMapper.modelToEntity(request);
        return driverRepository.save(entity).getId();
    }

    @Override
    public DriverDetail getDriverDetail(Long driverId) {
        Optional<DriverEntity> entity = driverRepository.findById(driverId);
        return entity.map(driverDetailMapper::entityToModel).orElse(null);
    }

    @Override
    public List<DriverDetail> getDrivers() {
        return driverDetailMapper.entityToModel(driverRepository.findAll());
    }
}
