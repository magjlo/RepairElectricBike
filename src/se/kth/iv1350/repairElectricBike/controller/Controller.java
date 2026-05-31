package se.kth.iv1350.repairElectricBike.controller;

import java.util.*;
import se.kth.iv1350.repairElectricBike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.exception.CustomerRegistryException;
import se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;
import se.kth.iv1350.repairElectricBike.integration.DataBaseUnavailableException;
import se.kth.iv1350.repairElectricBike.integration.PhoneNumberNotFoundException;
import se.kth.iv1350.repairElectricBike.integration.Printer;
import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.util.FileLogger;
import se.kth.iv1350.repairElectricBike.util.RepairOrderLogger;
import se.kth.iv1350.repairElectricBike.view.RepairOrderView;

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
    private FileLogger  fileLogger = new FileLogger("log.txt");

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
    * 
    * @param phoneNumber is a field in the Customer class and is provided by View.
    * @throws CustomerRegistryException is thrown when customer with provided phone number does not exist in the registry or when registry is unavailable.
    */
    public void findCustomer(String phoneNumber) throws CustomerRegistryException{
        try {
            this.customerDTO = customerRegistry.findCustomerByPhoneNumber(phoneNumber);
            System.out.println("Customer found: " + this.customerDTO.toString()+"\n");
            
        } catch (PhoneNumberNotFoundException phoNumNotFoundException) {
            System.out.println("Customer not found with phone number: " + phoneNumber);
            throw new CustomerRegistryException("Customer does not exist in registry with phone number: " + phoneNumber);

        } catch (DataBaseUnavailableException dBUnavailableException) {
            System.out.println("Customer registry is currently unavailable.");
            fileLogger.logException("Customer data base is unreachable.", dBUnavailableException);
            throw new CustomerRegistryException("Customer registry is currently unavailable.");
        }
    }


    /**
    * Method is responsible for creating the initial repair order. Repair order is saved to the RepairOrderRegistry and its status is set to NEWLY_CREATED.
    * The method also adds the RepairOrder object to the repairOrderList field of RepairOrderRegistry object.
    * Method also adds observers to the RepairOrder object which are responsible for logging and presentation of the order.
    * 
    * @param problemDescription describes the problem with the bike and is a field of RepairOrder
    * only after customer is found in customer registry.
    * 
    * <code>setRepairOrderStatus("NEWLY_CREATED")</code> sets the status field of RepairOrder.
    * 
    */
    public void createInitialRepairOrder(String problemDescription){
        this.repairOrder = new RepairOrder(this.customerDTO, problemDescription);
        this.repairOrder.setRepairOrderStatus("NEWLY_CREATED");
        this.repairOrder.addRepairOrderObserver(new RepairOrderView());
        this.repairOrder.addRepairOrderObserver(new RepairOrderLogger());

       addNewRepairOrderToRegistry(this.repairOrder);

    }

    /**
     * Prints the current RepairOrder object in the controller.
     * 
     */
    public void presentCurrentRepairOrder(){
        System.out.println("----CURRENT REPAIR ORDER-----");
        System.out.println(this.repairOrder.repairOrderToDTO().toString());
    }

    /**
     * Returns a RepairOrder object associated with a given repairOrderId.
     * 
     * @param repairOrderId is a unique string associated with a single repair order.
     * 
     */
    public void findAndPresentCurrentRepairOrder(String repairOrderId){
        System.out.println("----CURRENT REPAIR ORDER-----");
        System.out.println(this.repairOrder.repairOrderToDTO().toString());
    }
    
    /**
    * Updates the RepairOrder fields with technician diagnostic report and repair tasks which are added to the RepairOrder object. 
    * Status of the order is set to READY_FOR_APPROVAL and the order is updated in the RepairOrderRegistry.
    * 
    * @param reportText is the necessary field for DiagnosticReport objects
    * 
    * @param costList is an Arraylist of floats, there is a cost to each added task in repairOrder.
    * 
    * @param taskDescriptionList is an Arraylist of taskDescription that describes the necessary fixes (tasks).
    * 
    */

    public void updateCurrentRepairOrder(String reportText, List<Float> costList, List<String> taskDescriptionList){
        this.repairOrder.setDiagnosticReport(reportText);
        this.repairOrder.addRepairTasks(costList, taskDescriptionList);
        this.repairOrder.setRepairOrderStatus("READY_FOR_APPROVAL");
        updateRepairOrderInformationInRegistry(this.repairOrder);
    }

    /**
    * Sets status of RepairOrder object to APPROVED and prints it. Order is updated in the RepairOrderRegistry.
    * 
    */
    public void approveAndPrintRepairOrder(){
        this.repairOrder.setRepairOrderStatus("APPROVED");
        updateRepairOrderInformationInRegistry(this.repairOrder);
        this.repairOrder.printRepairOrder(this.printer);
    }
    

    /**
    * Sets status of RepairOrder object to COMPLETE.
    * 
    */
    public void setRepairOrderAsComplete(){
        this.repairOrder.setRepairOrderStatus("COMPLETE");
        updateRepairOrderInformationInRegistry(this.repairOrder);
    }

    /**
    * Sets status of RepairOrder object to PAID.
    * 
    */
    public void setRepairOrderAsPaid(){
        this.repairOrder.setRepairOrderStatus("PAID");
        updateRepairOrderInformationInRegistry(this.repairOrder);
    } 
    
    /**
     * Adds a customer to the CustomerRegistry.
     * @param customerDTO DTO of customer to be added to the registry. DTO has to be passed from View.
     */
    public void addNewCustomer(CustomerDTO customerDTO){
        this.customerRegistry.addCustomer(customerDTO);
    }

    /**
     * Adds a new repair order to the RepairOrderRegistry.
     * @param repairOrder is the RepairOrder object to be added to the registry.
     */
    public void addNewRepairOrderToRegistry(RepairOrder repairOrder){
        this.repairOrderRegistry.addRepairOrder(repairOrder.repairOrderToDTO());
    }

    /** 
     * Updates the information of a repair order in the RepairOrderRegistry.
     * 
     * @param repairOrder is the updated RepairOrder object whose information is to be updated in the registry.
     */
    public void updateRepairOrderInformationInRegistry(RepairOrder repairOrder){
        this.repairOrderRegistry.renewRepairOrderInformation(repairOrder.repairOrderToDTO(), repairOrder.getRepairOrderId());
    }
}

