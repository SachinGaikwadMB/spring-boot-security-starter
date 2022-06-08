package org.mindbowser.demo.security.business.service;

import java.util.ArrayList;
import java.util.Optional;
import org.mindbowser.demo.security.persistance.entity.User;
import org.mindbowser.demo.security.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Optional<User> userOptional = userRepository.findByEmail(email);		
		 
		if(!userOptional.isPresent()) 
			throw new UsernameNotFoundException("User not found ");
		
		return new org.springframework.security.core.userdetails.User(
				userOptional.get().getEmail(), userOptional.get().getPassword(), new ArrayList<>());
	}

}
