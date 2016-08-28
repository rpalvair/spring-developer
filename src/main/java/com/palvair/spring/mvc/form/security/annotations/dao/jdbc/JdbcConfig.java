package com.palvair.spring.mvc.form.security.annotations.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcConfig {

	@Bean(name="jdbc")
	@Autowired
	public JdbcUsersDAO JdbcUsersDAO(@Qualifier("commonDs")javax.sql.DataSource ds) {
		JdbcUsersDAO dao = new JdbcUsersDAO();
		dao.setDataSource(ds);
		return dao;
	}
}
