package com.palvair.spring.mvc.form.security.annotations.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palvair.spring.mvc.form.security.annotations.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}
