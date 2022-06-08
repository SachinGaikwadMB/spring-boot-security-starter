package org.mindbowser.demo.security.web.controller;

import javax.validation.Valid;
import org.mindbowser.demo.security.business.service.UserService;
import org.mindbowser.demo.security.web.model.LoginModel;
import org.mindbowser.demo.security.web.model.ResponseModel;
import org.mindbowser.demo.security.web.model.SignupModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class AuthController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/auth/signup")
	public ResponseEntity<ResponseModel> register(@Valid @RequestBody SignupModel signupModel)
	{
		ResponseModel response = ResponseModel.getInstance();
		response.setData(userService.register(signupModel));
		response.setMessage("User registered successfully");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/auth/signin")
	public ResponseEntity<ResponseModel> login(@Valid @RequestBody LoginModel loginModel)
	{
		ResponseModel response = ResponseModel.getInstance();
		response.setData(userService.login(loginModel));
		response.setMessage("User Login successfully");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
