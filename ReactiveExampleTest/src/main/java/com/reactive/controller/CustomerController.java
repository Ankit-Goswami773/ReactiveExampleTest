package com.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.model.Customer;
import com.reactive.model.Lead;
import com.reactive.service.CustomerService;
import com.reactive.service.LeadService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {


@Autowired
private CustomerService customerService;



@PostMapping("/add")
public Mono<?> add(@RequestBody Customer customer)
{
	return customerService.add(customer);
}



}

