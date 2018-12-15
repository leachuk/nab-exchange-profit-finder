package com.exchangeanalyser;

import com.exchangeanalyser.exchangemodel.ExchangeEntryItem;
import com.exchangeanalyser.exchangeprocessor.ExchangeProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class ExchangeAnalyser {
    
    public static void main(String[] args) {
        System.out.println("================== Welcome to the Exchange Analyser ==================");
    
        LocalDate getDate = LocalDate.parse("2018-07-05");
        
        ExchangeProcessor exchangeProcessor = new ExchangeProcessor(getSampleData());
    
        Double maxBTCProfit = exchangeProcessor.getMaxProfit("BTC", getDate);
        System.out.println(String.format("BTC profit[%1$,.2f]", maxBTCProfit));
    
        Double maxETCProfit = exchangeProcessor.getMaxProfit("ETC", getDate);
        System.out.println(String.format("ETC profit[%1$,.2f]", maxETCProfit));
    
        Double maxLTCProfit = exchangeProcessor.getMaxProfit("LTC", getDate);
        System.out.println(String.format("LTC profit[%1$,.2f]", maxLTCProfit));
        
        System.out.println(String.format("JSON output: %s", exchangeProcessor.toJson()));
        
        System.out.println("================== Completed Exchange Analyser ==================");
    }

    private static Stream<ExchangeEntryItem> getSampleData(){
        Stream<ExchangeEntryItem> logItemList = Stream.of(
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T09:15:00"), new Double("34.98")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T10:45:00"), new Double("36.13")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T12:30:00"), new Double("37.01")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T14:00:00"), new Double("35.98")),
            new ExchangeEntryItem("BTC", LocalDateTime.parse("2018-07-05T15:30:00"), new Double("33.56")),
            new ExchangeEntryItem("ETC", LocalDateTime.parse("2018-07-05T09:00:00"), new Double("1.45")),
            new ExchangeEntryItem("ETC", LocalDateTime.parse("2018-07-05T10:30:00"), new Double("1.87")),
            new ExchangeEntryItem("ETC", LocalDateTime.parse("2018-07-05T12:45:00"), new Double("1.55")),
            new ExchangeEntryItem("ETC", LocalDateTime.parse("2018-07-05T15:15:00"), new Double("2.01")),
            new ExchangeEntryItem("ETC", LocalDateTime.parse("2018-07-05T17:00:00"), new Double("2.15")),
            new ExchangeEntryItem("LTC", LocalDateTime.parse("2018-07-05T09:30:00"), new Double("14.32")),
            new ExchangeEntryItem("LTC", LocalDateTime.parse("2018-07-05T11:15:00"), new Double("14.87")),
            new ExchangeEntryItem("LTC", LocalDateTime.parse("2018-07-05T12:45:00"), new Double("15.03")),
            new ExchangeEntryItem("LTC", LocalDateTime.parse("2018-07-05T14:00:00"), new Double("14.76")),
            new ExchangeEntryItem("LTC", LocalDateTime.parse("2018-07-05T17:00:00"), new Double("14.15"))
        );

        return logItemList;
    }
}
