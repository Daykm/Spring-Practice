package com.daykm.beans;


import org.springframework.stereotype.Component;

@Component
public class NeedyBean {

	private HeyItBean bean;

	public NeedyBean(HeyItBean bean) {
		this.bean = bean;
	}
}
