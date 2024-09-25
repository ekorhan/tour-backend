package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
