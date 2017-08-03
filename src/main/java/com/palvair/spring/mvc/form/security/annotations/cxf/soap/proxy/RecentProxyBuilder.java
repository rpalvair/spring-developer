package com.palvair.spring.mvc.form.security.annotations.cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class RecentProxyBuilder<T> {

	private T client;

	private String address;

	private Class<T> type;

	public RecentProxyBuilder(Class<T> type) {
		this.type = type;
	}

	public RecentProxyBuilder<T> setAddress(String address) {
		this.address = address;
		return this;
	}

	public T build() {
		if (this.address == null)
			throw new IllegalArgumentException("Address should not be null");
		JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
		jaxWsProxyFactory.setServiceClass(type);
		jaxWsProxyFactory.setAddress(address);
		this.client = (type.cast(jaxWsProxyFactory.create()));
		return this.client;
	}

}
