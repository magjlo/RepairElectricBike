package se.kth.iv1350.repairElectricBike.integration;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;

public class PhoneNumberNotFoundExceptionTest {
    
    @Test
    public void testPhoneNumberNotFoundException(){

        CustomerDTO customerDTO = new CustomerDTO("2", "john.doe@example.com", "John Doe", null);
        CustomerRegistry customerRegistry = new CustomerRegistry();
        customerRegistry.addCustomer(customerDTO);
        String phoneNumber = "1";
        boolean exceptionCaught = false;

        try {
            customerRegistry.findCustomerByPhoneNumber(phoneNumber);
            fail();
        } catch (PhoneNumberNotFoundException e) {
            exceptionCaught = true;
            assertEquals(phoneNumber, e.getPhoneNumberThatCanNotBeFound());
        } catch (DataBaseUnavailableException e) {
            fail();
        }
        assertTrue(exceptionCaught);;
    }
}
