package com.daykm;

import com.daykm.beans.HeyGetThing;
import com.daykm.beans.HeyItBean;
import com.daykm.beansoutofscope.HeyGetMe;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		context.getBean(HeyItBean.class).doThing();

		context.getBean(HeyGetThing.class).thing.doThing();

		context.getBean(HeyGetMe.class).doThing();
	}
}
