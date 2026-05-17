package se.kth.iv1350.repairElectricBike.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepairOrderRegistryExceptionTest {
    
    @Test
    public void testRepairOrderRegistryExceptionMessage() {
        String message = "Repair order registry is currently unavailable.";
        RepairOrderRegistryException exception = new RepairOrderRegistryException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testRepairOrderRegistryExceptionCause() {
        String message = "Repair order registry is currently unavailable.";
        Throwable cause = new Throwable("Database connection failed.");
        RepairOrderRegistryException exception = new RepairOrderRegistryException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
