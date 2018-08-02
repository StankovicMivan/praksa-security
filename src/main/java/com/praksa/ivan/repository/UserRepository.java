package com.praksa.ivan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praksa.ivan.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
