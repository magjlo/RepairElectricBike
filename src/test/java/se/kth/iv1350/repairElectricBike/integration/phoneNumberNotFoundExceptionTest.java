package se.kth.iv1350.repairElectricBike.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PhoneNumberNotFoundExceptionTest {
    
    @Test
    public void testPhoneNumberNotFoundException(){
        String phoneNumberThatCanNotBeFound = "1234567890";
        String expectedMessage = "Unable to find customer with phone number: " + phoneNumberThatCanNotBeFound + ".";
        PhoneNumberNotFoundException exception = new PhoneNumberNotFoundException(phoneNumberThatCanNotBeFound);
        assertEquals(phoneNumberThatCanNotBeFound, exception.getPhoneNumberThatCanNotBeFound());
        assertEquals(expectedMessage, exception.getMessage());
    }
}
