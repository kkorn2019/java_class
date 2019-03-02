package edu.KaylaKornelis.advancedjava.Assignment6.model;

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
public class PersonQuotes {
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
     * Create a valid PersonQuotes
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonQuotes that = (PersonQuotes) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + quote.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonQuote{" +
                "id=" + id +
                ", person=" + person +
                ", quote=" + quote +
                '}';
    }
}
