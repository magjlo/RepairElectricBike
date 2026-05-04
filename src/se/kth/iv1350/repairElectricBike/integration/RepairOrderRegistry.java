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
    public RepairOrderRegistry(List<RepairOrder> repairOrderList){
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
}
