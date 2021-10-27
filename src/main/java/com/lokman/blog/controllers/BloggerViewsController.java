package com.lokman.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lokman.blog.models.Blogger;

@Controller
public class BloggerViewsController {

	@GetMapping(value = "/signup-blogger")
	public String getBloggerRegistrationPage(Model model) {
		model.addAttribute("blogger", new Blogger());
		return "blogger_registration_page";
	}

	@GetMapping(value = "/login-blogger")
	public String getBloggerLoginPage(Model model) {
		model.addAttribute("blogger", new Blogger());
		return "blogger_login_page";
	}

}
