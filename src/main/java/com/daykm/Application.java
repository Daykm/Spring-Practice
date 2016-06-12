package com.daykm;

import com.daykm.webconfig.WebConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

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
                .web(true)
                .sources(WebConfig.class);

    }
}