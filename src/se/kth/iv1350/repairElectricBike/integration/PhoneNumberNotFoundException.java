package se.kth.iv1350.repairElectricBike.integration;

public class PhoneNumberNotFoundException extends Exception{
    private String phoneNumberThatCanNotBeFound;

    public PhoneNumberNotFoundException(String phoneNumberThatCanNotBeFound){
        super("Unable to find customer with phone number: " + phoneNumberThatCanNotBeFound
        + ".");
        this.phoneNumberThatCanNotBeFound = phoneNumberThatCanNotBeFound;
    }

    public String getPhoneNumberThatCanNotBeFound(){
        return this.phoneNumberThatCanNotBeFound;
    }
}
