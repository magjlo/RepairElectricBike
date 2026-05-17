package se.kth.iv1350.repairElectricBike.exception;

/**
 * Exception class for handling exceptions related to the CustomerRegistry class.
 * This class is used to wrap exceptions thrown by the CustomerRegistry class.
 */
public class CustomerRegistryException extends Exception {
    
    /**
     * Creates a new instance of CustomerRegistryException with the specified message.
     * @param message is a string describing the exception that occurred.
     */
    public CustomerRegistryException(String message) {
        super(message);
    }
    
    /**
     * Creates a new instance of CustomerRegistryException with the specified message and cause.
     * @param message is a string describing the exception that occurred.
     * @param cause is a Throwable object that represents the cause of the exception.
     */
    public CustomerRegistryException(String message, Throwable cause) {
        super(message, cause);
    }
}
