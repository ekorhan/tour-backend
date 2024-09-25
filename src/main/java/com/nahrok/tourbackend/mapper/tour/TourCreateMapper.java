package com.nahrok.tourbackend.mapper.tour;

import com.nahrok.tourbackend.entity.TourEntity;
import com.nahrok.tourbackend.model.tour.TourCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TourCreateMapper {
    TourEntity modelToEntity(TourCreateRequest model);

    TourCreateRequest entityToModel(TourEntity entity);

    List<TourEntity> modelToEntity(List<TourCreateRequest> models);

    List<TourCreateRequest> entityToModel(List<TourEntity> entities);
}
