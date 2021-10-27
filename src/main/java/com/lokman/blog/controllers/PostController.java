package com.lokman.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lokman.blog.models.Post;
import com.lokman.blog.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	// creating own blog post
	@PostMapping("/addPost")
	public ModelAndView createPost(@ModelAttribute("post") Post post) {
		System.out.println(post);
		postService.createPost(post);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("post-success");
		return modelAndView;

	}

	// get all the post
	@GetMapping("/all")
	public ResponseEntity<List<Post>> showallPosts() {
		return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
	}

	// delete own post
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deletePost(@PathVariable Long id) {
		postService.deletePost(id);
		return new ResponseEntity(HttpStatus.OK);

	}
}
