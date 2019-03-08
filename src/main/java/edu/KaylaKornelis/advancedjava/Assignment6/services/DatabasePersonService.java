package edu.KaylaKornelis.advancedjava.Assignment6.services;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonQuotesDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.QuotesDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class DatabasePersonService implements PersonService {
    
    /**
     * Get a list of all people
     *
     * @return a list of PersonDAO instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<PersonDAO> getPerson() throws PersonServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<PersonDAO> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonDAO.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }

    /**
     * Add a new person or update an existing PersonDAO's data
     *
     * @param person a person object to either update or create
     */
    @Override
    public void addOrUpdatePerson(PersonDAO person) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }

    /**
     * Get a list of all a person's quotes.
     *
     * @param person the person
     * @return a list of quote instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<QuotesDAO> getQuotes(PersonDAO person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<QuotesDAO> quotes = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonQuotesDAO.class);
            criteria.add(Restrictions.eq("person", person));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            List<PersonQuotesDAO> list = criteria.list();
            for (PersonQuotesDAO personQuotes : list) {
                quotes.add(personQuotes.getQuote());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return quotes;

    }

    /**
     * Assign a quote to a person.
     *
     * @param quote  The quote to assign
     * @param person The person to assign the quote too.
     */
    @Override
    public void addQuotesToPerson(QuotesDAO quote, PersonDAO person) throws PersonServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersonQuotesDAO personQuote = new PersonQuotesDAO();
            personQuote.setQuote(quote);
            personQuote.setPerson(person);
            session.saveOrUpdate(personQuote);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
}
