package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignments;

import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignments.Interval;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.validation.constraints.NotNull;

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
        System.out.println(createListOfStockQuotes("APPL", "1/1/2014", "2/1/2014"));
        
        /**
         * Call the createListOfStockQuotesWithInterval method to obtain a List of StockQuote instances. 
         */
        System.out.println(createListOfStockQuotesWithInterval("APPL", "1/1/2014", "2/1/2014", Interval.WEEKLY));
        
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
    @NotNull
    public static List<StockQuote> createListOfStockQuotes(String symbol, String from, String until){
        /**
         * Create a new instance of SimpleDateFormat that will be used to 
         * parse the string arguments to obtain desired start and end dates
         */
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/dd/YYYY");
        Calendar fromDate = Calendar.getInstance();
            
        /**
         * try/catch block to catch and handle ParseException in case an 
         * invalid date is entered
         */
        try{
            fromDate.setTime(simpleDateFormatter.parse(from));
        }catch(ParseException e){
            System.out.println("Unable to parse the date: " + from);
        }
            
        Calendar untilDate = Calendar.getInstance();
           
        /**
         * try/catch block to catch and handle ParseException in case an 
         * invalid date is entered
         */
        try{
            untilDate.setTime(simpleDateFormatter.parse(until));
        }catch(ParseException e){
            System.out.println("Unable to parse the date: " + until);
        }
 
        /**
         * Create a new instance of BasicStockService by calling the 
         * getStockService method in the StockServiceFactory
         */
        StockService basicStockService = StockServiceFactory.getStockService();
           
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
        
        System.out.println(listStockQuotes.get(0).getDateRecorded());
        return listStockQuotes;    
    }
        
    /**
    * Get a historical list of stock quotes for the provided symbol
    * This method will return one StockQuote per interval specified
    * @param symbol the stock symbol to search for
    * @param from the date of the first stock quote
    * @param until the date of the last stock quote
    * @param interval the number of StockQuotes to get 
    *  Eg. daily = one StockQuote per day will be returned
    * @return a list of StockQuote instances
    */
    @NotNull
    public static List<StockQuote> createListOfStockQuotesWithInterval(String symbol, String from, String until, Interval interval){
        /**
         * Create a new instance of SimpleDateFormat that will be used to 
         * parse the string arguments to obtain desired start and end dates
         */
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/dd/YYYY");
        Calendar fromDate = Calendar.getInstance();
       
        /**
         * try/catch block to catch and handle ParseException in case an 
         * invalid date is entered
         */
        try{
           fromDate.setTime(simpleDateFormatter.parse(from));
        }catch(ParseException e){
            System.out.println("Unable to parse the date: " + from);
        }
            
    
        Calendar untilDate = Calendar.getInstance();
           
        /**
         * try/catch block to catch and handle ParseException in case an 
         * invalid date is entered
         */
        try{
            untilDate.setTime(simpleDateFormatter.parse(until));
        }catch(ParseException e){
            System.out.println("Unable to parse the date: " + until);
        }
               
        /**
         * Create a new instance of BasicStockService by calling the 
         * getStockService method in the StockServiceFactory
         */
        StockService basicStockService = StockServiceFactory.getStockService();
            
        /**
        * Get a historical list of stock quotes for the provided symbol
        * This method will return one StockQuote per interval specified
        * @param symbol the stock symbol to search for
        * @param from the date of the first stock quote
        * @param until the date of the last stock quote
        * @param interval the number of StockQuotes to get 
        *  Eg. daily = one StockQuote per day will be returned
        * @return a list of StockQuote instances
        */
        List<StockQuote> listStockQuotes = basicStockService.getQuote(symbol, fromDate, untilDate, interval);
            
        System.out.println(listStockQuotes.get(0).getDateRecorded());
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
    @NotNull
    public static StockQuote createBasicStock(String symbol){
        
        /**
         * Create a new instance of BasicStockService by calling the 
         * getStockService method in the StockServiceFactory
         */
        StockService basicStockService = StockServiceFactory.getStockService();
 
        /**
         * Create a new StockQuote instance and call the getQuote method 
         * from the BasicStockService to obtain current price for the given
         * symbol
         */
        StockQuote stockQuote = basicStockService.getQuote(symbol);
        
        System.out.println(stockQuote.getDateRecorded());
        return stockQuote;
    }
        
}
    