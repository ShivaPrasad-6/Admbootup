package com.adm.hosptialfrontdesk.controller;

import static com.adm.hosptialfrontdesk.restClient.SpecialistConstants.INVALID_HOSPITAL_NAME;
import static com.adm.hosptialfrontdesk.restClient.SpecialistConstants.NO_SPECIALIST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.hosptialfrontdesk.pojo.Appointment;
import com.adm.hosptialfrontdesk.pojo.InvalidHospitalNameException;
import com.adm.hosptialfrontdesk.pojo.NoSpecialistFoundException;
import com.adm.hosptialfrontdesk.pojo.Specialist;
import com.adm.hosptialfrontdesk.service.HospitalFrontDeskService;;

@RestController
@RequestMapping(value = { "${hfd.baseurl}" })
public class HospitalFrontDeskController {

	@Autowired
	HospitalFrontDeskService hospitalService;
	
	//============== Specialist Details -- Requirement 1==================================

	@GetMapping(value = "${hfd.specialistdetails}",
				produces = { MediaType.APPLICATION_JSON_VALUE,
							 MediaType.APPLICATION_XML_VALUE }, 
				consumes = MediaType.ALL_VALUE)
	public List<Specialist> specialistList(@PathVariable("hospitalId") String hospitalId,
										   @PathVariable("specialistType") String specialistType) 
												   throws InvalidHospitalNameException {
		if (hospitalId != null && specialistType != null) {
			return hospitalService.getSpecialistDetails(hospitalId, specialistType);
		}
		else {
			System.out.println("Hospital name and specialist name should not be empty !!!");
			throw new InvalidHospitalNameException(INVALID_HOSPITAL_NAME);
		}
	}
	
	
	//============== Specialist Details using Response Entity -- Requirement 4 ==================================

	@GetMapping(value = "${hfd.respecialistdetails}",
				produces = { MediaType.APPLICATION_JSON_VALUE,
							 MediaType.APPLICATION_XML_VALUE }, 
				consumes = MediaType.ALL_VALUE)
	public ResponseEntity<Object> respecialistList(@PathVariable("id") String id,
												   @PathVariable("type") String type) 
														   throws InvalidHospitalNameException {
		if (id != null && type != null) {
			return new ResponseEntity<Object>(hospitalService.getSpecialistDetails(id, type), HttpStatus.OK);
		}
		else {
			System.out.println("Hospital name and specialist name should not be empty !!!");
			throw new InvalidHospitalNameException(INVALID_HOSPITAL_NAME);
		}
	}


	//============== Specialist Appointment -- Requirement 2 ==================================
	
	@GetMapping(value = "${hfd.specialistappointment}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Appointment specialistAppointment(@PathVariable("hospitalId") String hospitalId,
											 @PathVariable("specialistName") String specialistName, 
											 @PathVariable("patientName") String patientName,
											 @PathVariable("appointmentDay") String appointmentDay)
													 throws InvalidHospitalNameException, NoSpecialistFoundException {
		Appointment appointmentDetails;
		if (hospitalId != null) {
			boolean isSpecialistAvailable = hospitalService.specialistAvailability(specialistName);
			if (isSpecialistAvailable) {
				appointmentDetails = hospitalService.specialistAppointment(hospitalId, specialistName, patientName,
						appointmentDay);
			} 
			else {
				throw new NoSpecialistFoundException(NO_SPECIALIST);
			}
		} 
		else {
			throw new InvalidHospitalNameException(INVALID_HOSPITAL_NAME);
		}
		return appointmentDetails;
	}
	
	
	//============== Available Beds -- Requirement 3 ==================================

	@GetMapping(value = "${hfd.availablebeds}")
	public String availableBeds(@PathVariable("hospitalId") String hospitalId) throws InvalidHospitalNameException {
		int beds = 0;
		if (hospitalId != null) {
			beds = hospitalService.getAvailableBeds(hospitalId);
		} 
		else {
			throw new InvalidHospitalNameException(INVALID_HOSPITAL_NAME);
		}
		return "Number of Beds Available is = " + beds;
	}
	
	
	//============== List Of Hospitals -- Requirement 5 ==================================
	
	@GetMapping(value = "${hfd.listOfSpecialists}",
				produces = { MediaType.APPLICATION_JSON_VALUE,
							 MediaType.APPLICATION_XML_VALUE }, 
				consumes = MediaType.ALL_VALUE)
	public List<Specialist> retrieveSpecialistDetails() {		
		return hospitalService.listOfSpecialist();
		
	}
}