package com.deqode.backend2.Dto;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final String jwttoken;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}
}
