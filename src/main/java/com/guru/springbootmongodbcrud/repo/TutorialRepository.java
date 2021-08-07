package com.guru.springbootmongodbcrud.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guru.springbootmongodbcrud.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByPublished(boolean published);
}
