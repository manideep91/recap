package com.mmdworks.recap.config;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;



@Configuration
@PropertySources({ @PropertySource("classpath:mail.properties") })
public class MailConfig {

private static final Logger logger = LoggerFactory.getLogger(MailConfig.class);
	
    @Value("${mail.username}")
    private String MAIL_USERNAME;
    @Value("${mail.password}")
    private String MAIL_PASSWORD;
    @Resource(name = "mailProperties")
    private Properties mailProperties;
    
    @Bean(name="mailProperties")
    public PropertiesFactoryBean mapper() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("mail.properties"));
        return bean;
    }
    
    @Bean
    public JavaMailSenderImpl javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            mailProperties.put("mail.smtp.socketFactory", sf);
        } catch (GeneralSecurityException ex) {
           logger.error("Email configuration exception " ,ex);
        }
        javaMailSender.setJavaMailProperties(mailProperties);
        javaMailSender.setUsername(MAIL_USERNAME);
        javaMailSender.setPassword(MAIL_PASSWORD);
        return javaMailSender;
    }
}
