package se.kth.iv1350.repairElectricBike.view;

import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.model.RepairOrderObserver;

public class RepairOrderView implements RepairOrderObserver {
    
    @Override
    public void updateRepairOrder(RepairOrder repairOrder) {
        System.out.println("[AUTOMATED MESSAGE] Repair order updated: " + repairOrder.toString());
    }    
}
