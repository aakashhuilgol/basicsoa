package com.homeease.reviewservice.repository;

import com.homeease.reviewservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByProfesionalid(String ProfesionalId);
}
