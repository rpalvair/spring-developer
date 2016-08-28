package com.palvair.spring.mvc.form.security.annotations.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractJpaDAO<T> implements IDAO<T>{

	protected JpaRepository<T,Long> repo;
	
	
	public T findOne(Long id) {
		return repo.findOne(id);
	}

	public T save(T t) {
		return repo.save(t);
	}
	

}
