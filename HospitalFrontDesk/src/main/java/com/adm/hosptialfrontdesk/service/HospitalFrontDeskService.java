package com.adm.hosptialfrontdesk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adm.hosptialfrontdesk.pojo.Appointment;
import com.adm.hosptialfrontdesk.pojo.HospitalDetails;
import com.adm.hosptialfrontdesk.pojo.Specialist;

@Service
public class HospitalFrontDeskService {
	
	//================= Specialist details =========================

	public static List<Specialist> specialistDetails() {
		
		List<Specialist> doctorsAndDetails = new ArrayList<>();
		
		doctorsAndDetails.add(new Specialist("sandhya", "Dentist", "Monday,Wednesday", "5 to 6", "Y", "946"));
		doctorsAndDetails.add(new Specialist("saranya", "Dentist", "Monday,Thursday", "6 to 8", "N", "946"));
		doctorsAndDetails.add(new Specialist("Edward", "Dentist", "Monday", "5 to 8", "Y", "970"));
		
		doctorsAndDetails.add(new Specialist("shiva", "Cardiologist", "Monday,Tuesday", "10 to 12", "Y", "956"));
		doctorsAndDetails.add(new Specialist("harshini", "Cardiologist", "Monday,Friday", "11 to 12", "Y", "956"));
		doctorsAndDetails.add(new Specialist("dhanush", "Dentist", "Tuesday,Wednesday", "2 to 4", "N", "970"));
		doctorsAndDetails.add(new Specialist("arul", "Cardiologist", "Thursday,Friday", "1 to 4", "Y", "956"));
		
		return doctorsAndDetails;
	
	}
	
	
	
	// ================= Hospital details =========================

		public static List<HospitalDetails> hospitalDetails() {
			
			List<HospitalDetails> hospitalDetails = new ArrayList<>();
			
			hospitalDetails.add(new HospitalDetails("946", 8));
			hospitalDetails.add(new HospitalDetails("956", 12));
			hospitalDetails.add(new HospitalDetails("970", 5));
			
			return hospitalDetails;
		
		}

	
		
	//==================== Static Data Variables ====================================
	
	public final static List<Specialist> specialistDetails = specialistDetails();

	public final static List<HospitalDetails> hospitalDetails = hospitalDetails();


	
	//================== specialist details by hospitalId SpecialistType =============

	public List<Specialist> getSpecialistDetails(String hospitalId, String type) {
		List<Specialist> specialistlist = new ArrayList<>();
		for (Specialist specialist : specialistDetails) {
			if (specialist.getHospitalId().equalsIgnoreCase(hospitalId)
					&& specialist.getType().equalsIgnoreCase(type)) {
				specialistlist.add(specialist);
			}
		}
		return specialistlist;
	}
	
	
	//===================== AvailableBeds ===========================================
	
	public int getAvailableBeds(String hospitalId) {
		int hospitalDetail = 0;
		for (HospitalDetails hospital : hospitalDetails) {
			if (hospital.getHospitalId().equalsIgnoreCase(hospitalId)) {
				hospitalDetail = hospital.getAvailableBeds();
			}
		}
		return hospitalDetail;
	}
	

	//=================== Specialist Appointment ===================================
	
	public Appointment specialistAppointment(String hospitalId, 
											 String doctorName, 
											 String patientName,
											 String appointmentDay) {
		Appointment appointmentDetails = null;
		for (Specialist doctorsDetails : specialistDetails) {
			if (doctorsDetails.getHospitalId().equalsIgnoreCase(hospitalId)
					&& doctorsDetails.getName().equalsIgnoreCase(doctorName)) {
				appointmentDetails = new Appointment(doctorsDetails.getName(), patientName,
						doctorsDetails.getAppointmentDay(), doctorsDetails.getAppointmentTime());
			}
		}
		return appointmentDetails;
	}

	
	//================= check specialist already available or not specialistName =======
	
	public boolean specialistAvailability(String specialistName) {
		boolean flag = false;
		for (Specialist specialist : specialistDetails) {
			if (specialist.getName().equalsIgnoreCase(specialistName)) {
				flag = true;
			}
		}
		return flag;
	}
	
	
	//================= list of Specialists ===========================
	
	public List<Specialist> listOfSpecialist() {		
		return specialistDetails;
	}
}
