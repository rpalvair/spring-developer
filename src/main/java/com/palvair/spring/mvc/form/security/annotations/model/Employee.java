package com.palvair.spring.mvc.form.security.annotations.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="employee")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	private int age;
	
}
