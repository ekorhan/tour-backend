package com.nahrok.tourbackend.mapper.tour;

import com.nahrok.tourbackend.entity.TourEntity;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TourDetailMapper {
    TourEntity modelToEntity(TourDetailResponse model);

    TourDetailResponse entityToModel(TourEntity entity);

    List<TourEntity> modelToEntity(List<TourDetailResponse> models);

    List<TourDetailResponse> entityToModel(List<TourEntity> entities);
}
