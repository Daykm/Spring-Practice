package com.daykm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home() {
		// view name to be resolved
		return "home";
	}

}
