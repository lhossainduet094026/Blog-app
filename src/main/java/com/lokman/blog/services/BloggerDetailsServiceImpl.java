package com.lokman.blog.services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lokman.blog.models.Blogger;
import com.lokman.blog.repositories.BloggerRepository;

@Service
public class BloggerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BloggerRepository bloggerRepository;

	@Override
	public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
		Blogger blogger = bloggerRepository.findByfirstName(firstName)
				.orElseThrow(() -> new UsernameNotFoundException("No user found" + firstName));
		System.out.println(blogger);
		return new org.springframework.security.core.userdetails.User(blogger.getFirstName(), blogger.getPassword(),
				getAuthorities("ROLE_USER"));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
		return Collections.singletonList(new SimpleGrantedAuthority(role_user));
	}

}
