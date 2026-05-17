package se.kth.iv1350.repairElectricBike.integration;

public class DataBaseUnavailableException extends Exception {
    public DataBaseUnavailableException(String message) {
        super(message);
    }

    public DataBaseUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

}
