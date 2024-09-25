package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.TourCharValEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourCharValRepository extends JpaRepository<TourCharValEntity, Long> {
}
