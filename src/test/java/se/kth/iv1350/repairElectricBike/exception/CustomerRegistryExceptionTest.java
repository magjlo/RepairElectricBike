package se.kth.iv1350.repairElectricBike.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


import se.kth.iv1350.repairElectricBike.controller.Controller;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;
import se.kth.iv1350.repairElectricBike.integration.DataBaseUnavailableException;
import se.kth.iv1350.repairElectricBike.integration.PhoneNumberNotFoundException;
import se.kth.iv1350.repairElectricBike.integration.Printer;
import se.kth.iv1350.repairElectricBike.integration.RepairOrderRegistry;

public class CustomerRegistryExceptionTest {

    @Test
    public void testCustomerRegistryException() throws CustomerRegistryException{
        
        CustomerDTO customerDTO = new CustomerDTO("2", "john.doe@example.com", "John Doe", null);
        CustomerRegistry customerRegistry = new CustomerRegistry();
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        Printer printer = new Printer();
        customerRegistry.addCustomer(customerDTO);
        Controller contr = new Controller(repairOrderRegistry, customerRegistry, printer);
        String unavailablePhoneNumber = "DB_UNAVAILABLE";
        String wrongPhoneNumber = "1";
        boolean exceptionCaughtPhone = false;
        boolean exceptionCaughtDatabase = false;

        try {
            contr.findCustomer(unavailablePhoneNumber);
            fail();
        } catch (CustomerRegistryException e) {
            exceptionCaughtDatabase = true;
            assertEquals("Customer registry is currently unavailable.", e.getMessage());
        }

        try {
            contr.findCustomer(wrongPhoneNumber);
            fail();
        } catch (CustomerRegistryException e) {
            exceptionCaughtPhone = true;
            assertEquals("Customer does not exist in registry with phone number: " + wrongPhoneNumber, e.getMessage());
        }

        assertTrue(exceptionCaughtPhone);
        assertTrue(exceptionCaughtDatabase);
 
    }
}
