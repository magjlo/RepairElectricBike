package se.kth.iv1350.repairElectricBike.model;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;

/**
 * Receipt class which serves to create the receipts given to customer and System.Out.
 * 
 */
public class RepairOrderReceipt {
    private StringBuilder receipt;

    /**
     * Creates an instance of RepairOrderReceipt.
     * 
     * @param receipt is a Stringbuilder, could potentially be replaced by an attribute list.
     * 
     */
    public RepairOrderReceipt(){
        this.receipt = new StringBuilder();
    }

    /**
     * Creates the receipt by appending relevant information onto repairOrderReceipt.
     * 
     * @param repairOrder is the source of all information appended onto repairOrderReceipt.
     * 
     */

    public void createReceipt(RepairOrderDTO repairOrderDTO){
        
        this.receipt.append("-----REPAIR ORDER RECEIPT-----")
        .append("\n---Repair Order---")
        .append("\n"+repairOrderDTO.toString())
        .append("---Customer details---\n")
        .append(repairOrderDTO.getCustomerDTO().toString());

    }

    public StringBuilder getRepairOrderReceipt(){
        return this.receipt;
    }
}
