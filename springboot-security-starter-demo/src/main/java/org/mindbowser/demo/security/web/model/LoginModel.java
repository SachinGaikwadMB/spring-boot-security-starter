package org.mindbowser.demo.security.web.model;

import javax.validation.constraints.NotBlank;

public class LoginModel
{
	@NotBlank
	private String email;

	@NotBlank
	private String password;

	public LoginModel() {}
	
	
	
	
	
	public LoginModel(@NotBlank String email, @NotBlank String password)
	{
		super();
		this.email = email;
		this.password = password;
	}



	public String getEmail()
	{
		return email;
	}

	public String getPassword()
	{
		return password;
	}

	
	
}
