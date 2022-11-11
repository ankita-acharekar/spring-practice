package com.deqode.backend2.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deqode.backend2.Model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{

	Users findByUsername(String username);
}
