package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration  //설정하는 값. 이 안에 bean을 설정. xml에서 만들던 방식이 아닌 어노테이션을 활용해서 java코드로 만듦.
public class FileConfig { 	//이 설정이 되어야지 파일업로드 가능 
	@Bean //메소드 실행 후 return 값을 bean으로 만들어줌.
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxUploadSize(52428800); //50MB
		mr.setDefaultEncoding("utf-8");
		return mr;
	}
}
