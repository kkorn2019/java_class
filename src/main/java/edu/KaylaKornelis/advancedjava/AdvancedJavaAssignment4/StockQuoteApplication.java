package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4;

import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4.model.Interval;
import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4.model.StockQuote;
import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4.service.StockService;
import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4.service.StockServiceFactory;
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
    public static void main(String args[]){
        String stockSymbol = "APPL";
        String fromDate = "1/1/2014";
        String untilDate = "1/2/2014";
        Interval interval = Interval.WEEKLY;

            /**
         * Call the createBasicStock method to obtain the current price for a single StockQuote instance.
         */
        System.out.println(createBasicStock(stockSymbol));

        /**
         * Call the createListOfStockQuotes method to obtain a List of StockQuote instances. 
         */
        System.out.println(createListOfStockQuotes(stockSymbol, fromDate, untilDate));
        
        /**
         * Call the createListOfStockQuotesWithInterval method to obtain a List of StockQuote instances. 
         */
        System.out.println(createListOfStockQuotesWithInterval(stockSymbol, fromDate, untilDate, interval));
        
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
         * Create a new instance of StockService by calling the 
         * getStockService method in the StockServiceFactory
         */
        StockService stockService = StockServiceFactory.getStockService();
 
        /**
         * Create a new StockQuote instance and call the getQuote method 
         * from the StockService to obtain current price for the given
         * symbol
         */
        StockQuote stockQuote = stockService.getQuote(symbol);
        
        System.out.println(stockQuote.getDateRecorded());
        return stockQuote;
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
         * Call convertStringToDate to get dates from strings passed in
         */
        Calendar fromDate = convertStringToDate(from);
 
        Calendar untilDate = convertStringToDate(until);
          
        /**
         * Create a new instance of StockService by calling the 
         * getStockService method in the StockServiceFactory
         */
        StockService stockService = StockServiceFactory.getStockService();
           
        /**
        * Create a new List<StockQuote> and call the getQuote method from 
        * BasicStockService to return the list of StockQuote instances.
        * @param symbol the stock symbol to search for
        * @param from the date of the first stock quote
        * @param until the date of the last stock quote
        * @return a list of StockQuote instances
        * One for each day in the range specified
        */
        List<StockQuote> listStockQuotes = stockService.getQuote(symbol, fromDate, untilDate);
        
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
         * Call convertStringToDate to get dates from strings passed in
         */
        Calendar fromDate = convertStringToDate(from);
 
        Calendar untilDate = convertStringToDate(until);
               
        /**
         * Create a new instance of StockService by calling the 
         * getStockService method in the StockServiceFactory
         */
        StockService stockService = StockServiceFactory.getStockService();
            
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
        List<StockQuote> listStockQuotes = stockService.getQuote(symbol, fromDate, untilDate, interval);
            
        System.out.println(listStockQuotes.get(0).getDateRecorded());
        return listStockQuotes;    
    }
    
    public static Calendar convertStringToDate(String dateEntered){
        /**
         * Create a new instance of SimpleDateFormat that will be used to 
         * parse the string arguments to obtain desired start and end dates
         */
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("MM/dd/YYYY");
        Calendar convertedDate = Calendar.getInstance();
            
        /**
         * try/catch block to catch and handle ParseException in case an 
         * invalid date is entered
         */
        try{
            convertedDate.setTime(simpleDateFormatter.parse(dateEntered));
        }catch(ParseException e){
            System.out.println("Unable to retrieve stock quote(s) with provided dates. \n"
                    + "Please try again with required format: \"01/01/2011\"");
            System.exit(1);
        }
        return convertedDate;
    }
        
}
    