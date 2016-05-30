package com.daykm.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.activation.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DBConfig {

	@Bean(destroyMethod = "shutdown")
	@Profile("dev")
	public DataSource devData() {
		return null;
	}

	@Bean
	@Profile("prod")
	public DataSource prodData() {
		return null;
	}
}
