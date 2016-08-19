package com.vasylenkoMO.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by vastl271nko on 19.08.16.
 */
@Configuration
@ComponentScan(basePackages = "com.vasylenkoMO.spring")
public class AppConfig {

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("pinguinnn007@gmail.com");
        mailSender.setPassword("*********");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport  .protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }
}
