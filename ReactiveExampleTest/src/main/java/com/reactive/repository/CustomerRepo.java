package com.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reactive.model.Customer;

public interface CustomerRepo  extends ReactiveCrudRepository<Customer, Integer>{

}
