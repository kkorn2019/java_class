package edu.KaylaKornelis.advancedjava.Assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * This class is used to retrieve stock quotes
 */
public class StockQuoteApplication {
    
    /**
     * This main method is the entrance to the application.
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args){
        
        /**
         * Call the createListOfStockQuotes method to obtain a List of StockQuote instances. 
         */
        System.out.println(createListOfStockquotes("APPL", "1/1/2014", "2/1/2014"));
        
        /**
         * Call the createBasicStock method to obtain the current price for a single StockQuote instance.
         */
        System.out.println(createBasicStock("APPL"));
  
    }
    
    /**
     * Get a historical list of stock quotes for the provided symbol.
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances
     * One for each day in the range specified
     */
        public static List<StockQuote> createListOfStockquotes(String symbol, String from, String until){
            /**
             * Create a new instance of SimpleDateFormat that will be used to 
             * parse the string arguments to obtain desired start and end dates
             */
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
            Calendar fromDate = Calendar.getInstance();
            
            /**
             * try/catch block to catch and handle ParseException in case an 
             * invalid date is entered
             */
            try{
                fromDate.setTime(sdf.parse(from));
            }catch(ParseException e){
                System.out.println("Unable to parse the date: " + from);
            }
            
    
            Calendar untilDate = Calendar.getInstance();
            
            /**
             * try/catch block to catch and handle ParseException in case an 
             * invalid date is entered
             */
            try{
                untilDate.setTime(sdf.parse(until));
            }catch(ParseException e){
                System.out.println("Unable to parse the date: " + until);
            }
            
            /**
             * Create a new instance of StockServiceFactory
             */
            StockServiceFactory stockServiceFactory = new StockServiceFactory();
            
            /**
             * Create a new instance of BasicStockService by calling the 
             * getStockService method in the StockServiceFactory
             */
            BasicStockService basicStockService = stockServiceFactory.getStockService();
            
            /**
            * Create a new List<StockQuote> and call the getQuote method from 
            * BasicStockService to return the list of StockQuote instances.
            * @param symbol the stock symbol to search for
            * @param from the date of the first stock quote
            * @param until the date of the last stock quote
            * @return a list of StockQuote instances
            * One for each day in the range specified
            */
            List<StockQuote> listStockQuotes = basicStockService.getQuote(symbol, fromDate, untilDate);
            
            return listStockQuotes;    
        }
        
        /**
        * This method is used to obtain the current price for a share of stock
        * for the given symbol
        *
        * @param symbol the stock symbol of the company you want a quote for.
        *      e.g. APPL for APPLE
        *
        * @return a  <CODE>StockQuote</CODE> instance
        */
        public static StockQuote createBasicStock(String symbol){
            
            /**
             * Create a new instance of StockServiceFactory
             */
            StockServiceFactory stockServiceFactory = new StockServiceFactory();
        
            /**
             * Create a new instance of BasicStockService by calling the 
             * getStockService method in the StockServiceFactory
             */
            BasicStockService basicStockService = stockServiceFactory.getStockService();

            /**
             * Create a new StockQuote instance and call the getQuote method 
             * from the BasicStockService to obtain current price for the given
             * symbol
             */
            StockQuote stockQuote = basicStockService.getQuote(symbol);
        
            return stockQuote;
        }
        
    }
    
