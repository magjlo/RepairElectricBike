package se.kth.iv1350.repairElectricBike.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairElectricBike.model.Customer;
/** 
 * CustomerRegistry which stores instances of Customer objects.
 * Is created on startup.
 * 
*/
public class CustomerRegistry {
    private List<Customer> customerList;

    /**
     * Creates an instance/object of CustomerRegistry.
     * 
     * @param customerList is not used or necessary as of this implementation.
     * 
     */

    public CustomerRegistry(List<Customer> customerList){
        this.customerList = new ArrayList<>();
    }

    /**
     * Adds a Customer object to the CustomerRegistry.
     * 
     * @param customer is passed from the outside.
     * 
     */

    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }

    /**
     * 
     * @param phoneNumber is sole Customer field used to find Customer object per scenario.
     * 
     * @return Customer is the Customer object which has a matchin phoneNumber field to @param phonenumber.
     * @return Is a null value if a customer is not found.
     * 
     */
    public Customer findCustomer(String phoneNumber){

        for(Customer customer : this.customerList){
            if(customer.getPhoneNumber().equals(phoneNumber)){
                return customer;
            }
        }
        return null;
    }
}
