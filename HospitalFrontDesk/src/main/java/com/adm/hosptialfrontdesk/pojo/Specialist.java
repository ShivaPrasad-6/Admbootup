package com.adm.hosptialfrontdesk.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Specialist {
	private String name;
	private String type;
	private String appointmentDay;
	private String appointmentTime;
	private String isAvailable;
	private String hospitalId;

}
