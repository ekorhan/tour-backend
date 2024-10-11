package com.nahrok.tourbackend.entity;

import jakarta.persistence.*;
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
