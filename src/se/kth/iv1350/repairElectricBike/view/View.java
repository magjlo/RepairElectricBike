package se.kth.iv1350.repairElectricBike.view;

import java.util.Arrays;
import java.util.List;

import se.kth.iv1350.repairElectricBike.controller.*;
import se.kth.iv1350.repairElectricBike.model.Customer;
import se.kth.iv1350.repairElectricBike.model.ElectricBike;

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
        
        ElectricBike electricBike = new ElectricBike("brand", "model", "Serial number");
        Customer customer = new Customer("number", electricBike, "Email", "Name");
        contr.getCustomerRegistry().addCustomer(customer);

        List<String> taskDescriptionList = Arrays.asList("item1", "item2", "item3");
        List<Float> costList = Arrays.asList(1f, 2f, 3f);
        contr.enterPhoneNumber("number");

        System.out.println("Correct customer: " + contr.confirmCustomerDetails(customer));
        
        contr.enterProblemDescription("any problem");

        contr.updateRepairOrder("Hello", costList, taskDescriptionList);

        contr.approveRepairOrder();

        contr.addRepairOrderToRegistry();

        contr.printRepairOrder();
    }
}
