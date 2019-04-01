package edu.KaylaKornelis.advancedjava.Assignment4.service;

import org.apache.http.annotation.Immutable;

/**
 *  This class serves as a Factory for the StockService interface and classes that implement the StockService interface for getting stock data.
 * Allows creation of new objects without exposing the creation logic to the client.
 */
@Immutable
public class StockServiceFactory {
    
    public static StockService getStockService(){
        /**
         * Create and return a new instance of BasicStockService.
         */
        return new BasicStockService();   
    }
}