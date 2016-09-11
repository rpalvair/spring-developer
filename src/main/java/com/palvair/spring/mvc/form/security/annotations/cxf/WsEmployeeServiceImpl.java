package com.palvair.spring.mvc.form.security.annotations.cxf;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palvair.spring.mvc.form.security.annotations.dao.jpa.EmployeeRepository;
import com.palvair.spring.mvc.form.security.annotations.model.Employee;

@Component
@WebService(endpointInterface = "com.palvair.spring.mvc.form.security.annotations.cxf.WsEmployeeService")
public class WsEmployeeServiceImpl implements WsEmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee findById(Long id) {
		Employee employee = repository.findOne(id);
		return employee;
	}

}
