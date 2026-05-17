package se.kth.iv1350.repairElectricBike.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.*;;
/** 
 * CustomerRegistry which stores instances of Customer objects.
 * Is created on startup.
 * 
*/
public class CustomerRegistry {
    private List<CustomerDTO> customerDTOList;

    /**
     * Creates an instance/object of CustomerRegistry.
     * 
     * @param customerList is not used or necessary as of this implementation.
     * 
     */

    public CustomerRegistry(){
        this.customerDTOList = new ArrayList<>();
    }

    /**
     * Adds a Customer object to the CustomerRegistry.
     * 
     * @param customer is passed from the outside.
     * 
     */

    public void addCustomer(CustomerDTO customerDTO){
        this.customerDTOList.add(customerDTO);
    }

    /**
     * 
     * @param phoneNumber is sole Customer field used to find Customer object per scenario.
     * 
     * @return Customer is the Customer object which has a matchin phoneNumber field to @param phonenumber.
     * @return Is a null value if a customer is not found.
     * @throws PhoneNumberNotFoundException if no customer is found matching the @param phoneNumber.
     * @throws DataBaseUnavailableException if the database is currently unavailable for customer search.
     */
    public CustomerDTO findCustomer(String phoneNumber) throws PhoneNumberNotFoundException, DataBaseUnavailableException{
        if(phoneNumber == "DB_UNAVAILABLE"){
            throw new DataBaseUnavailableException("Database is currently unavailable for customer search.");
        }
        CustomerDTO foundCustomerDTO = null;
        for(CustomerDTO customerDTO : this.customerDTOList){
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
