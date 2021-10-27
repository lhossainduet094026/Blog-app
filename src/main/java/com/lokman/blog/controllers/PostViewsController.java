package com.lokman.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lokman.blog.models.Post;

@Controller
public class PostViewsController {

	@GetMapping("/createPost")
	public String getPostCreationPage(Model model) {
		model.addAttribute("post", new Post());
		return "post-creation-page";
	}
}
