package com.exchangeanalyser.exchangeprocessor;

import com.exchangeanalyser.bestprofitmodel.BestProfit;
import com.exchangeanalyser.exchangemodel.ExchangeEntryItem;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExchangeProcessor {
	private Stream<ExchangeEntryItem> data;
	private List<ExchangeEntryItem> processedData;
	
	public ExchangeProcessor(Stream<ExchangeEntryItem> data) {
		this.data = data;
		this.doProcessData();
	}
	
	public BestProfit getMaxProfit(String currency, LocalDate date) {
		List<ExchangeEntryItem> filteredDataList = getFilteredExchangeData(currency, date);

		return getBestProfitFromList(filteredDataList);
	}
	
	public String toJson() {
		Gson gson = new Gson();
		
		return gson.toJson(processedData);
	}
	
	public List<ExchangeEntryItem> getFilteredExchangeData(String currency, LocalDate date) {
		List<ExchangeEntryItem> dataList = toStream(processedData)
																			 .filter(e -> e.getCurrency().equals(currency) & e.getDatetime().toLocalDate().equals(date))
																			 .sorted(Comparator.comparing(ExchangeEntryItem::getDatetime))
																			 .collect(Collectors.toList());
		
		return dataList;
	}
	
	private void doProcessData() {
		this.processedData = data.sorted(Comparator.comparing(ExchangeEntryItem::getDatetime)).collect(Collectors.toList());
	}
	
	private BestProfit getBestProfitFromList(List<ExchangeEntryItem> prices) {
		BestProfit bestProfit = new BestProfit();
		
		if (prices.isEmpty()) {
			return bestProfit;
		}
		
		Double maxDiff = 0.0;
		Double localMin = prices.get(0).getPrice();
		LocalDateTime buyDateTime = prices.get(0).getDatetime();
		Double localMax = localMin;
		
		for (ExchangeEntryItem item : prices) {
			Double price = item.getPrice();
			if (price > localMax) {
				localMax = price;
				Double localDiff = localMax - localMin;
				if (localDiff > maxDiff) {
					maxDiff = localDiff;
					bestProfit.setProfit(maxDiff);
					bestProfit.setSellPrice(localMax);
					bestProfit.setSellDatetime(item.getDatetime());
					bestProfit.setBuyPrice(localMin);
					bestProfit.setBuyDatetime(buyDateTime);
				}
			} else if (price < localMin) {
				localMin = localMax = price;
				buyDateTime = item.getDatetime();
			}
		}
		
		bestProfit.setCurrency(prices.get(0).getCurrency());
		
		
		return bestProfit;
	}
	
	private static <T> Stream<T> toStream (List<T> list) {
		return list.stream();
	}
}
	
