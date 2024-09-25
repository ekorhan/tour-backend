package com.nahrok.tourbackend.mapper.driver;

import com.nahrok.tourbackend.entity.DriverEntity;
import com.nahrok.tourbackend.model.driver.DriverDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DriverDetailMapper {
    DriverEntity modelToEntity(DriverDetail model);

    DriverDetail entityToModel(DriverEntity entity);

    List<DriverEntity> modelToEntity(List<DriverDetail> models);

    List<DriverDetail> entityToModel(List<DriverEntity> entities);
}
