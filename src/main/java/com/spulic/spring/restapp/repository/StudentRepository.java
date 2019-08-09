package com.spulic.spring.restapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spulic.spring.restapp.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>, IStudentCollection {
	
}
