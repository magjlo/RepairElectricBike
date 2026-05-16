package se.kth.iv1350.repairElectricBike.integration;

import se.kth.iv1350.repairElectricBike.model.RepairOrderReceipt;

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
     * Prints the created RepairOrderReceipt to the console (System.Out).
     * 
     * @param repairOrderReceipt is the finished RepairOrderReceipt.
     * 
     */
    public void printRepairOrderReceipt(RepairOrderReceipt repairOrderReceipt){
        System.out.println(this.repairOrderReceipt.getReceipt().toString());
    }
}
