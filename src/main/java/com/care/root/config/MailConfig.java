package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	@Bean
	public static JavaMailSender mailSender() {	//메일 보낼 때 사용하는 계정 셋팅.
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com"); //google smtp mail 서버 설정
		jms.setPort(587);				//google smtp 메일 포트
		jms.setUsername("eunoia8059@gmail.com");
		jms.setPassword("tjgml0805*");

		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");	//프로토콜: smtp
		prop.setProperty("mail.smtp.auth", "true"); 
		prop.setProperty("mail.smtp.starttls.enable", "true"); 	//보안처리
		prop.setProperty("mail.debug", "true");
		jms.setJavaMailProperties(prop);

		return jms;
	}

}
