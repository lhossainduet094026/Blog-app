package com.lokman.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.lokman.blog.models.Blogger;
import com.lokman.blog.models.Post;
import com.lokman.blog.services.BloggerService;

@RestController
@RequestMapping("/api/auth")
public class BloggerController {

	@Autowired
	BloggerService bloggerService;

	@PostMapping("/addBlogger")
	public ModelAndView saveBloggerInfo(@ModelAttribute("blogger") Blogger blogger) {
		System.out.println(blogger);
		bloggerService.saveBlogger(blogger);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("blogger-registration-success");
		return modelAndView;
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("blogger") Blogger blogger) {
		bloggerService.login(blogger);
		ModelAndView modelAndView = new ModelAndView();
		final String allPostUri = "http://localhost:8080//api/posts/all";
		// rest template to call rest end point using http request
		RestTemplate template = new RestTemplate();
		Post[] allPosts = template.getForObject(allPostUri, Post[].class);
		modelAndView.addObject("allPosts", allPosts);
		modelAndView.setViewName("blogger-profile-page");
		return modelAndView;

	}

}
