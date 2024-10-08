package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class TourCharValEntity extends BaseEntity {
    private Long tourId;
    private Long charId;
    private Class<?> valType;
    private String val;
}
