package com.nahrok.tourbackend.mapper.customer;

import com.nahrok.tourbackend.entity.CustomerEntity;
import com.nahrok.tourbackend.model.CustomerDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerDetailMapper {

    CustomerEntity modelToEntity(CustomerDetail model);

    CustomerDetail entityToModel(CustomerEntity entity);

    List<CustomerEntity> modelToEntity(List<CustomerDetail> models);

    List<CustomerDetail> entityToModel(List<CustomerEntity> entities);
}
