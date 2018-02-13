package com.wishshelf.category;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;



@SpringBootApplication
@ComponentScan("com.wishshelf.*")
public class WishCategorieService {

	public static void main(String[] args) {
		System.out.println("Test logging");
		SpringApplication.run(WishCategorieService.class, args);

	}
	
	@Bean
	public LocaleResolver localResolver(){
		SessionLocaleResolver localResolver = new SessionLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
	}
	
	@Bean
	@Primary
	public MessageSource resolveResourceBundle(){
		ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
		bundle.setBasename("message");
		return bundle;
	}
	
}
