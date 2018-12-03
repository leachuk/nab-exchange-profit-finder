package com.exchangeanalyser.exchangemodel;

import java.time.LocalDateTime;

public class ExchangeEntryItem {
	String currency;
	LocalDateTime datetime;
	Float price;
	
	
	public ExchangeEntryItem(String currency, LocalDateTime datetime, Float price) {
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
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
}
