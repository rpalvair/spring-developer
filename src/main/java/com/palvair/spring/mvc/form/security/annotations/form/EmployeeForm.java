package com.palvair.spring.mvc.form.security.annotations.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmployeeForm {

	@NotEmpty
	@Size(min=2, max=100)
	private String name;
}
