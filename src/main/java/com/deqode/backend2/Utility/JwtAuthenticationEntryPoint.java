//package com.deqode.backend2.Utility;
//
//import java.io.IOException;
//import java.io.Serializable;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable{
//
//	private static final long serialVersionUID = 1L;
//	
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//	}
//}
