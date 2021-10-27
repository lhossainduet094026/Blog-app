package com.lokman.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lokman.blog.Security.JwtProvider;
import com.lokman.blog.models.Blogger;
import com.lokman.blog.repositories.BloggerRepository;

@Service
public class BloggerService {

	@Autowired
	private BloggerRepository bloggerRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void saveBlogger(Blogger blogger) {
		blogger.setPassword(encodePassword(blogger.getPassword()));

		bloggerRepository.save(blogger);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public String login(Blogger blogger) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(blogger.getFirstName(), blogger.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		// after successful authenticate we need to generate jwt token
		return jwtProvider.generateToken(authenticate);

	}

	// this will return user what we have stored in securityContext
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return principal;
	}
}
