package se.kth.iv1350.repairElectricBike.dataTransferObjects;

public final class CustomerDTO {
    private final String phoneNumber;
    private final String customerEmail;
    private final String customerName;
    private final ElectricBikeDTO electricBikeDTO;

    public CustomerDTO(String phoneNumber, String customerEmail, String customerName, ElectricBikeDTO electricBikeDTO){
        this.phoneNumber = phoneNumber;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.electricBikeDTO = electricBikeDTO;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Phone Number: " + this.phoneNumber + ", ");
        builder.append("Email: " + this.customerEmail + ", ");
        builder.append("Name: " + this.customerName + ", ");
        builder.append("Bike details: " + this.electricBikeDTO.toString());
        return builder.toString();
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public String getCustomerEmail(){
        return this.customerEmail;
    }

    public ElectricBikeDTO getElectricBikeDTO(){
        return this.electricBikeDTO;
    }
}
