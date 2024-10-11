package com.nahrok.tourbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class CustomerTourRelEntity extends BaseEntity {
    @Column
    private Long customerId;
    @Column
    private Long tourId;
    @Column
    private Long paymentId;
}
