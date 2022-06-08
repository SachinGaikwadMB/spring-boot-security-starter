package org.mindbowser.demo.security.web.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.mindbowser.demo.security.custom.validation.ValidEmail;
import org.mindbowser.demo.security.custom.validation.ValidPassword;

public class SignupModel {

	@NotBlank
	private String name;
	
	


	@NotBlank
	@Size(max = 50)
	@ValidEmail
	private String email;

	@NotBlank
	@ValidPassword
	private String password;
	
	public SignupModel() {}
	
	public SignupModel(@NotBlank String name, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 40) String password)
	{
		super();
		this.name = name;
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
	

	public String getName()
	{
		return name;
	}

	
}
