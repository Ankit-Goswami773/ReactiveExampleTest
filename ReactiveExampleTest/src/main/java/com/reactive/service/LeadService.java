package com.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.model.Lead;
import com.reactive.repository.LeadRepo;

import reactor.core.publisher.Mono;

@Service
public class LeadService {

	

	@Autowired
	private LeadRepo repo;
	
	public Mono<Lead> add(Lead lead)
	{
		return repo.save(lead);
	}
	
	
	
}
