package se.kth.iv1350.repairElectricBike.integration.CustomerRegistryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.*;
import se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;

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
        CustomerDTO secondCustomer = registry.findCustomer("number");
        assertEquals(customer, secondCustomer);
    }

    @Test
    public void testCustomerFields(){
        registry.addCustomer(customer);
        assertNotNull(registry.findCustomer(customer.getPhoneNumber()));
        registry.findCustomer(customer.getPhoneNumber()).toString();
        assertEquals(customer.getPhoneNumber(), "number");
    }
}
