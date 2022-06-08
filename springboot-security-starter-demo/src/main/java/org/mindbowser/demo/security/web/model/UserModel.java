package org.mindbowser.demo.security.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.mindbowser.demo.security.custom.validation.ValidEmail;
import org.mindbowser.demo.security.custom.validation.ValidPassword;

public class UserModel {

	@NotEmpty
	@Size(min = 2, max = 20, message = "Minimum size should be 2  & Maximum should be 20 character")
	private String name;
	
	
	@NotEmpty
	@ValidEmail
	@Size(max = 50)
	private String email;
	
	@NotEmpty
	@ValidPassword
	private String password;
	
	public UserModel() {}

	public UserModel(String name,String email, String password)
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

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setPassword(String password)
	{
		this.password = password;
	} 
	
	
	
	
}
