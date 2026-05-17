package se.kth.iv1350.repairElectricBike.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.*;


public class CustomerRegistryTest {
    ElectricBikeDTO electricBike = new ElectricBikeDTO("brand", "model", "Serial number");
    CustomerDTO customer = new CustomerDTO("number", "Email", "John",electricBike);
    CustomerRegistry registry = new CustomerRegistry();

    @Test
    public void testAddCustomer() {
        registry.addCustomer(customer);
        assertNotNull(registry);
    }

    @Test
    public void testFindCustomer() {
        registry.addCustomer(customer);
        try {
            registry.findCustomer("number");
            CustomerDTO secondCustomer = registry.findCustomer("number");
            assertEquals(customer, secondCustomer);
        } catch (PhoneNumberNotFoundException e) {
            e.printStackTrace();
        } catch (DataBaseUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomerFields(){
        try {
            registry.addCustomer(customer);
            assertNotNull(registry.findCustomer(customer.getPhoneNumber()));
            registry.findCustomer(customer.getPhoneNumber()).toString();
            assertEquals(customer.getPhoneNumber(), "number");
        } catch (PhoneNumberNotFoundException e) {
            e.printStackTrace();
        } catch (DataBaseUnavailableException e) {
            e.printStackTrace();
        }
    }
}
