package se.kth.iv1350.repairElectricBike.view;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;
import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.model.RepairOrderObserver;

public class RepairOrderView implements RepairOrderObserver {
    
    /**
     * This method is called when a repair order is updated. It prints the updated repair order to the console.
     */
    @Override
    public void updateRepairOrderDTO(RepairOrderDTO repairOrderDTO) {
        System.out.println("[AUTOMATED MESSAGE] Repair order updated: " + repairOrderDTO.toString());
    }    
}
