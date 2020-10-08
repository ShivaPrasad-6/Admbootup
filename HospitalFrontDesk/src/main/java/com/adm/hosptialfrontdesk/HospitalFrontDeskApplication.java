package com.adm.hosptialfrontdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adm.hosptialfrontdesk.restClient.SpecialistProperties;

/*@SpringBootApplication(scanBasePackages = { "com.rdp.hosptialfrontdesk.controller",
		"com.rdp.hosptialfrontdesk.exception", "com.rdp.hosptialfrontdesk.constants", "com.rdp.hosptialfrontdesk.model",
		"com.rdp.hosptialfrontdesk.service" })*/
@SpringBootApplication
public class HospitalFrontDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalFrontDeskApplication.class, args);
	}

	@Bean
	public SpecialistProperties properties() {
		return new SpecialistProperties();
	}

}
