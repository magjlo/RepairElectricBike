package se.kth.iv1350.repairElectricBike.model;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;

/**
 * This interface defines the observer for repair orders.
 * Classes that implement this interface can be notified of changes to repair orders.
 */
public interface RepairOrderObserver {
    
    /**
     * This method is called when a repair order is updated.
     * @param repairOrder the repair order that triggered the notification.
     */
    void updateRepairOrderDTO(RepairOrderDTO repairOrderDTO);
}
