package se.kth.iv1350.repairElectricBike.integration;

public class RepairOrderNotFoundException extends Exception {
        private String RepairOrderIdThatCanNotBeFound;

        /**
        * Creates an instance of RepairOrderNotFoundException with a message and a cause.
        * @param message is a string that describes the exception.
        */
        public RepairOrderNotFoundException(String RepairOrderIdThatCanNotBeFound){
            super("Unable to find repair order with id: " + RepairOrderIdThatCanNotBeFound + ".");
            this.RepairOrderIdThatCanNotBeFound = RepairOrderIdThatCanNotBeFound;
        }
    
        public String getRepairOrderIdThatCanNotBeFound(){
            return this.RepairOrderIdThatCanNotBeFound;
        }
}
