package com.mmdworks.recap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer  {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(RecapApplication.class);
	}
}
