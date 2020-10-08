package com.adm.hosptialfrontdesk.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Appointment {

	private String specialistName;
	private String patientName;
	private String availableDay;
	private String availableTime;

}
