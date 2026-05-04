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
    public RepairOrderReceipt(StringBuilder receipt){
        this.receipt = new StringBuilder();
    }

    public StringBuilder getReceipt(){
        return this.receipt;
    }
}
