package com.palvair.spring.mvc.form.security.annotations.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palvair.spring.mvc.form.security.annotations.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
