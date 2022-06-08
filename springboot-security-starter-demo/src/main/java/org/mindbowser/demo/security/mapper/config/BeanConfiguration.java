package org.mindbowser.demo.security.mapper.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public ModelMapper modelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}
}
