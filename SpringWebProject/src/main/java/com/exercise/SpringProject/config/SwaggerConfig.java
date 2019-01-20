package com.exercise.SpringProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration 					//Configuration
@EnableSwagger2					//Enable Swagger
public class SwaggerConfig {
	
	//Bean - Docket
	
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Hitesh", "", "hiteshupreti51@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", 
			  "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}

}
