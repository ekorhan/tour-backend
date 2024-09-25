package com.nahrok.tourbackend.mapper.station;

import com.nahrok.tourbackend.entity.StationEntity;
import com.nahrok.tourbackend.model.station.StationCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface StationCreateMapper {
    StationEntity modelToEntity(StationCreateRequest model);

    StationCreateRequest entityToModel(StationEntity entity);

    List<StationEntity> modelToEntity(List<StationCreateRequest> models);

    List<StationCreateRequest> entityToModel(List<StationEntity> entities);
}
