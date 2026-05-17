package se.kth.iv1350.repairElectricBike.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepairOrderNotFoundExceptionTest {
    
    @Test
    public void testRepairOrderNotFoundException(){
        String repairOrderIdThatCanNotBeFound = "12345";
        String expectedMessage = "Unable to find repair order with id: " + repairOrderIdThatCanNotBeFound + ".";
        RepairOrderNotFoundException exception = new RepairOrderNotFoundException(repairOrderIdThatCanNotBeFound);
        assertEquals(repairOrderIdThatCanNotBeFound, exception.getRepairOrderIdThatCanNotBeFound());
        assertEquals(expectedMessage, exception.getMessage());
    }
}
