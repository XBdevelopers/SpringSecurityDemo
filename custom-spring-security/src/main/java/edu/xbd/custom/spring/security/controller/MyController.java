package edu.xbd.custom.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xbd.custom.spring.security.util.Constants;

@RestController
public class MyController {

	@GetMapping(value = Constants.REST_ENDPOINT_ROOT)
	public String getUserMessage() {
		return "<h1 style=\"padding-top:150px; text-align:center; vertical-align:middle;\">"
				+ "Hello! Welcome to the demo...</h1>";
	}
	
	@GetMapping(value = Constants.REST_ENDPOINT_ADMIN)
	public String getAdminMessage() {
		return "<h1 style=\"padding-top:150px; color:red; text-align:center; vertical-align:middle\">"
				+ "Hey Admin! Welcome to the demo...</h1>"
				+ "<br /> <p style=\"color:red; text-align:center\">Let's do something amazing :)</p>";
	}
	
	@GetMapping(value = Constants.REST_ENDPOINT_USER)
	public String getAuthenticatedUserMessage() {
		return "<h1 style=\"padding-top:150px; color:green; text-align:center; vertical-align:middle\">"
				+ "Yo You are authorized! Welcome to the demo...</h1>";
	}
}
