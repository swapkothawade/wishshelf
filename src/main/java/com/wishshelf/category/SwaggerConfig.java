package com.wishshelf.category;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
			
	 public  static final Contact DEFAULT_CONTACT = new Contact("Swapnil", "axadasc", "vsvv");
	  public static final ApiInfo temp = new ApiInfo("API's for Wishcategory", 
			  "Service End point for API's",
			  "1.0", 
			  "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(temp);
				
	}
}
