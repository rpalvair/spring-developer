package com.palvair.spring.mvc.form.security.annotations.cxf;

import com.palvair.spring.mvc.form.security.annotations.model.Employee;

public class WsEmployeeServiceRecentClient implements WsEmployeeService, WsClient<Employee> {

	private WsEmployeeService client;

	private final RecentProxyBuilder<WsEmployeeService> builder = new RecentProxyBuilder<>(WsEmployeeService.class);

	public WsEmployeeServiceRecentClient() {
		builder.setAddress(EMPLOYEE_SERVICE_URL);
		client = builder.build();
	}

	@Override
	public Employee findById(Long id) {
		return client.findById(id);
	}
}
