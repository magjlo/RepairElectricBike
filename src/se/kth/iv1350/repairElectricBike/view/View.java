package se.kth.iv1350.repairElectricBike.view;

import java.util.Arrays;

import se.kth.iv1350.repairElectricBike.controller.*;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.ElectricBikeDTO;
import se.kth.iv1350.repairElectricBike.exception.CustomerRegistryException;

/**
 * Placeholder class for view as it does not exist yet.
 * 
 */
public class View {
    private Controller contr;

    /**
     * Creates the only view instance which performs the logic of the program through controller.
     * 
     * @param contr only controller instance in the program.
     * 
     */
    public View(Controller contr){
        this.contr = contr;
    }

    /**
     * Sample execution of program with dummy Customer and ElectricBike objects.
     * Methods moves through the basic flow of the scenario.
     * 
     */
    public void sampleExecution(){

        ElectricBikeDTO electricBikeDTO = new ElectricBikeDTO("Trek", "Madone", "SN123456789");
        CustomerDTO customerDTO = new CustomerDTO("0701234567", "John.Doe@gmail.com", "John Doe", electricBikeDTO);
        contr.addNewCustomer(customerDTO);

        try{
            contr.findCustomer("0701234567");
        } catch (CustomerRegistryException custRegException) {
            System.exit(1);
        }
    
        contr.createInitialRepairOrder("The bike has a broken brake.");
        contr.updateCurrentRepairOrder("Sample diagnostic report", Arrays.asList(100.0f, 200.0f), Arrays.asList("Replace brake pads", "Replace brake cables"));
        contr.approveAndPrintRepairOrder();
    }
}
