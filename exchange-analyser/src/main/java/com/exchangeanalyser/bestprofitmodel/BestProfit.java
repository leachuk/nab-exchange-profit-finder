package com.exchangeanalyser.bestprofitmodel;

import java.time.LocalDateTime;

public class BestProfit {
	String currency;
	LocalDateTime buyDatetime;
	Double buyPrice;
	LocalDateTime sellDatetime;
	Double sellPrice;
	Double profit;
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public LocalDateTime getBuyDatetime() {
		return buyDatetime;
	}
	
	public void setBuyDatetime(LocalDateTime buyDatetime) {
		this.buyDatetime = buyDatetime;
	}
	
	public Double getBuyPrice() {
		return buyPrice;
	}
	
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public LocalDateTime getSellDatetime() {
		return sellDatetime;
	}
	
	public void setSellDatetime(LocalDateTime sellDatetime) {
		this.sellDatetime = sellDatetime;
	}
	
	public Double getSellPrice() {
		return sellPrice;
	}
	
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public Double getProfit() {
		return profit;
	}
	
	public void setProfit(Double profit) {
		this.profit = profit;
	}
}
