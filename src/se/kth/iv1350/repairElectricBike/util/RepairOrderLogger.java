package se.kth.iv1350.repairElectricBike.util;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;
import se.kth.iv1350.repairElectricBike.model.RepairOrderObserver;

public class RepairOrderLogger implements RepairOrderObserver {
    private FileLogger fileLogger = new FileLogger("repairOrderLog.txt");

    /**
     * This method is called when a repair order is updated. It logs the updated repair order to a file.
     */
    @Override
    public void updateRepairOrderDTO(RepairOrderDTO repairOrderDTO) {
        fileLogger.log("Repair order updated: " + repairOrderDTO.toString());
    }
}
