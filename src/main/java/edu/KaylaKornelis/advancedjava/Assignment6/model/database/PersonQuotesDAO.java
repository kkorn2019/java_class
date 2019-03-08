package edu.KaylaKornelis.advancedjava.Assignment6.model.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Models a table the combines person with the stock quotes they're interested in.
 */
@Entity
@Table(name = "person_quotes", catalog = "stocks")
public class PersonQuotesDAO implements DatabasesAccessObject {
    private int id;
    private PersonDAO person;
    private QuotesDAO quote;

    /**
     * Create a PersonHobby that needs to be initialized
     */
    public PersonQuotesDAO() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStocks instance
     *
     * @param person the person to assign the quote to
     * @param quote  the quote to associate the person with
     */
    public PersonQuotesDAO(PersonDAO person, QuotesDAO quote) {
        setQuote(quote);
        setPerson(person);
    }

    /**
     * Primary Key - Unique ID for a particular row in the person_quotes table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person_hobby table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return get the PersonDAO associated with this hobby
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public PersonDAO getPerson() {
        return person;
    }

    /**
     * Specify the PersonDAO associated with the hobby.
     *
     * @param person a person instance
     */
    public void setPerson(PersonDAO person) {
        this.person = person;
    }

    /**
     *
     * @return get the QuotesDAO associated with this PersonDAO
     */
    @ManyToOne
    @JoinColumn(name = "quote_id", referencedColumnName = "ID", nullable = false)
    public QuotesDAO getQuote() {
        return quote;
    }

    /**
     * Specify the QuotesDAO associated with the PersonDAO.
     *
     * @param quote a person instance
     */
    public void setQuote(QuotesDAO quote) {
        this.quote = quote;
    }

    /**
     * This method compares two objects to ensure they are equal
     */
    @Override
    public boolean equals(Object o) {
        //if the object is equal to itself, return true
        if (this == o) return true;
        
        //check if o is null or is not an instance of this class
        // if so, return false
        if (o == null || getClass() != o.getClass()) return false;
        //cast o to be of type PersonQuotesDAO
        PersonQuotesDAO that = (PersonQuotesDAO) o;

        //compare each attribute and return true or false result
        if (id != that.id) return false;

        return true;
    }

    /**
     * This method constructs and returns a hashcode value for the PersonQuotesDAO object
     * @return a hashcode value for the PersonQuotesDAO object 
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + quote.hashCode();
        return result;
    }

    /**
     * This method overrides the toString method to display the attributes of the
 PersonQuotesDAO object as a String
     * @return String containing attributes of PersonQuotesDAO object
     */
    @Override
    public String toString() {
        return "PersonStocks{" +
                "id=" + id +
                ", person=" + person +
                ", quote=" + quote +
                '}';
    }
}
