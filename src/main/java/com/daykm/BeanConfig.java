package com.daykm;

import com.daykm.beans.HeyItBean;
import com.daykm.beansoutofscope.HeyGetMe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HeyItBean.class)
public class BeanConfig {

	@Bean
	public HeyGetMe getBean() {
		return new HeyGetMe();
	}
}
