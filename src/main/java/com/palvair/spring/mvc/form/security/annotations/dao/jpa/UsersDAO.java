package com.palvair.spring.mvc.form.security.annotations.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.palvair.spring.mvc.form.security.annotations.dao.AbstractJpaDAO;
import com.palvair.spring.mvc.form.security.annotations.model.User;

@Repository(value = "jpa")
public class UsersDAO extends AbstractJpaDAO<User>{

	@Autowired
	public UsersDAO(UsersRepository usersRepository) {
		this.repo = usersRepository;
	}
	

}
