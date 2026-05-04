package se.kth.iv1350.repairElectricBike.integration;

import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.model.RepairOrderReceipt;
import se.kth.iv1350.repairElectricBike.model.RepairTask;

/**
 * Handles printer operations that are used at the end of the scenario after repair order is approved.
 *  
 */

public class Printer {
    private RepairOrderReceipt repairOrderReceipt;

    /**
     * Creates an instance/object of the Printer class.
     * 
     * @param repairOrderReceipt is an object with a single field which is a StringBuilder.
     * 
     */

    public Printer(RepairOrderReceipt repairOrderReceipt){
        this.repairOrderReceipt = repairOrderReceipt;
    }

    /**
     * Creates the receipt by appending relevant information onto repairOrderReceipt.
     * 
     * @param repairOrder is the source of all information appended onto repairOrderReceipt.
     * 
     */

    private void createReceipt(RepairOrder repairOrder){
        
        this.repairOrderReceipt.getReceipt().append("---Repair Order---")
        .append("\nCustomer details:")
        .append("\n\tName: ").append(repairOrder.getCustomer().getCustomerName())
        .append("\n\tPhone number: ").append(repairOrder.getCustomer().getPhoneNumber())
        .append("\n\tEmail: ").append(repairOrder.getCustomer().getCustomerEmail())
        .append("\n\tProblem description: ").append(repairOrder.getProblemDescription())
        .append("\nElectric bike details:")
        .append("\n\tBrand: ").append(repairOrder.getCustomer().getElectricBike().getBrand())
        .append("\n\tModel: ").append(repairOrder.getCustomer().getElectricBike().getModel())
        .append("\n\tSerial number: ").append(repairOrder.getCustomer().getElectricBike().getSerialNumber())
        .append("\n---Repair Tasks and Costs---");
        
        for(RepairTask repairTask : repairOrder.getRepairTaskList()){
            this.repairOrderReceipt.getReceipt().append("\n\tTask description: ").append(repairTask.getTaskDescription())
                .append(" Cost: ").append(repairTask.getCost());
        }
    }

    /**
     * Calls the createReceipt method to modify the RepairOrderReceipt.
     * 
     * @param repairOrder basis for createReceipt.
     * 
     * @return Modified receipt is returned outside after creation.
     * 
     */

    public RepairOrderReceipt returnRepairOrderReceipt(RepairOrder repairOrder){
        createReceipt(repairOrder);
        return this.repairOrderReceipt;
    }

    /**
     * Prints the created RepairOrderReceipt to the console (System.Out).
     * 
     * @param repairOrderReceipt is the finished RepairOrderReceipt.
     * 
     */
    public void printRepairOrderReceipt(RepairOrderReceipt repairOrderReceipt){
        System.out.println(this.repairOrderReceipt.getReceipt().toString());
    }
}
