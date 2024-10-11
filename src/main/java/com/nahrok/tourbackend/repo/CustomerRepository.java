package com.nahrok.tourbackend.repo;

import com.nahrok.tourbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select c from CustomerEntity c where LOWER(c.firstName) like %:anyName% or LOWER(c.lastName) like %:anyName% or c.phoneNumber like %:anyName% ")
    List<CustomerEntity> searchCustomer(@Param("anyName") String anyName);

    List<CustomerEntity> findAllByIdIn(List<Long> id);
}
