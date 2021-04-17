package edu.xbd.springsecurityldapdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public String getIndex() {
		return "Home Page1";
	}
}
