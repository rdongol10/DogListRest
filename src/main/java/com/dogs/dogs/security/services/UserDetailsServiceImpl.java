package com.dogs.dogs.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dogs.dogs.model.User;
import com.dogs.dogs.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findUserByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return new UserDetailsImpl(user);
	}

}
