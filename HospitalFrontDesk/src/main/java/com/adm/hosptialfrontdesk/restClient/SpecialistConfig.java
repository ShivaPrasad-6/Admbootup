package com.adm.hosptialfrontdesk.restClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import lombok.Getter;

@Configuration
@PropertySource("classpath:specialist.properties")
@Getter
public class SpecialistConfig {

	@Value("#{'${specialist.name}'.split(',')}")
	private List<String> specialistName;

	@Value("#{'${specialist.appointmentDay}'.split(',')}")
	private List<String> specialistAvailableDay;

	@Value("#{'${specialist.appointmentTime}'.split(',')}")
	private List<String> specialistAvailableTime;

	public static PropertySourcesPlaceholderConfigurer propertyScan() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
