package com.mmdworks.recap.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.mmdworks.recap")
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppConfiguration {
	

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
