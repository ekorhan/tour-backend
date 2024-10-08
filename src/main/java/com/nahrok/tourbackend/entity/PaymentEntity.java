package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class PaymentEntity extends BaseEntity {
    private Double deposit;
    private Double paid;
    private Double totalAmount;
    private Double remainingAmount;
}
