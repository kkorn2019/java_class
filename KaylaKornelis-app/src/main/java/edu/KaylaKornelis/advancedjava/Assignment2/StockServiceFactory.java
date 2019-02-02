
package edu.KaylaKornelis.advancedjava.Assignment2;

/**
 *
 * @author Kornelis
 */
public class StockServiceFactory {
    
    public StockService getStockService(StockService stockServiceType){
        if (stockServiceType == null){
            return null;
        } else {
            return new BasicStockService();
        }
        
    }
}
