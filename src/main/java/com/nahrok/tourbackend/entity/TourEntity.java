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
    private Long startingStationId;
    private Long destinationId;
    private Long vehicleId;
    private Long driverId;
}
