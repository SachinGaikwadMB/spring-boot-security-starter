package org.mindbowser.demo.security.business.service;

import org.mindbowser.demo.security.business.exception.InvalidCredentialsException;
import org.mindbowser.demo.security.business.exception.ResourceAlreadyExistException;
import org.mindbowser.demo.security.persistance.entity.User;
import org.mindbowser.demo.security.persistance.repository.UserRepository;
import org.mindbowser.demo.security.web.model.LoginModel;
import org.mindbowser.demo.security.web.model.SignupModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	void registerUserMethod(SignupModel signupModel)
	{

		User user = new User();
		user.setEmail(signupModel.getEmail());
		user.setName(signupModel.getName());
		user.setPassword(encoder.encode(signupModel.getPassword()));
		

		userRepository.save(user);
	}
	
	@Override
	public String register(SignupModel signupModel)
	{
		
		if (Boolean.TRUE.equals(userRepository.existsByEmail(signupModel.getEmail())))
			throw new ResourceAlreadyExistException("User already exist with email :: " + signupModel.getEmail());

		 registerUserMethod(signupModel);

		return "User registered successfully!";
	}

	@Override
	public String login(LoginModel loginModel) throws InvalidCredentialsException
	{
		
		Authentication authObject = null;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authObject);
		} catch (BadCredentialsException e) {
			throw new InvalidCredentialsException("Invalid credentials");
		}
		
		return "Login Successful !";
	}
	
	
	
	
		

}
