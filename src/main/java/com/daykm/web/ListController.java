package com.daykm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/nier")
@Controller
public class ListController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "nier/index";
	}
}
