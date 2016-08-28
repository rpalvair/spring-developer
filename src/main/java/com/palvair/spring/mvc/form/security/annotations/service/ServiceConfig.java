package com.palvair.spring.mvc.form.security.annotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.palvair.spring.mvc.form.security.annotations.dao.IDAO;
import com.palvair.spring.mvc.form.security.annotations.model.User;

@Component
public class ServiceConfig {
	@Autowired
	@Bean
	public UsersService UsersService(@Qualifier("jpa") IDAO<User> dao) {
		UsersService usersService = new UsersService();
		usersService.setDao(dao);
		return usersService;
	}
}
