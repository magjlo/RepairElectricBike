package se.kth.iv1350.repairElectricBike.integration;
/**
 * Handles printer operations that are used at the end of the scenario after repair order is approved.
 *  
 */

public class Printer {

    /**
     * Creates an instance/object of the Printer class.
     * 
     */

    public Printer( ){
    }

    /**
     * Prints the created RepairOrderReceipt to the console (System.Out).
     * 
     * @param receiptStringBuilder is the StringBuilder created in RepairOrderReceipt which 
     * contains all information about the repair order and customer. Unfortunately, the printer can not interact with the model,
     * and must therefore recieve the stringbuilder directly rather than the object.
     * 
     */
    public void printRepairOrderReceipt(StringBuilder receiptStringBuilder){
        System.out.println(receiptStringBuilder);
    }
}
