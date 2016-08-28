package com.palvair.spring.mvc.form.security.annotations.service;

import org.springframework.transaction.annotation.Transactional;

import com.palvair.spring.mvc.form.security.annotations.dao.IDAO;
import com.palvair.spring.mvc.form.security.annotations.model.User;

public class UsersService {

	private IDAO<User> dao;

	public void setDao(IDAO<User> dao) {
		this.dao = dao;
	}

	// rollback pour les RuntimeException par défaut
	@Transactional(rollbackFor = { Exception.class })
	public void incrementAge(boolean throwError) throws Exception {
		User user = dao.findOne(1L);
		if (user != null) {
			user.setAge(user.getAge() + 1);
			dao.save(user);
			if (throwError)
				throw new Exception("rollback because exception");
		}
	}

}
