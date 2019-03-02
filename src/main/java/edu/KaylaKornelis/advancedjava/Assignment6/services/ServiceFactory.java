package edu.KaylaKornelis.advancedjava.Assignment6.services;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockServiceInstance() {
        return new DatabaseStockService();
    }
    
    /**
     *
     * @return get a <CODE>PersonService</CODE> instance
     */
    public static PersonService getPersonServiceInstance() {
        return new DatabasePersonService();
    }
}
