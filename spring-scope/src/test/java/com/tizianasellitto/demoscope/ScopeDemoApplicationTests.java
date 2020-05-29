package com.tizianasellitto.demoscope;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ScopeDemoApplicationTests {
	private static final String CITY = "San Francisco";

	@Autowired
	private ApplicationContext context;

	@Test
	public void aComponent() {
		Assert.assertTrue(context.getBean(Address.class) != null);
	}

	@Test
	public void givenSingletonScope_whenSetName_thenEqualNames() {

		Address personSingletonA = (Address) context.getBean("personSingleton");
		Address personSingletonB = (Address) context.getBean("personSingleton");

		Customer customer = (Customer) context.getBean("customer");
		Employee employee = (Employee) context.getBean("employee");

		personSingletonA.setCity(CITY);
		Assert.assertEquals(CITY, personSingletonB.getCity());
		Assert.assertEquals(personSingletonA.hashCode(), personSingletonB.hashCode());
		Assert.assertEquals(customer.getAddress().hashCode(), employee.getAddress().hashCode());
	}
}
