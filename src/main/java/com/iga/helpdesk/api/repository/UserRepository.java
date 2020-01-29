package com.iga.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iga.helpdesk.api.security.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

}