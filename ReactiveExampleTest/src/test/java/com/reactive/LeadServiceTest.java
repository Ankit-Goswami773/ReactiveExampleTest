package com.reactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.model.Lead;
import com.reactive.repository.LeadRepo;
import com.reactive.service.LeadService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
@SpringBootTest
public class LeadServiceTest {

	@Mock
	private LeadRepo leadRepo;
	
	@InjectMocks
	private LeadService leadService;
	
	Lead l;
	@BeforeEach
	public void setUP()
	{		
	l=new Lead();
l.setFirstName("Ankit");
l.setLastName("Goswami");
l.setEmail("ankit@gmail.com");
l.setStatus("pending");	
	}
     @Test	
	public void add()
	{
	when(leadRepo.save(l)).thenReturn(Mono.just(l));
	Mono<Lead> mono = leadService.add(l);
     StepVerifier.create(mono).assertNext(s->{
    	 
    	assertEquals("Ankit",s.getFirstName());
    	assertEquals("Goswami",s.getLastName());
    	assertEquals("ankit@gmail.com",s.getEmail());
    	assertEquals("pending",s.getStatus());
     })	;	
	}
	
	
}
