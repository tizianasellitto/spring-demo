package com.tizianasellitto.conversionservice.controller;

import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ConversionController {

	@Autowired
	private EurekaClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/conversion-exchange/{amount}/from/{from}/to/{to}")
	public String getCurrencyExchangeUrl(@PathVariable BigDecimal amount, @PathVariable String from,
			@PathVariable String to) throws JSONException {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("currency-service", false);
		String value = restTemplate
				.getForObject(instance.getHomePageUrl() + "currency-exchange/from/" + from + "/to/" + to, String.class);
		JSONObject jsonObj = new JSONObject(value);
		String exchangeRate = jsonObj.get("exchangeRate").toString();

		return "The conversion from " + from +" to " + to + " is : " + amount.multiply(new BigDecimal(exchangeRate)) ;

		// final InstanceInfo instance = discoveryClient.getNextServerFromEureka("",
		// false);
	}
	// @RequestMapping("/currency-exchange/from/{from}/to/{to}")
	// private ExchangeValue retrieveExchangeValue(@PathVariable String from,
	// @PathVariable String to) {
	// ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
	// return exchangeValue;
	// }
}
