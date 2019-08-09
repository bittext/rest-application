package com.spulic.spring.restapp.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spulic.spring.restapp.model.Student;
import com.spulic.spring.restapp.repository.StudentRepository;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
	
	private static final Logger logger = Logger.getLogger(StudentController.class.getName());
	
	@Autowired
	private StudentRepository studentRepository;
	
	private ThreadLocal threadLocal;
	
	@GetMapping(path="/", produces="application/json")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@PutMapping(path="/", consumes="application/json", produces="application/json")
	public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();
		
		threadLocal = new ThreadLocal();
		threadLocal.set(student.getFirstName());
		
		logger.info("in save student put request ...");
		
		method1();
		
		logger.info("method1 call completed");
		
		method2();
		
		logger.info("method2 call completed");
		
		//save to the student collection
		studentRepository.save(student);
		return ResponseEntity.created(location).build();
	}
	
	private void method1() {
		logger.info("method1 call in-progress");
		logger.info(threadLocal.get());
		
	}
	private void method2() {
		logger.info("method2 call in-progress");
		logger.info(threadLocal.get());
		
	}


	
	
	

}
