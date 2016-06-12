package com.daykm.web;

import com.daykm.data.UserRepository;
import com.daykm.domain.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/testform")
public class MainController {


	private UserRepository repo;

	@Autowired
	public MainController(UserRepository repo) {
		this.repo = repo;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("newUser", new SiteUser());
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(SiteUser user, Model model) {
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		repo.save(user);
		return "home";
	}

	@RequestMapping("/list")
	public String listUsers(Model model) {
		model.addAttribute("list", repo.list());
		return "userList";
	}

	@RequestMapping(value = "/")
	public String number(@RequestParam long num, Model model) {
		model.addAttribute("number", num);
		return "home";
	}
}
