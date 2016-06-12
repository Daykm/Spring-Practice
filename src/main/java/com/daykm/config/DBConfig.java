package com.daykm.config;


import com.daykm.data.UserRepository;
import com.daykm.domain.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Configuration
@ComponentScan("com.daykm.data")
public class DBConfig {

	@Autowired
	UserRepository repo;

	@Bean
	@Profile("dev")
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("data/schema.sql")
				.build();
	}

	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@PostConstruct
	@Autowired
	@Profile("dev")
	public void initializeTestData() {
		for(SiteUser user : getTestUsers(10)) {
			repo.save(user);
		}
	}



	private List<SiteUser> getTestUsers(int count) {
		ArrayList<SiteUser> users = new ArrayList<>(count);
		for(int i = 0; i < count; i++) {
			users.add(new SiteUser(
					"kody" + i,
					"day" + i,
					"password" + i,
					"daykm" + i + "@gmail.com"));
		}
		return users;
	}
}
