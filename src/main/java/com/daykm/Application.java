package com.daykm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.daykm.config")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		configureBuilder(new SpringApplicationBuilder()).run();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return configureBuilder(builder);
	}

	private static SpringApplicationBuilder configureBuilder(SpringApplicationBuilder builder) {
		return builder
				.profiles("dev")
				.web(true)
				.sources(Application.class);
	}
}