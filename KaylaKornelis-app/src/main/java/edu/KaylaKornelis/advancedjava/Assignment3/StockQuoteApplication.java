package edu.KaylaKornelis.advancedjava.Assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This class is used to retrieve stock quotes
 */
public class StockQuoteApplication {
    
    public static void main(String[] args){
        
        System.out.println(createListOfStockquotes("APPL", "1/1/2014", "2/1/2014"));
        
        System.out.println(createBasicStock("APPL"));
  
    }
    
        public static List<StockQuote> createListOfStockquotes(String symbol, String from, String until){
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
            Calendar fromDate = Calendar.getInstance();
            
            try{
                fromDate.setTime(sdf.parse(from));
            }catch(ParseException e){
                e.printStackTrace();
            }
                
            Calendar untilDate = Calendar.getInstance();
            
            try{
                untilDate.setTime(sdf.parse(until));
            }catch(ParseException e){
                e.printStackTrace();
            }  
        
            StockServiceFactory stockServiceFactory = new StockServiceFactory();
        
            BasicStockService basicStockService = stockServiceFactory.getStockService();
            
            List<StockQuote> listStockQuotes = basicStockService.getQuote(symbol, fromDate, untilDate);
            
            return listStockQuotes;
        }
        
        public static StockQuote createBasicStock(String symbol){
            StockServiceFactory stockServiceFactory = new StockServiceFactory();
        
            BasicStockService basicStockService = stockServiceFactory.getStockService();

            StockQuote stockQuote = basicStockService.getQuote(symbol);
        
            return stockQuote;
        }
        
    }
    
