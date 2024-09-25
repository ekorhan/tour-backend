package com.nahrok.tourbackend.mapper.customer;

import com.nahrok.tourbackend.entity.CustomerEntity;
import com.nahrok.tourbackend.model.CreateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerCreateMapper {
    CustomerEntity modelToEntity(CreateCustomerRequest model);

    CreateCustomerRequest entityToModel(CustomerEntity entity);

    List<CustomerEntity> modelToEntity(List<CreateCustomerRequest> models);

    List<CreateCustomerRequest> entityToModel(List<CustomerEntity> entities);
}
