package com.exchangeanalyser.exchangemodel;

import java.time.LocalDateTime;

public class ExchangeEntryItem {
	String currency;
	LocalDateTime datetime;
	Double price;
	
	
	public ExchangeEntryItem(String currency, LocalDateTime datetime, Double price) {
		this.currency = currency;
		this.datetime = datetime;
		this.price = price;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public LocalDateTime getDatetime() {
		return datetime;
	}
	
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}
