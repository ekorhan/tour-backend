package com.nahrok.tourbackend.entity;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
@Hidden
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Date created = new Date();
    private Date updated = new Date();
    private long createdBy = 1L;
    private long updatedBy = 1L;
}
