package com.exchangeanalyser.exchangemodel;

import java.util.List;
import java.util.stream.Collectors;

public class ExchangeEntryList {
	List<String> logEntryList;
	
	public ExchangeEntryList(List logEntryList) {
		this.logEntryList = logEntryList;
	}
	
	public List getExchangeEntryList() {
		return logEntryList;
	}
	
	public String printList() {
		String result = this.getExchangeEntryList().stream()
						.map(o -> String.valueOf(o))
						.collect(Collectors.joining(" -> ", "(", ")")).toString();

		return result;
	}

}
