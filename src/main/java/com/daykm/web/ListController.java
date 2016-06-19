package com.daykm.web;

import com.daykm.data.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/nier")
@Controller
public class ListController {

    @Autowired
    WeaponRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "nier/index";
	}

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("weapons", repo.getWeapons());
        return "nier/list";
    }
}
