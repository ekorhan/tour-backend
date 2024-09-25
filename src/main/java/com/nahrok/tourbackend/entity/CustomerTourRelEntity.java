package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class CustomerTourRelEntity extends BaseEntity {
    @ManyToOne(targetEntity = CustomerEntity.class)
    private Long customerId;
    @ManyToOne(targetEntity = TourEntity.class)
    private Long tourId;
    @OneToOne(targetEntity = PaymentEntity.class)
    private Long paymentId;
}
