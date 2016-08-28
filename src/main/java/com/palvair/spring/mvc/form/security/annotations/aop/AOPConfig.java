package com.palvair.spring.mvc.form.security.annotations.aop;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPConfig implements InitializingBean {

	@Bean
	public SaveEntityAspect logAspect() {
		return new SaveEntityAspect();
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " initialized");
	}
}
