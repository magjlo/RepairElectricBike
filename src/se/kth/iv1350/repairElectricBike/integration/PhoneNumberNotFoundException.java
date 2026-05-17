package se.kth.iv1350.repairElectricBike.integration;

/**
 * Exception thrown when a phone number provided by the user does not match any customer in the CustomerRegistry.
 * 
 */
public class PhoneNumberNotFoundException extends Exception{
    private String phoneNumberThatCanNotBeFound;

    /**
     * Creates a new instance of PhoneNumberNotFoundException with a message that includes the phone number that could not be found.
     * @param phoneNumberThatCanNotBeFound is the phone number that could not be found.
     */
    public PhoneNumberNotFoundException(String phoneNumberThatCanNotBeFound){
        super("Unable to find customer with phone number: " + phoneNumberThatCanNotBeFound
        + ".");
        this.phoneNumberThatCanNotBeFound = phoneNumberThatCanNotBeFound;
    }

    /**
     * Returns the phone number that could not be found
     */
    public String getPhoneNumberThatCanNotBeFound(){
        return this.phoneNumberThatCanNotBeFound;
    }
}
