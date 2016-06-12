package com.daykm.data;

import com.daykm.domain.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepository {

	private JdbcOperations jdbc;

	@Autowired
	public UserRepoImpl(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public SiteUser save(SiteUser user) {
		jdbc.update(
				"insert into SiteUser (first_name, last_name, password, email) values (?, ?, ?, ?)",
				user.getFirstName(),
				user.getLastName(),
				user.getPassword(),
				user.getEmail()
		);
		return user;
	}

	@Override
	public SiteUser findByFirstName(String firstName) {
		return jdbc.queryForObject(
				"select * from SiteUser where first_name=?",
				new UserRowMapper(),
				firstName
		);
	}

	@Override
	public List<SiteUser> list() {
		return jdbc.query("select * from SiteUser", new UserRowMapper());
	}

	private static class UserRowMapper implements RowMapper<SiteUser> {
		@Override
		public SiteUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new SiteUser(
					rs.getLong("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("password"),
					rs.getString("email")
			);
		}
	}
}
