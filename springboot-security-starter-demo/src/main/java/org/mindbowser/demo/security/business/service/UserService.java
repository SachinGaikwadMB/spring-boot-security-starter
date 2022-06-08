package org.mindbowser.demo.security.business.service;

import org.mindbowser.demo.security.web.model.LoginModel;
import org.mindbowser.demo.security.web.model.SignupModel;

public interface UserService {
	
	String register(SignupModel signupModel);
	
	String login(LoginModel loginModel);

}
