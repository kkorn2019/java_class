package edu.KaylaKornelis.advancedjava.Assignment3;

/**
 *  This class serves as a Factory for the StockService interface and classes that implement the StockService interface for getting stock data.
 * Allows creation of new objects without exposing the creation logic to the client.
 */

public class StockServiceFactory {
    
    public BasicStockService getStockService(){
        /**
         * Create and return a new instance of BasicStockService.
         */
        return new BasicStockService();   
    }
}