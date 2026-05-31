package se.kth.iv1350.repairElectricBike.integration;

import java.util.*;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;

/**
 * RepairOrderRegistry which stores approved and finished RepairOrder objects.
 * This class is created during startup.
 * 
 */
public class RepairOrderRegistry {
    private List<RepairOrderDTO> repairOrderList;

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
     * @param repairOrderDTO is an object of RepairOrderDTO type.
     * 
     */
    public void addRepairOrder(RepairOrderDTO repairOrderDTO){
        this.repairOrderList.add(repairOrderDTO);
    }

    /**
     * Finds a RepairOrder object in the repairOrderList field of RepairOrderRegistry object using string repairOrderId.
     * 
     * @param repairOrderId is a field in the RepairOrder class and is provided by Controller.
     * @return a RepairOrder object if found, otherwise null.
     */
    public RepairOrderDTO findRepairOrderById(String repairOrderId){
        for(RepairOrderDTO repairOrderDTO : this.repairOrderList){
            if(repairOrderDTO.getRepairOrderId().equals(repairOrderId)){
                return repairOrderDTO;
            }
        }
        return null;
    }

    /**
     * Updates a RepairOrder object in the repairOrderList field of RepairOrderRegistry object using string repairOrderId.
     * 
     * @param repairOrderDTO is an object of RepairOrderDTO type which is used to update the RepairOrder object in the repairOrderList.
     * @param repairOrderId is a string that identifies the RepairOrder to be updated.
     */
    public void renewRepairOrderInformation(RepairOrderDTO repairOrderDTO, String repairOrderId){
        for(int i = 0; i < this.repairOrderList.size(); i++){
            if(this.repairOrderList.get(i).getRepairOrderId().equals(repairOrderId)){
                this.repairOrderList.set(i, repairOrderDTO);
                return;
            }
        }
    }
}
