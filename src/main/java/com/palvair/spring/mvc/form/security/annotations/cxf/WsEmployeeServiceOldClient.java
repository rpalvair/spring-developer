package com.palvair.spring.mvc.form.security.annotations.cxf;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.palvair.spring.mvc.form.security.annotations.model.Employee;

public class WsEmployeeServiceOldClient implements WsEmployeeService, WsClient<Employee> {

	private WsEmployeeService client;

	private final OldProxyBuilder<WsEmployeeService> builder = new OldProxyBuilder<>(WsEmployeeService.class);

	private URL url;

	private QName qname;

	public WsEmployeeServiceOldClient() throws MalformedURLException {
		initClient();
	}

	private void initClient() throws MalformedURLException {
		try {
			this.url = new URL(EMPLOYEE_SERVICE_URL + "?wsdl");
			this.qname = new QName(NAMESPACE, EMPLOYEE_SERVICE_NAME);
			client = builder.setQName(this.qname).setWsdlUrl(this.url).build();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public Employee findById(Long id) {
		return client.findById(id);
	}
}
