package se.kth.iv1350.repairElectricBike.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.ElectricBikeDTO;

public class CustomerRegistryTest {
    ElectricBikeDTO electricBike = new ElectricBikeDTO("brand", "model", "Serial number");
    CustomerDTO customer = new CustomerDTO("number", "Email", "Name", electricBike);
    CustomerRegistry registry = new CustomerRegistry();

    @Test
    public void testAddCustomer() {
        registry.addCustomer(customer);
        assertNotNull(registry);
    }

    @Test
    public void testFindCustomer() {
        registry.addCustomer(customer);
        try{
            CustomerDTO secondCustomer = registry.findCustomerByPhoneNumber("number");
            assertEquals(customer, secondCustomer);
        } catch (PhoneNumberNotFoundException e) {
            e.printStackTrace();
        } catch (DataBaseUnavailableException e) {
            e.printStackTrace();
        }    
    }

    @Test
    public void testCustomerFields(){
        registry.addCustomer(customer);
        try{
            assertNotNull(registry.findCustomerByPhoneNumber(customer.getPhoneNumber()));
        } catch (PhoneNumberNotFoundException e) {
            e.printStackTrace();
        } catch (DataBaseUnavailableException e) {
            e.printStackTrace();
        }
        String serialNumber = customer.getElectricBikeDTO().getSerialNumber();
        assertEquals(serialNumber, "Serial number");
        assertEquals(customer.getPhoneNumber(), "number");
    }
}
