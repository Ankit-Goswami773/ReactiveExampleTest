package com.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	private Long id;
	@Column("firstName")
	private String firstName;
	@Column("lastName")
	private String lastName;
	@Column("phoneNumber")
	private String phoneNumber;
	@Column("email")
	private String email;
}
