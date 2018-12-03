package com.exchangeanalyser.exchangeprocessor;

import com.exchangeanalyser.exchangemodel.ExchangeEntryItem;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
		
		
		Object dataStore = data.sorted(Comparator.comparing(ExchangeEntryItem::getDatetime)).collect(toList());
		
//		doProcessLogData().entrySet()
//		.stream()
//		.sorted(comparingByValue((o1, o2) -> this.isDescOrder ? o2.getOccurrences().compareTo(o1.getOccurrences())
//																				 : o1.getOccurrences().compareTo(o2.getOccurrences())))
//		.limit(this.limit)
//		.collect(toList());
		
		return dataStore;
	}
	
}
	
