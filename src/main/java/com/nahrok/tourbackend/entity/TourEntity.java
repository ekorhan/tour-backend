package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class TourEntity extends BaseEntity {
    private String tourName;
    private String tourDescription;
    private String tourImage;
    private String tourPrice;
    private String tourCategory;
    private String tourType;
    private Integer capacity;

    @ManyToOne(targetEntity = StationEntity.class)
    private Long startingStationId;

    @ManyToOne(targetEntity = StationEntity.class)
    private Long destinationId;

    @ManyToOne(targetEntity = VehicleEntity.class)
    private Long vehicleId;

    @ManyToOne(targetEntity = DriverEntity.class)
    private Long driverId;
}
