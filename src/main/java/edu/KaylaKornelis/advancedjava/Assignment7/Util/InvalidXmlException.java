package edu.KaylaKornelis.advancedjava.Assignment7.Util;

/**
 *  Used to signal invalid XML or other JAXB related issues.
 */
public class InvalidXmlException extends Exception{

    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     */
    protected InvalidXmlException(String message, Throwable cause) {
        super(message, cause);
    }
}
