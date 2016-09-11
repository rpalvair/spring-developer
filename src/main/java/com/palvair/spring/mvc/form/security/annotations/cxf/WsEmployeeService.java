package com.palvair.spring.mvc.form.security.annotations.cxf;

import javax.jws.WebService;

import com.palvair.spring.mvc.form.security.annotations.model.Employee;

@WebService
public interface WsEmployeeService {

	Employee findById(Long id);
}
