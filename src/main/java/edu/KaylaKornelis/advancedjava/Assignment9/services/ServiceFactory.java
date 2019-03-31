package edu.KaylaKornelis.advancedjava.Assignment9.services;

/**
 * A factory that returns a Services.
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
    public static StockService getStockService() {
        return new DatabaseStockService();
    }

    /**
     *
     * @return get a <CODE>UserService</CODE> instance
     */
    public static  UserService getUserService() {
        return new DatabaseUserService();
    }
    
    /**
     *
     * @return get a <CODE>RestfulStockService</CODE> instance
     */
    public static RestfulStockService getRestfulStockService() {
        return new RestfulStockService();
    }
}
