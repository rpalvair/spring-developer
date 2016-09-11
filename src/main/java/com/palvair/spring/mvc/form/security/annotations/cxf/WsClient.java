package com.palvair.spring.mvc.form.security.annotations.cxf;

public interface WsClient<T> {
	String NAMESPACE = "http://cxf.annotations.security.form.mvc.spring.palvair.com/";

	String EMPLOYEE_SERVICE_URL = "http://localhost:8080/spring-developer/cxf/employees";

	String EMPLOYEE_SERVICE_NAME = "WsEmployeeServiceImplService";
	
	T findById(Long id);
}
