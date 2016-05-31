package com.daykm.webconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherConfig {

    @Bean
	@Autowired
    public ServletRegistrationBean dispatcherServlet(WebApplicationContext context) {
        ServletRegistrationBean bean = new ServletRegistrationBean(new DispatcherServlet(context), "/");
        bean.setAsyncSupported(true);
        return bean;
    }

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory fcty = new TomcatEmbeddedServletContainerFactory();
		return fcty;
	}
}
