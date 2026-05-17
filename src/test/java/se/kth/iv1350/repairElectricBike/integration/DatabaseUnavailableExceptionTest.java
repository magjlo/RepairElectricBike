package se.kth.iv1350.repairElectricBike.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DatabaseUnavailableExceptionTest {
    
    @Test
    public void testDatabaseWithMessage(){
        String expectedMessage = "Database is currently unavailable for customer search.";
        DataBaseUnavailableException exception = new DataBaseUnavailableException(expectedMessage);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testDatabaseWithMessageAndCause(){
        String expectedMessage = "Database is currently unavailable for customer search.";
        Throwable cause = new Throwable("Cause of the exception.");
        DataBaseUnavailableException exception = new DataBaseUnavailableException(expectedMessage, cause);
        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}