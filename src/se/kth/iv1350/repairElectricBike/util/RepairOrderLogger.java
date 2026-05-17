package se.kth.iv1350.repairElectricBike.util;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;
import se.kth.iv1350.repairElectricBike.model.RepairOrderObserver;

public class RepairOrderLogger implements RepairOrderObserver {
    private FileLogger fileLogger = new FileLogger("repairOrderLog.txt");

    @Override
    public void updateRepairOrder(RepairOrderDTO repairOrderDTO) {
        fileLogger.log("Repair order updated: " + repairOrderDTO.toString());
    }
}
