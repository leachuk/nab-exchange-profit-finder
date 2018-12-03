package com.exchangeanalyser.exchangeprocessor;

import com.exchangeanalyser.exchangemodel.ExchangeEntryItem;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Stream;

public class ExchangeProcessor {
	private Stream<ExchangeEntryItem> data;
	
	public ExchangeProcessor(Stream<ExchangeEntryItem> data) {
		this.data = data;
	}
	
	public ExchangeProcessor(Stream<ExchangeEntryItem> data, int limit, int pageCount, boolean isDescOrder) {
		this.data = data;
	}
	
	public Object doProcessExchangeData() {
		//Map<String, List<ExchangeEntryItem>> dataStore = data.collect(groupingBy(ExchangeEntryItem::getCurrency));
		LocalDateTime ldt = LocalDateTime.now();
		
		
		Double[] dataStore = data.sorted(Comparator.comparing(ExchangeEntryItem::getDatetime)).map(x -> new Double(x.getPrice())).toArray(Double[]::new);
		
//		doProcessLogData().entrySet()
//		.stream()
//		.sorted(comparingByValue((o1, o2) -> this.isDescOrder ? o2.getOccurrences().compareTo(o1.getOccurrences())
//																				 : o1.getOccurrences().compareTo(o2.getOccurrences())))
//		.limit(this.limit)
//		.collect(toList());
		Double maxProfit = maxProfit(dataStore);
		
		return maxProfit;
	}
	
	public Double maxProfit(Double[] prices) {
		if (prices.length < 1) {
			return 0.0;
		}
		
		Double maxDiff = 0.0;
		Double localMin = prices[0];
		Double localMax = localMin;
		
		for (Double price : prices) {
			if (price > localMax) {
				localMax = price;
				Double localDiff = localMax - localMin;
				if (localDiff > maxDiff) {
					maxDiff = localDiff;
				}
			} else if (price < localMin) {
				localMin = localMax = price;
			}
		}
		
		return maxDiff;
	}
	
}
	
