package com.tizianasellitto.demoscope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
	@Bean
	@Scope("singleton")
	public Address personSingleton() {
		return new Address();
	}

	@Bean
	public Customer customer(Address address) {
		Customer customer = new Customer();
		customer.setAddress(address);
		return customer;
	}

	@Bean
	public Employee employee(Address address) {
		Employee employee = new Employee();
		employee.setAddress(address);
		return employee;
	}
}
