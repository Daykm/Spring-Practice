package com.daykm.config;


import com.daykm.data.UserRepository;
import com.daykm.domain.SiteUser;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


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
	@Autowired
	public LocalSessionFactoryBean sessionFactory(
			DataSource dataSource, Properties prop) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.daykm.domain");
		sessionFactory.setHibernateProperties(prop);
		return sessionFactory;
	}
	
	@Bean
	@Profile("dev")
	public Properties hibernatePropertiesDev() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager manager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
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
