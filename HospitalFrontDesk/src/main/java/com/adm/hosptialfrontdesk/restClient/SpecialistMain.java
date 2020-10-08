package com.adm.hosptialfrontdesk.restClient;

import static com.adm.hosptialfrontdesk.restClient.SpecialistConstants.GET_SPECIALIST_BY_TYPE;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adm.hosptialfrontdesk.pojo.Specialist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SpecialistMain {

	private static MediaType MEDIATYPE_JSON = MediaType.APPLICATION_JSON;
	private static MediaType MEDIATYPE_XML = MediaType.APPLICATION_XML;
	private static String APPLICATION_PORT = "8080";
	private static String APPLICATION_ENVIRONMENT = "http://localhost";

	public static void main(String[] args) {

		getSpecialistByType_JSON(APPLICATION_PORT, APPLICATION_ENVIRONMENT, MEDIATYPE_JSON, GET_SPECIALIST_BY_TYPE);

		System.out.println("============================================");

		getSpecialistByType_XML(APPLICATION_PORT, APPLICATION_ENVIRONMENT, MEDIATYPE_XML, GET_SPECIALIST_BY_TYPE);

	}

	private static void getSpecialistByType_JSON(String applicationPort, String applicationType, MediaType mediaType,
			String url) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(new MediaType[] { mediaType }));
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Specialist> entity = new HttpEntity<>(httpHeaders);

		ResponseEntity<List<Specialist>> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Specialist>>() {
				});

		HttpStatus status = response.getStatusCode();

		if (status == HttpStatus.OK) {
			ObjectMapper mapper = new ObjectMapper();
			List<Specialist> result = response.getBody();
			System.out.println("==================================== \n" 
								+ "========= " + mediaType + " ========= \n"
								+ "====================================");
			try {

				System.out.println(mapper.writeValueAsString(result));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}

	private static void getSpecialistByType_XML(String applicationPort, String applicationType, MediaType mediaType,
			String url) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(new MediaType[] { mediaType }));
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Specialist> entity = new HttpEntity<>(httpHeaders);

		ResponseEntity<List<Specialist>> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Specialist>>() {
				});

		HttpStatus status = response.getStatusCode();

		if (status == HttpStatus.OK) {
			ObjectMapper mapper = new ObjectMapper();
			List<Specialist> result = response.getBody();
			System.out.println("==================================== \n" 
							 + "========= " + mediaType + " ========== \n"
							 + "====================================");
			try {

				System.out.println(mapper.writeValueAsString(result));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}

}
