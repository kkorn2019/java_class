/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.KaylaKornelis.advancedjava.Assignment2;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Kornelis
 */
public class BasicStockService implements StockService {
    
    private String stockSymbol;
    private BigDecimal stockPrice;
    private Date dateRecorded;
    
    @Override
    public StockQuote getQuote(String symbol, Date date){
         StockQuote stockQuote = new StockQuote(dateRecorded, stockPrice, stockSymbol);
         
         return stockQuote;
    }
      
}
