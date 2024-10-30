package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.UserEntity;
import com.nahrok.tourbackend.entity.UserRoleEntity;
import com.nahrok.tourbackend.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        UserDetails details = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().stream()
                        .map(UserRoleEntity::getCode)
                        .toArray(String[]::new))
                .build();

        return details;
    }
}
