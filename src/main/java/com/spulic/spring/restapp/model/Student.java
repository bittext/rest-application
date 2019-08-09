package com.spulic.spring.restapp.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="student")
public class Student {
	@JsonProperty("id")
	@Indexed
	private String id;
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private Integer age;
	
	
}
