package se.kth.iv1350.repairElectricBike.exception;

public class CustomerRegistryException extends Exception {
    
    public CustomerRegistryException(String message) {
        super(message);
    }
    
    public CustomerRegistryException(String message, Throwable cause) {
        super(message, cause);
    }
}
