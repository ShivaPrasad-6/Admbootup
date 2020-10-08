package com.adm.hosptialfrontdesk.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adm.hosptialfrontdesk.pojo.ExceptionResonse;
import com.adm.hosptialfrontdesk.pojo.InvalidHospitalNameException;

import static com.adm.hosptialfrontdesk.restClient.SpecialistConstants.INVALID_HOSPITAL_NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BusinessExceptionHandler extends ResponseEntityExceptionHandler {

	
	
	//============= HospitalNameException =================
	
	public final ResponseEntity<ExceptionResonse> buildResponseEntityForInvalidHospitalNameException(
			InvalidHospitalNameException hospitalNameException) {

		ExceptionResonse exceptionResponse = new ExceptionResonse(hospitalNameException.getMessage(),
				INVALID_HOSPITAL_NAME);
		return new ResponseEntity<ExceptionResonse>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);

	}
	
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handle(Exception exception, 
	                HttpServletRequest request, HttpServletResponse response) {
	        if (exception instanceof NullPointerException) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	
}
