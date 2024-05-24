package com.homeease.registrationservice.repository;

import com.homeease.registrationservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RegistrationRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    Optional<User> findById(String id);
}
