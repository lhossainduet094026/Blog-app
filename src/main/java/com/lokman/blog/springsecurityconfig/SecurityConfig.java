package com.lokman.blog.springsecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lokman.blog.Security.JwtAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}

	// configure() method is used to set up existing filters.
	@Override
	public void configure(HttpSecurity httpsecurity) throws Exception {
		httpsecurity.csrf().disable().authorizeRequests()
				.antMatchers("/api/auth/**", "/*", "/h2-console/**", "/api/posts/**").permitAll().anyRequest()
				.authenticated();
		httpsecurity.headers().frameOptions().sameOrigin();

		httpsecurity.addFilterBefore(JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public JwtAuthenticationFilter JwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder autheticationManagerBuilder) throws Exception {
		autheticationManagerBuilder.userDetailsService(userDetailService);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
