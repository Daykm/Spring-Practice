package com.daykm;

import com.daykm.webconfig.DispatcherConfig;
import com.daykm.webconfig.RootConfig;
import com.daykm.webconfig.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .profiles("dev")
                .parent(RootConfig.class)
                .child(WebConfig.class)
                .run();

    }


}
