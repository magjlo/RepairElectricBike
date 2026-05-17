package se.kth.iv1350.repairElectricBike.controller;

import java.util.*;
import se.kth.iv1350.repairElectricBike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairElectricBike.integration.PhoneNumberNotFoundException;
import se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;
import se.kth.iv1350.repairElectricBike.integration.DataBaseUnavailableException;
import se.kth.iv1350.repairElectricBike.integration.Printer;
import se.kth.iv1350.repairElectricBike.integration.RepairOrderNotFoundException;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.*;
import se.kth.iv1350.repairElectricBike.exception.CustomerRegistryException;
import se.kth.iv1350.repairElectricBike.exception.RepairOrderRegistryException;
import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.model.RepairOrderReceipt;
import se.kth.iv1350.repairElectricBike.model.RepairTask;
import se.kth.iv1350.repairElectricBike.model.DiagnosticReport;

/**
 * Application controller, the only one that exists.
 * All calls to model are made through the controller.
 * 
 */

public class Controller {
    private RepairOrderRegistry repairOrderRegistry;
    private CustomerRegistry customerRegistry;
    private Printer printer;
    private CustomerDTO customerDTO;
    private RepairOrder repairOrder;
    private RepairOrderReceipt repairOrderReceipt;

    /**
    * Creates a new instance of controller
    * 
    * @param repairOrderRegistry is an instance of the RepairOrderRegistry class 
    * which stores RepairOrder objects.
    * 
    * @param customerRegistry isn an instanc eof the CustomerRegistry class
    * which stores Customer objects.
    * 
    * @param printer is an instance of the Printer class which handles
    * printing and return of RepairOrder. 
    * 
    */

    public Controller(RepairOrderRegistry repairOrderRegistry, CustomerRegistry customerRegistry, Printer printer){
        this.repairOrderRegistry = repairOrderRegistry;
        this.customerRegistry = customerRegistry;
        this.printer = printer;
    }

    /**
    * Finds a customer object stored in CustomerRegistry using string phonenumber.
    * Subsequently returns the found customer details as a CustomerDTO object.
    * 
    * @param phoneNumber is a field in the Customer class and is provided by View.
    * 
    */

    public void findCustomerByPhoneNumber(String phoneNumber) throws CustomerRegistryException{
        try{
            this.customerDTO = customerRegistry.findCustomer(phoneNumber);
        } catch(PhoneNumberNotFoundException phoNumNotFoundExc){
            throw new CustomerRegistryException("Customer does not exist in registry.");
        } catch(DataBaseUnavailableException dbUnavailExc){
            throw new CustomerRegistryException("Customer registry is currently unavailable.", dbUnavailExc);
        }
        System.out.println(customerDTO.toString());
    }
    /**
    * Checks the customer initialized here against the one found in customer registry.
    * 
    * @param customer is an instance of the Customer class.
    * 
    * @return the function returns a boolean confirming or denying customer registry presence.
    * 
    */

    public void confirmCustomerDetails(Boolean areDetailsCorrect){
        if(areDetailsCorrect){
            System.out.println("\nCustomer details confirmed.");
        } else {
            System.out.println("\nCustomer details are not correct.");
        }
    }

    /**
    * Method is responsible for creating the initial repair order. The method returns a unique order ID.
    * 
    * @param problemDescription describes the problem with the bike and is a field of RepairOrder
    * only after customer is found in customer registry.
    * 
    * <code>setRepairOrderStatus("NEWLY_CREATED")</code> sets the status field of RepairOrder.
    * 
    */

    public String createInitialRepairOrderByProblemDescription(String problemDescription){
       this.repairOrder = new RepairOrder(this.customerDTO, problemDescription);
       repairOrder.setRepairOrderStatus("NEWLY_CREATED");
       saveRepairOrderToRegistry();
       return repairOrder.getRepairOrderId();
    }

    /**
     * Returns a RepairOrder object associated with a given repairOrderId.
     * 
     * @param repairOrderId is a unique string associated with a single repair order.
     * 
     */
    public RepairOrder findRepairOrderById(String repairOrderId) throws RepairOrderRegistryException{
        try{
            this.repairOrder = repairOrderRegistry.findRepairOrder(repairOrderId);
        } catch(RepairOrderNotFoundException repOrdNotFoundExc){
            throw new RepairOrderRegistryException("Repair order does not exist in registry.");
        } 
        catch(DataBaseUnavailableException dbUnavailExc){
            throw new RepairOrderRegistryException("Repair order registry is currently unavailable.", dbUnavailExc);
        }
        System.out.println("\n"+repairOrder.toString());
        return getRepairOrder();
    }

    /**
    * Updates the RepairOrder fields with technician diagnostic report and repair tasks
    * 
    * @param reportText is the necessary field for DiagnosticReport objects
    * 
    * @param costList is an Arraylist of floats, there is a cost to each added task in repairOrder.
    * 
    * @param taskDescriptionList is an Arraylist of taskDescription that describes the necessary fixes (tasks).
    * 
    * The method also saves the repair order to the repair order registry
    * 
    */
   
    public void updateRepairOrder(String reportText, List<Float> costList, List<String> taskDescriptionList){
        
        getRepairOrder().setDiagnosticReport(new DiagnosticReport(reportText));
        for(int i = 0; i < costList.size(); i++){
            Float cost = costList.get(i);
            String taskDescription = taskDescriptionList.get(i);
            repairOrder.addRepairTask(new RepairTask(cost, taskDescription));
        }
        repairOrder.setRepairOrderStatus("READY_FOR_APPROVAL");
    }

    /**
    * Sets status of RepairOrder object to APPROVED and Prints repair order.
    * 
    */
    public void approveRepairOrder(){
        repairOrder.setRepairOrderStatus("APPROVED");
        System.out.println("\nRepair order approved.\n");
        printRepairOrder();
    }

    /**
    * Prints the RepairOrderReceipt from <code>fetchReceipt()</code> to the console (System.Out)
    * 
    */
    public void printRepairOrder(){
        initializeRepairOrderReceipt();
        this.printer.printRepairOrderReceipt(repairOrderReceipt);
    }

    /**
     * Initializes the receipt based on the current repair order.
     * 
     */
    private void initializeRepairOrderReceipt(){
        this.repairOrderReceipt = printer.getRepairOrderReceipt();
        repairOrderReceipt.createReceipt(this.repairOrder);
    }

    /**
    * Saves a RepairOrder object to the RepairOrderRegistry, never delete.
    * 
    */
    private void saveRepairOrderToRegistry(){
        this.repairOrderRegistry.addRepairOrder(this.repairOrder);
    }

    public CustomerDTO getCustomerDTO(){
       return this.customerDTO;
    }

    public RepairOrder getRepairOrder(){
        return this.repairOrder;
    }
    
    public CustomerRegistry getCustomerRegistry(){
        return this.customerRegistry;
    }

    public RepairOrderRegistry getRepairOrderRegistry(){
        return this.repairOrderRegistry;
    }
    
    public void setRepairOrderAsComplete(){
        repairOrder.setRepairOrderStatus("COMPLETE");
    }

    public void setRepairOrderAsPaid(){
        repairOrder.setRepairOrderStatus("PAID");
    } 

}

