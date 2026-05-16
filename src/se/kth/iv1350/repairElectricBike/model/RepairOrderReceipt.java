package se.kth.iv1350.repairElectricBike.model;

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

    public void createReceipt(RepairOrder repairOrder){
        
        this.receipt.append("-----REPAIR ORDER RECEIPT-----")
        .append("\n---Repair Order---")
        .append("\n"+repairOrder.toString())
        .append("\n"+repairOrder.getCreationDate())
        .append("\nCustomer details:")
        .append(repairOrder.getCustomerDTO().toString())
        .append("\n---Repair Tasks and Costs---");
        
        for(RepairTask repairTask : repairOrder.getRepairTaskList()){
            this.receipt.append("\n\tTask description: ").append(repairTask.getTaskDescription())
                .append(" Cost: ").append(repairTask.getCost());
        }
    }

    public StringBuilder getReceipt(){
        return this.receipt;
    }
}
