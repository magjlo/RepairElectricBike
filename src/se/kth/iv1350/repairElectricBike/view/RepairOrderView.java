package se.kth.iv1350.repairElectricBike.view;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;
import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.model.RepairOrderObserver;

public class RepairOrderView implements RepairOrderObserver {
    
    @Override
    public void updateRepairOrder(RepairOrderDTO repairOrderDTO) {
        System.out.println("[AUTOMATED MESSAGE] Repair order updated: " + repairOrderDTO.toString());
    }    
}
