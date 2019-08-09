package com.spulic.spring.restapp.repository;

import java.util.List;
import java.util.Optional;

import com.spulic.spring.restapp.model.Student;

public interface IStudentCollection {
	
	public Optional<List<Student>> findByLastName(String lastName);
	
	public Optional<List<Student>> findByAge(Integer age);
	
//	public Optional<List<Student>> findAll();
}
