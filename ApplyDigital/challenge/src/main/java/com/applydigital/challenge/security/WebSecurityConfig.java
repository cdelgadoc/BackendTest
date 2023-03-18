package com.applydigital.challenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.applydigital.challenge.utils.ChallengeServiceConfiguration;

@Configuration
public class WebSecurityConfig {

	@Autowired
	private ChallengeServiceConfiguration configuration;
	
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;
	
	public WebSecurityConfig(UserDetailsService userDetailsService, 
			JWTAuthorizationFilter jwtAuthorizationFilter) {
		this.userDetailsService = userDetailsService;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl(configuration.getLogin());
		
		return http
				.csrf().disable()
				.authorizeHttpRequests()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();				
	}
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
