package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.CustomerTourRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerTourRelRepository extends JpaRepository<CustomerTourRelEntity, Long> {

    @Query("select e from CustomerTourRelEntity e where e.id=:id or (e.customerId=:customerId and e.tourId=:tourId)")
    CustomerTourRelEntity findByIdOrCustomerAndTourId(@Param("id") Long id,
                                                      @Param("customerId") Long customerId,
                                                      @Param("tourId") Long tourId);

    List<CustomerTourRelEntity> findByTourId(Long tourId);
}
