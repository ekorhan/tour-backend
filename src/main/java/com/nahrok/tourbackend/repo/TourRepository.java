package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
    @Query("select t from TourEntity t where LOWER(t.tourName) like %:anyName% or LOWER(t.startDate) like %:anyName% ")
    List<TourEntity> searchTour(@Param("anyName") String anyName);
}
