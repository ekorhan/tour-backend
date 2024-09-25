package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Long> {
}
