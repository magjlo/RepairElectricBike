package se.kth.iv1350.repairElectricBike.dataTransferObjects;

import java.util.List;

import se.kth.iv1350.repairElectricBike.model.DiagnosticReport;
import se.kth.iv1350.repairElectricBike.model.RepairOrderStatus;
import se.kth.iv1350.repairElectricBike.model.RepairTask;

public class RepairOrderDTO {  
    private final String problemDescription;
    private final String creationDate;
    private final String repairOrderId;
    private final RepairOrderStatus status;
    private final CustomerDTO customerDTO;
    private final DiagnosticReport diagnosticReport;
    private final List<RepairTask> repairTaskList;
    private final float totalCost;

    /**
     * Creates an instance of RepairOrderDTO, with all fields.
     * 
     */
    public RepairOrderDTO(String problemDescription, String creationDate, String repairOrderId, RepairOrderStatus status, CustomerDTO customerDTO, DiagnosticReport diagnosticReport, List<RepairTask> repairTaskList, float totalCost){
        this.problemDescription = problemDescription;
        this.creationDate = creationDate;
        this.repairOrderId = repairOrderId;
        this.status = status;
        this.customerDTO = customerDTO;
        this.diagnosticReport = diagnosticReport;
        this.repairTaskList = repairTaskList;
        this.totalCost = totalCost;
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
        builder.append("Total Cost: " + totalCost + "\n");
        builder.append("Status: " + this.status + "\n");
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

    public float getTotalCost(){
        return this.totalCost;
    }
}