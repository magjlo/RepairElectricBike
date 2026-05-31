package se.kth.iv1350.repairElectricBike.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;

public class DatabaseUnavailableExceptionTest {
    
    @Test
    public void testDatabaseAvailability(){

        CustomerDTO customerDTO = new CustomerDTO("2", "john.doe@example.com", "John Doe", null);
        CustomerRegistry customerRegistry = new CustomerRegistry();
        customerRegistry.addCustomer(customerDTO);
        String phoneNumber = "DB_UNAVAILABLE";
        boolean exceptionCaught = false;

        try {
            customerRegistry.findCustomerByPhoneNumber(phoneNumber);
            fail();
        } catch (DataBaseUnavailableException e) {
            exceptionCaught = true;
            assertEquals("Database is currently unavailable for customer search.", e.getMessage());
        } catch (PhoneNumberNotFoundException e) {
            fail();
        }
        assertTrue(exceptionCaught);

    }
}