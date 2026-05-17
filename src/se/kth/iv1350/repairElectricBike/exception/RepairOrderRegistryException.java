package se.kth.iv1350.repairElectricBike.exception;

/**
 * Exception class for handling exceptions related to the RepairOrderRegistry class.
 * This class is used to wrap exceptions thrown by the RepairOrderRegistry class.
 */
public class RepairOrderRegistryException extends Exception {

    /**
     * Creates a new instance of RepairOrderRegistryException with the specified message.
     * @param message is a string describing the exception that occurred.
     */
    public RepairOrderRegistryException(String message) {
        super(message);
    }
    
    /**
     * Creates a new instance of RepairOrderRegistryException with the specified message and cause.
     * @param message is a string describing the exception that occurred.
     * @param cause is a Throwable object that represents the cause of the exception.
     */
    public RepairOrderRegistryException(String message, Throwable cause) {
        super(message, cause);
    }
}
