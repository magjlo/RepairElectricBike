package se.kth.iv1350.repairElectricBike.model;

/**
 * ElectricBike class which acts as a data container for the scenario.
 * 
 */
public class ElectricBike {
    private String brand;
    private String model;
    private String serialNumber;

    /**
     * Creates an instance of ElectricBike.
     * 
     * @param brand @param bikeModel @param serialNumber
     * Are all present and yet have no purpose to the code only to the scenario, serve to complicate code for now.
     * 
     */
    public ElectricBike(String brand, String bikeModel, String serialNumber){
        this.brand = brand;
        this.model= bikeModel;
        this.serialNumber = serialNumber;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getModel(){
        return this.model;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }
}
