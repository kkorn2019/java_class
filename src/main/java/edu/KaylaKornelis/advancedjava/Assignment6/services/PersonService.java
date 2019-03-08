package edu.KaylaKornelis.advancedjava.Assignment6.services;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.QuotesDAO;
import java.util.List;

/**
 * This API is used to read records in the PersonDAO table of the stocks database.
 */
public interface PersonService {
    
    /**
     * Get a list of all people
     *
     * @return a list of PersonDAO instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<PersonDAO> getPerson() throws PersonServiceException;

    /**
     * Add a new person or update an existing PersonDAO's data
     *
     * @param person a person object to either update or create
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdatePerson(PersonDAO person) throws PersonServiceException;

    /**
     * Get a list of all a person's quotes.
     *
     * @param person the person to get quotes for
     * @return a list of quote instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<QuotesDAO> getQuotes(PersonDAO person) throws PersonServiceException;

    /**
     * Assign a quote to a person.
     *
     * @param quote  The hobby to assign
     * @param person The person to assign the quote too.
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    public void addQuotesToPerson(QuotesDAO quote, PersonDAO person) throws PersonServiceException;

}