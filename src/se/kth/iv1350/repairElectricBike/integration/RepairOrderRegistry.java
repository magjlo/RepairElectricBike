package se.kth.iv1350.repairElectricBike.integration;

import java.util.*;
import se.kth.iv1350.repairElectricBike.model.RepairOrder;

/**
 * RepairOrderRegistry which stores approved and finished RepairOrder objects.
 * This class is created during startup.
 * 
 */
public class RepairOrderRegistry {
    private List<RepairOrder> repairOrderList;

    /**
     * Creates an instance of RepairOrderRegistry
     * 
     * @param repairOrderList is an empty list of RepairOrder object type.
     * 
     */
    public RepairOrderRegistry(){
        this.repairOrderList = new ArrayList<>();
    }

    /**
     * Adds a RepairOrder object onto the repairOrderList field of RepairOrderRegistry object.
     * 
     * @param repairOrder is an object of RepairOrder type.
     * 
     */
    public void addRepairOrder(RepairOrder repairOrder){
        this.repairOrderList.add(repairOrder);
    }

    /**
     * Finds a RepairOrder object in the repairOrderList field of RepairOrderRegistry object using string repairOrderId.
     * @param repairOrderId is a String gield unique to each <code>RepairOrder</code> object.
     * @return the found RepairOrder object, or null if not found.
     * @throws DataBaseUnavailableException if the database is currently unavailable for repair order search.
     */
    public RepairOrder findRepairOrder(String repairOrderId) throws RepairOrderNotFoundException, DataBaseUnavailableException{
        if(repairOrderId == "DB_UNAVAILABLE"){
            throw new DataBaseUnavailableException("Database is currerntly unavailable for repair order search.");
        }
        RepairOrder foundRepairOrder = null;
        for(RepairOrder repairOrder : this.repairOrderList){
            if(repairOrder.getRepairOrderId().equals(repairOrderId)){
                foundRepairOrder = repairOrder;
                break;
            }
        }
        if(foundRepairOrder == null){
            throw new RepairOrderNotFoundException(repairOrderId);
        }
        return foundRepairOrder;
    }

    public List<RepairOrder> getRepairOrderList(){
        return this.repairOrderList;
    }
}
