package se.kth.iv1350.repairElectricBike.integration;

/**
 * DataBaseUnavailableException is an exception class that is thrown when the database is unavailable for customer search or repair order search.
 * This class is used in the CustomerRegistry and RepairOrderRegistry classes.
 */
public class DataBaseUnavailableException extends RuntimeException {
    
    /**
     * Creates an instance of DataBaseUnavailableException with a message and a cause.
     * @param message is a string that describes the exception.
     */
    public DataBaseUnavailableException(String message) {
        super(message);
    }

    /**
     * Creates an instance of DataBaseUnavailableException with a message and a cause.
     * @param message is a string that describes the exception.
     * @param cause is a Throwable object that represents the cause of the exception.
     */
    public DataBaseUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

}
