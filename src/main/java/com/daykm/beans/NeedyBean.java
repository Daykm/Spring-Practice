package com.daykm.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeedyBean {

	private HeyItBean bean;


    @Autowired
	public NeedyBean(HeyItBean bean) {
		this.bean = bean;
	}
}
