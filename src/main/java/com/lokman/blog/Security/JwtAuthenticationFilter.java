package com.lokman.blog.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	UserDetailsService userDetailsService;

	// will be called when user access any endpoint
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// first reading authorization header
		String jwt = getJwtFromRequest(request);

		// then validate jwt
		if (StringUtils.hasText(jwt) && jwtProvider.validateJwtToken(jwt)) {
			String userName = jwtProvider.getUserNameFromToken(jwt);

			// loading user details by username from token
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName,
					userDetails);
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);

		}
		// next filter call if exist
		filterChain.doFilter(request, response);

	}

	private String getJwtFromRequest(HttpServletRequest request) {

		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);// first 7 value for "Bearer ".so we need rest of the string

		}
		return bearerToken;
	}

}
