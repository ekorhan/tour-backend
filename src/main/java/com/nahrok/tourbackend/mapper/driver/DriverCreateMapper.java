package com.nahrok.tourbackend.mapper.driver;

import com.nahrok.tourbackend.entity.DriverEntity;
import com.nahrok.tourbackend.model.driver.DriverCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DriverCreateMapper {
    DriverEntity modelToEntity(DriverCreateRequest model);

    DriverCreateRequest entityToModel(DriverEntity entity);

    List<DriverEntity> modelToEntity(List<DriverCreateRequest> models);

    List<DriverCreateRequest> entityToModel(List<DriverEntity> entities);
}
