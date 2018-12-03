package com.exchangeanalyser;

import com.exchangeanalyser.exchangemodel.ExchangeEntryItem;
import com.exchangeanalyser.exchangeprocessor.ExchangeProcessor;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class ExchangeAnalyser {
    private static final int SEQUENTIAL_PAGE_COUNT = 3;
    private static final int LIST_LIMIT = 10;
    
    public static void main(String[] args) {
        System.out.println("================== Welcome to the Exchange Analyser ==================");
    
        ExchangeProcessor exchangeProcessor = new ExchangeProcessor(getSampleData());
    
        Object processExchangeData = exchangeProcessor.doProcessExchangeData();
        
//        for (Map.Entry<String,List<ExchangeEntryItem> > item : processExchangeData.entrySet()) {
//            System.out.println(item.getValue().get(0).getPrice());
//        }
        

        System.out.println("================== Completed Exchange Analyser ==================");
    }

    private static Stream<ExchangeEntryItem> getSampleData(){
        LocalDateTime first = LocalDateTime.parse("2018-07-05T09:15:00");
        
        Stream<ExchangeEntryItem> logItemList = Stream.of(
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T09:15:00"), new Float("34.98f")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T11:58:00"), new Float("14.30f")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T15:02:00"), new Float("38.58f")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T09:19:00"), new Float("24.03f"))
        );

        return logItemList;
    }
}
