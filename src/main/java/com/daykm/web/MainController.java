package com.daykm.web;

import com.daykm.domain.NewUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/")
public class MainController {
	@RequestMapping(method= RequestMethod.GET)
	public String home(Model model) {
        model.addAttribute("newUser", new NewUser());
		return "home";
	}

    @RequestMapping(method=RequestMethod.POST)
    public String submit(NewUser user, Model model) {
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        return "home";
    }

    @RequestMapping(value="/")
    public String number(@RequestParam long num, Model model) {
        model.addAttribute("number", num);
        return "home";
    }
}
