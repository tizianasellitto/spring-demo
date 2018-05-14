package com.tizianasellitto.currencyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tizianasellitto.currencyservice.dao.ExchangeValueRepository;
import com.tizianasellitto.currencyservice.model.ExchangeValue;

@RestController
public class CurrencyController {

	@Autowired
	private ExchangeValueRepository repository;

	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	private ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		return exchangeValue;
	}
}
