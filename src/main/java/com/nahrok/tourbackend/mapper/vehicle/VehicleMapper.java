package com.nahrok.tourbackend.mapper.vehicle;

import com.nahrok.tourbackend.entity.VehicleEntity;
import com.nahrok.tourbackend.model.vehicle.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface VehicleMapper {

    VehicleEntity modelToEntity(VehicleModel model);

    VehicleModel entityToModel(VehicleEntity entity);

    List<VehicleEntity> modelToEntity(List<VehicleModel> models);

    List<VehicleModel> entityToModel(List<VehicleEntity> entities);
}
