package se.kth.iv1350.repairElectricBike.model;

/**
 * Handles the Customer type. Customer acts as a data container for now.
 * 
 */
public class Customer {
    private String phoneNumber;
    private String customerEmail;
    private String customerName;
    private ElectricBike electricBike;

    /**
     * Creates an instance of Customer.
     * 
     * @param phoneNumber @param electricBike @param customerEmail @param customerName
     * Are all fields to Customer, electricBike is an object of ElectricBike.
     * 
     */

    public Customer(String phoneNumber, ElectricBike electricBike, String customerEmail, String customerName){
        this.phoneNumber = phoneNumber;
        this.electricBike = electricBike;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public String getCustomerEmail(){
        return this.customerEmail;
    }

    public ElectricBike getElectricBike(){
        return this.electricBike;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
