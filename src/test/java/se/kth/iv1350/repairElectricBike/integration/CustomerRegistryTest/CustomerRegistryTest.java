package se.kth.iv1350.repairElectricBike.integration.CustomerRegistryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;
import se.kth.iv1350.repairElectricBike.model.*;

public class CustomerRegistryTest {
    ElectricBike electricBike = new ElectricBike("brand", "model", "Serial number");
    Customer customer = new Customer("number", electricBike, "Email", "Name");
    CustomerRegistry registry = new CustomerRegistry(new ArrayList<>());

    @Test
    public void testAddCustomer() {
        registry.addCustomer(customer);
        assertNotNull(registry);
    }

    @Test
    public void testFindCustomer() {
        registry.addCustomer(customer);
        Customer secondCustomer = registry.findCustomer("number");
        assertEquals(customer, secondCustomer);
    }

    @Test
    public void testCustomerFields(){
        registry.addCustomer(customer);
        assertNotNull(registry.findCustomer(customer.getPhoneNumber()));
        registry.findCustomer(customer.getPhoneNumber()).setPhoneNumber("new");
        assertEquals(customer.getPhoneNumber(), "new");
    }
}
