package com.palvair.spring.mvc.form.security.annotations.dao;

public interface IDAO<T> {
	
	T findOne(Long id);
	
	T save(T t);

}
