package com.example.booking.repositories;

import com.example.booking.enities.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByEmail(String email);
    boolean existsByEmail(String email);
}
