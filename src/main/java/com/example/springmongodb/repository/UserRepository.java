package com.example.springmongodb.repository;

import com.example.springmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author "Husniddin Ulachov"
 * @created 4:55 PM on 7/23/2022
 * @project spring-mongodb
 */
public interface UserRepository extends MongoRepository<User,String> {
     User findByFullNameContainingIgnoreCase(String fullName);

}
