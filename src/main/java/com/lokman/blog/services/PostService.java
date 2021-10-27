package com.lokman.blog.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.lokman.blog.models.Post;
import com.lokman.blog.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private BloggerService bloggerService;

	@Autowired
	private PostRepository postRepository;

	public void createPost(Post post) {
		User blogger = bloggerService.getCurrentUser();
		post.setUsername(blogger.getUsername());
		post.setCreatedOn(Instant.now());
		System.out.println(post);
		postRepository.save(post);

	}

	public List<Post> showAllPosts() {
		return postRepository.findAll();
	}

	public void deletePost(Long id) {
		postRepository.deleteById(id);

	}
}
