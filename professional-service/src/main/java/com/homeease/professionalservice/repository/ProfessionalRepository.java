package com.homeease.professionalservice.repository;

import com.homeease.professionalservice.pros.Professional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessionalRepository extends MongoRepository<Professional,String> {

}
