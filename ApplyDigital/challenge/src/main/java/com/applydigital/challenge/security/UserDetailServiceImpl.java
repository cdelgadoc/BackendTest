package com.applydigital.challenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.applydigital.challenge.dao.UserRepository;
import com.applydigital.challenge.model.User;
import com.applydigital.challenge.utils.ChallengeServiceConfiguration;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ChallengeServiceConfiguration configuration;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository
			.findOneByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException(configuration.getUserNotExistError()));
		
		return new UserDetailsImpl(user);
	}

}
