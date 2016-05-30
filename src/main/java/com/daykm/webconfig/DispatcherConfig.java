package com.daykm.webconfig;


import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherConfig {

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new DispatcherServlet(), "/");
        bean.setAsyncSupported(true);
        return bean;
    }
}
