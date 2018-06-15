package com.mmdworks.recap.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Component
@PropertySources({ @PropertySource(value = "classpath:mail.properties") })
public class RecapMailService {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Autowired
	FreeMarkerConfigurer fmConfig;
}
