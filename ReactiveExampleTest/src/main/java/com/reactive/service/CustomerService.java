package com.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.model.Customer;
import com.reactive.model.Lead;
import com.reactive.repository.CustomerRepo;
import com.reactive.repository.LeadRepo;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private LeadRepo leadRepo;

	public Mono<?> add(Customer customer) {
		
	return	customerRepo.save(customer).flatMap(s -> {
			if (s.getEmail() != null) {
				return leadRepo.UpdateByEmail(s.getEmail()).flatMap(c -> { return Mono.just(s);});

			} else {
				return leadRepo.UpdateByPhone(s.getPhoneNumber()).flatMap(c -> Mono.just(s));
			}

		});

	}

}
