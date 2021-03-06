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
public class PersonQuotes implements DatabasesAccessObject {
    private int id;
    private Person person;
    private Quotes quote;

    /**
     * Create a PersonHobby that needs to be initialized
     */
    public PersonQuotes() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStocks instance
     *
     * @param person the person to assign the quote to
     * @param quote  the quote to associate the person with
     */
    public PersonQuotes(Person person, Quotes quote) {
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
     * @return get the Person associated with this hobby
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person associated with the hobby.
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     *
     * @return get the Quotes associated with this Person
     */
    @ManyToOne
    @JoinColumn(name = "quote_id", referencedColumnName = "ID", nullable = false)
    public Quotes getQuote() {
        return quote;
    }

    /**
     * Specify the Quotes associated with the Person.
     *
     * @param quote a person instance
     */
    public void setQuote(Quotes quote) {
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
        //cast o to be of type PersonQuotes
        PersonQuotes that = (PersonQuotes) o;

        //compare each attribute and return true or false result
        if (id != that.id) return false;

        return true;
    }

    /**
     * This method constructs and returns a hashcode value for the PersonQuotes object
     * @return a hashcode value for the PersonQuotes object 
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
 PersonQuotes object as a String
     * @return String containing attributes of PersonQuotes object
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
