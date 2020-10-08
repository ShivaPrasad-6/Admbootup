package com.adm.hosptialfrontdesk.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.adm.hosptialfrontdesk")
@PropertySource("classpath:application.properties")
public class SpecialistProperties {

	@Value("${hfd.environment:http://localhost:8080}")
	private String environment;

	@Value("${hfd.baseurl:/hospitalfrontdesk}")
	private String baseUrl;
	
	@Value("${hfd.specialistdetails:/specialistdetails/{hospitalId}/{specialistType}}")
	private String specialistdetailsUrl;
	
	@Autowired
	Environment environment2;

	

	public String generateUrl() {
		
		System.out.println("Property " + environment2.getProperty("hfd.environment"));
		return environment + baseUrl + specialistdetailsUrl;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyScan() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
