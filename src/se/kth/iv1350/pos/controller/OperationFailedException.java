package se.kth.iv1350.pos.controller;


/**
 * a exception thrown when an operation fails for an unknown reason.
 */
public class OperationFailedException extends Exception {


    /**
     * Creates a new exception with a message and a cause.
     * @param message the message that should be displayed for the exception
     * @param cause the exception that has caused this exceptions
     */
    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
