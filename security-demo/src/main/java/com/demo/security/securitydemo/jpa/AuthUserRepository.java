package com.demo.security.securitydemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
    List<AuthUser> findByUsername(String userName);
}
