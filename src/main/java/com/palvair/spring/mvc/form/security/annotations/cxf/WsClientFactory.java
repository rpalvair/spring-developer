package com.palvair.spring.mvc.form.security.annotations.cxf;

import java.net.MalformedURLException;

import org.springframework.stereotype.Component;

import com.palvair.spring.mvc.form.security.annotations.model.Employee;

@Component
public class WsClientFactory {

	public WsClient<Employee> getEmployeeRecentClient() {
		return new WsEmployeeServiceRecentClient();
	}

	public WsClient<Employee> getEmployeeOldClient() throws MalformedURLException {
		return new WsEmployeeServiceOldClient();
	}
}
