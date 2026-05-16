package se.kth.iv1350.repairElectricBike.dataTransferObjects;

public final class ElectricBikeDTO {
    private final String brand;
    private final String bikeModel;
    private final String serialNumber;  

    public ElectricBikeDTO(String brand, String bikeModel, String serialNumber){
        this.brand = brand;
        this.bikeModel = bikeModel;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Brand: " + this.brand + ", ");
        builder.append("Model: " + this.bikeModel + ", ");
        builder.append("Serial Number: " + this.serialNumber);
        return builder.toString();
    }

    public String getBrand(){
        return this.brand;
    }

    public String getBikeModel(){
        return this.bikeModel;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }
}
