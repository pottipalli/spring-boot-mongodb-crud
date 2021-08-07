package com.guru.springbootmongodbcrud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guru.springbootmongodbcrud.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
