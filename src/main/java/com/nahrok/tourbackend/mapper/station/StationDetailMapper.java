package com.nahrok.tourbackend.mapper.station;

import com.nahrok.tourbackend.entity.StationEntity;
import com.nahrok.tourbackend.model.station.StationDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface StationDetailMapper {
    StationEntity modelToEntity(StationDetail model);

    StationDetail entityToModel(StationEntity entity);

    List<StationEntity> modelToEntity(List<StationDetail> models);

    List<StationDetail> entityToModel(List<StationEntity> entities);
}
