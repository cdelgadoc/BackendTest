package com.applydigital.challenge.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applydigital.challenge.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByEmail(String email);

}
