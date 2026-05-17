package se.kth.iv1350.repairElectricBike.dataTransferObjects;

import java.util.List;

import se.kth.iv1350.repairElectricBike.model.DiagnosticReport;
import se.kth.iv1350.repairElectricBike.model.RepairOrderStatus;
import se.kth.iv1350.repairElectricBike.model.RepairTask;

public class RepairOrderDTO {  
    private String problemDescription;
    private String creationDate;
    private String repairOrderId;
    private RepairOrderStatus status;
    private CustomerDTO customerDTO;
    private DiagnosticReport diagnosticReport;
    private List<RepairTask> repairTaskList;

    /**
     * Creates an instance of RepairOrderDTO, with all fields.
     * 
     */
    public RepairOrderDTO(String problemDescription, String creationDate, String repairOrderId, RepairOrderStatus status, CustomerDTO customerDTO, DiagnosticReport diagnosticReport, List<RepairTask> repairTaskList){
        this.problemDescription = problemDescription;
        this.creationDate = creationDate;
        this.repairOrderId = repairOrderId;
        this.status = status;
        this.customerDTO = customerDTO;
        this.diagnosticReport = diagnosticReport;
        this.repairTaskList = repairTaskList;
    }

    /**
     * Returns a string representation of the repair order.
     * @return a string representation of the repair order.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Creation Date: " + creationDate + "\n");
        builder.append("Repair Order ID: " + repairOrderId + "\n");
        builder.append("Customer Name: " + customerDTO.getCustomerName() + "\n");
        builder.append("Problem Description: " + problemDescription + "\n");
        for(int i = 0; i < repairTaskList.size(); i++){
            RepairTask task = repairTaskList.get(i);
            builder.append("Repair Task " + (i+1) + ": " + task.getTaskDescription() + ", Cost: " + task.getCost() + "\n");
        }
        return builder.toString();
    }

    public String getProblemDescription(){
        return this.problemDescription;
    }

    public List<RepairTask> getRepairTaskList(){
        return this.repairTaskList;
    }

    public String getCreationDate(){
        return this.creationDate;
    }

    public String getRepairOrderId(){
        return this.repairOrderId;
    }

    public RepairOrderStatus getStatus(){
        return this.status;
    }

    public CustomerDTO getCustomerDTO(){
        return this.customerDTO;
    }

    public DiagnosticReport getDiagnosticReport(){
        return this.diagnosticReport;
    }

}
