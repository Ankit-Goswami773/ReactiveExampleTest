package com.reactive.repository;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.model.Lead;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface LeadRepo extends ReactiveCrudRepository<Lead, Long> {
	
	@Modifying
	@Query("update lead_table as l set l.status ='Onboard' where  l.email = :email")
   Mono<Integer> UpdateByEmail(String email);
	
	@Modifying
	@Query("update lead_table as a set a.status ='Onboard' where  a.phone_number = :phoneNumber")
	   Mono<Integer> UpdateByPhone(String phoneNumber);

}
