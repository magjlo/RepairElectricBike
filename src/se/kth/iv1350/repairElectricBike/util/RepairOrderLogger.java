package se.kth.iv1350.repairElectricBike.util;

import se.kth.iv1350.repairElectricBike.model.RepairOrder;
import se.kth.iv1350.repairElectricBike.model.RepairOrderObserver;

public class RepairOrderLogger implements RepairOrderObserver {
    private FileLogger fileLogger = new FileLogger();

    @Override
    public void updateRepairOrder(RepairOrder repairOrder) {
        fileLogger.log("Repair order updated: " + repairOrder.toString());

    }
}
