package se.kth.iv1350.repairElectricBike.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerRegistryExceptionTest {

    @Test
    public void testCustomerRegistryExceptionMessage() {
        String message = "Customer registry is currently unavailable.";
        CustomerRegistryException exception = new CustomerRegistryException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testCustomerRegistryExceptionCause() {
        String message = "Customer registry is currently unavailable.";
        Throwable cause = new Throwable("Database connection failed.");
        CustomerRegistryException exception = new CustomerRegistryException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
