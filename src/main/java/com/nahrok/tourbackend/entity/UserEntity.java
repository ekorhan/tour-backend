package com.nahrok.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class UserEntity extends BaseEntity {
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRoleEntity> roles = new HashSet<>();
}
