package se.kth.iv1350.repairElectricBike.startup;

import se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;
import se.kth.iv1350.repairElectricBike.integration.Printer;
import se.kth.iv1350.repairElectricBike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairElectricBike.model.RepairOrderReceipt;
import se.kth.iv1350.repairElectricBike.controller.Controller;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.ElectricBikeDTO;
import se.kth.iv1350.repairElectricBike.view.View;

/**
 * Main class which starts all needed aspects of the program.
 * Program control flow downstream causes a demonstration of the scenario with code.
 * 
 */

public class Main {
    
    /**
     * Only static method in the project, initiates the startup when run.
     * 
     * @param args is unused as there is no user input from console (yet).
     * 
     */
    public static void main(String[] args){
        
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
        CustomerRegistry customerRegistry = new CustomerRegistry();
        ElectricBikeDTO electricBikeDTO = new ElectricBikeDTO("Trek", "Madone", "SN123456789");
        CustomerDTO customerDTO = new CustomerDTO("0701234567", "John.Doe@gmail.com", "John Doe", electricBikeDTO);
        customerRegistry.addCustomer(customerDTO);
        Printer printer = new Printer(new RepairOrderReceipt());
        Controller contr = new Controller(repairOrderRegistry, customerRegistry, printer);
        new View(contr).sampleExecution();
    }
}
