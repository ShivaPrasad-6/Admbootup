package com.adm.hosptialfrontdesk.pojo;

public class NoSpecialistFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSpecialistFoundException(String message) {
		super(message);
	}
}
