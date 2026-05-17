package se.kth.iv1350.repairElectricBike.view;

import se.kth.iv1350.repairElectricBike.controller.Controller;
import se.kth.iv1350.repairElectricBike.exception.CustomerRegistryException;
import se.kth.iv1350.repairElectricBike.exception.RepairOrderRegistryException;

import java.util.*;

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
        try {
            System.out.println(contr.findCustomerByPhoneNumber("0701234567").toString());
        } catch (CustomerRegistryException e) {
            e.printStackTrace();
        }
        contr.confirmCustomerDetails(true);
        String repairOrderId = contr.createInitialRepairOrderByProblemDescription("The bike has a broken brake.");
        contr.updateRepairOrder("Sample diagnostic report", Arrays.asList(100.0f, 200.0f), Arrays.asList("Replace brake pads", "Replace brake cables"));
        try {
            System.out.println(contr.findRepairOrderById(repairOrderId).toString());
        } catch (RepairOrderRegistryException e) {
            e.printStackTrace();
        }
        contr.approveRepairOrder();
    }
}
