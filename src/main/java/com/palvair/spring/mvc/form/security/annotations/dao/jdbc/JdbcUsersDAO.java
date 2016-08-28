package com.palvair.spring.mvc.form.security.annotations.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.palvair.spring.mvc.form.security.annotations.dao.IDAO;
import com.palvair.spring.mvc.form.security.annotations.model.User;

public class JdbcUsersDAO implements IDAO<User> {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public User findOne(Long id) {
		return this.jdbcTemplate.queryForObject("select * from users where id = ?", new Object[] { id },
				new UserMapper());
	}

	public User save(User t) {
		this.jdbcTemplate.update("update users set firstname = ?, lastname = ?, age = ? where id = ?", t.getFirstname(),
				t.getLastname(), t.getAge(), t.getId());
		return null;
	}

	private final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setAge(rs.getInt("age"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setId(rs.getLong("id"));
			return user;
		}

	}
}
