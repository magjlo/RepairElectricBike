package se.kth.iv1350.repairElectricBike.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
/** 
 * CustomerRegistry which stores instances of Customer objects.
 * Is created on startup.
 * 
*/
public class CustomerRegistry {
    private List<CustomerDTO> customerList;

    /**
     * Creates an instance/object of CustomerRegistry.
     * 
     * @param customerList is not used or necessary as of this implementation.
     * 
     */

    public CustomerRegistry(){
        this.customerList = new ArrayList<>();
    }

    /**
     * Adds a Customer object to the CustomerRegistry.
     * 
     * @param customerDTO is passed from the outside.
     * 
     */

    public void addCustomer(CustomerDTO customerDTO){
        this.customerList.add(customerDTO);
    }

    /**
     * 
     * @param phoneNumber is sole CustomerDTO field used to find Customer object per scenario.
     * 
     * @return CustomerDTO is the CustomerDTO object which has a matchin phoneNumber field to @param phonenumber.
     * @return Is a null value if a customer is not found.
     * @throws PhoneNumberNotFoundException if no customer is found matching the @param phoneNumber.
     * @throws DataBaseUnavailableException if the database is currently unavailable for customer search.
     * 
     */
    public CustomerDTO findCustomerByPhoneNumber(String phoneNumber) throws PhoneNumberNotFoundException, DataBaseUnavailableException{

        if(phoneNumber.contains("DB_UNAVAILABLE")){
            throw new DataBaseUnavailableException("Database is currently unavailable for customer search.");
        }
        CustomerDTO foundCustomerDTO = null;
        for(CustomerDTO customerDTO : this.customerList){
            if(customerDTO.getPhoneNumber().equals(phoneNumber)){
                foundCustomerDTO = customerDTO;
                break;
            }
        }
        if(foundCustomerDTO == null){
            throw new PhoneNumberNotFoundException(phoneNumber);
        }
        return foundCustomerDTO;
    }
}
