package com.tizianasellitto.currencyservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	@Id
	private Long id;
	@Column(name = "currency_from")
	private String from;
	@Column(name = "currency_to")
	private String to;
	@Column(name = "exchange_rate")
	private BigDecimal exchangeRate;
	@Column(name = "inverse_exchange_rate")
	private BigDecimal inverse_exchange_rate;

	public ExchangeValue() {
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal exchangeRate, BigDecimal inverse_exchange_rate) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.inverse_exchange_rate = inverse_exchange_rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public BigDecimal getInverse_exchange_rate() {
		return inverse_exchange_rate;
	}

	public void setInverse_exchange_rate(BigDecimal inverse_exchange_rate) {
		this.inverse_exchange_rate = inverse_exchange_rate;
	}

}
