package com.palvair.spring.mvc.form.security.annotations.cxf;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class OldProxyBuilder<T> {

	private T client;

	private URL wsdlUrl;

	private QName serviceName;

	private Class<T> type;

	public OldProxyBuilder(Class<T> type) {
		this.type = type;
	}

	public OldProxyBuilder<T> setWsdlUrl(URL wsdlUrl) {
		this.wsdlUrl = wsdlUrl;
		return this;
	}

	public OldProxyBuilder<T> setQName(QName qname) {
		this.serviceName = qname;
		return this;
	}

	public T build() {
		if (this.wsdlUrl == null || this.serviceName == null)
			throw new IllegalArgumentException("Url and QName should not be null");
		Service service = Service.create(this.wsdlUrl, this.serviceName);
		this.client = service.getPort(type);
		return this.client;
	}

}
