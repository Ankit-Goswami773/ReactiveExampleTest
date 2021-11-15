package com.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.model.Lead;
import com.reactive.service.LeadService;

import reactor.core.publisher.Mono;

@RestController
public class LeadController {

	@Autowired
	private LeadService service;
	@PostMapping("/add")
	public Mono<Lead> addCustomer(@RequestBody Lead lead)
	{
		
		return service.add(lead);
	}
	
	
}
