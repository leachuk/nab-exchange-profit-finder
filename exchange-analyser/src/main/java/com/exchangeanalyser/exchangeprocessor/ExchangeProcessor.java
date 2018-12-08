package com.exchangeanalyser.exchangeprocessor;

import com.exchangeanalyser.exchangemodel.ExchangeEntryItem;

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
	
	public void doProcessData() {
		this.processedData = data.sorted(Comparator.comparing(ExchangeEntryItem::getDatetime)).collect(Collectors.toList());
	}
	
	public Double getMaxProfit(String currency) {
		
		Double[] dataStore = toStream(processedData)
												 .filter(e -> e.getCurrency().equals(currency))
												 .sorted(Comparator.comparing(ExchangeEntryItem::getDatetime))
												 .map(x -> new Double(x.getPrice()))
												 .toArray(Double[]::new);
		
		return getMaxDifference(dataStore);
	}
	
	private Double getMaxDifference(Double[] prices) {
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
	
	private static <T> Stream<T> toStream (List<T> list) {
		return list.stream();
	}
}
	
