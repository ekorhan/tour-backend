package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
}
