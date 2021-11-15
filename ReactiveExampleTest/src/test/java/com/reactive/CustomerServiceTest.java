package com.reactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactive.model.Customer;
import com.reactive.repository.CustomerRepo;
import com.reactive.repository.LeadRepo;
import com.reactive.service.CustomerService;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class CustomerServiceTest {

	
	@Mock
	private CustomerRepo customerRepo;
    @Mock
    private LeadRepo leadRepo;
	@InjectMocks
	private CustomerService customerService;
	
	private Customer customer;
	@BeforeEach
	public void setup()
	{
	customer=new Customer();
	customer.setFirstName("Ankit");
	customer.setLastName("Goswami");
   customer.setEmail("ankit@gmail.com");
	}
	@Test
	public void SaveCustomer()
	{
	when(customerRepo.save(customer)).thenReturn(Mono.just(customer));
	when(leadRepo.UpdateByEmail(customer.getEmail())).thenReturn(Mono.just(1));
	
    Mono<?> mono = customerService.add(customer);
	     StepVerifier.create(mono).assertNext(s->{
	    	assertEquals("Ankit",customer.getFirstName()); 
	     });
	}
}
