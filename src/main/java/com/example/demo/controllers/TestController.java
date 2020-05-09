package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.TestServices;

@RestController
public class TestController {
	
	@Autowired
	TestServices testServices;

	@GetMapping(value="/test")
	public String test() {
		return testServices.test();
	}
}
