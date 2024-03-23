package com.register.person.repository;

import com.register.person.models.Register;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegisterRepositoryMongo extends MongoRepository<Register, String> {
}
