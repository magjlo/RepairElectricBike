package se.kth.iv1350.repairElectricBike.model;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;

import java.util.*;
import java.time.LocalDateTime;;

/**
 * The center of the scenario for the model. 
 * Handles operations concerning the repair order and is used through controller frequently.
 * 
 */
public class RepairOrder {
    private String problemDescription;
    private String creationDate;
    private String repairOrderId;
    private RepairOrderStatus status;
    private CustomerDTO customerDTO;
    private DiagnosticReport diagnosticReport;
    private List<RepairTask> repairTaskList;

    /**
     * Creates an instance of RepairOrder, no diagnosticReport or status.
     * 
     * @param customer is the scenarios customer, created in view (for now).
     * 
     */
    public RepairOrder(CustomerDTO customer, String problemDescription){
        this.customerDTO = customer;
        this.problemDescription = problemDescription;
        this.repairOrderId = generateUniqueRepairOrderId();
        this.creationDate = LocalDateTime.now().toString();
        this.repairTaskList = new ArrayList<>();
    }

    /**
     * Changes the status field of the RepairOrder object.
     * 
     * @param repairOrderStatus Should be a String matching something in the enumeration.
     * 
     */
    public void setRepairOrderStatus(String repairOrderStatus){
        
        if(repairOrderStatus.equals("NEWLY_CREATED")){
            this.status = RepairOrderStatus.NEWLY_CREATED;
        } else if(repairOrderStatus.equals("READY_FOR_APPROVAL")){
            this.status = RepairOrderStatus.READY_FOR_APPROVAL;
        } else if(repairOrderStatus.equals("APPROVED")){
            this.status = RepairOrderStatus.APPROVED;
        } else if(repairOrderStatus.equals("REJECTED")){
            this.status = RepairOrderStatus.REJECTED;
        } else if(repairOrderStatus.equals("COMPLETED")){
            this.status = RepairOrderStatus.COMPLETED;
        } else if(repairOrderStatus.equals("PAID")){
            this.status = RepairOrderStatus.PAID;
        }
        else{
            System.out.println("Unknown status: " + repairOrderStatus);
        }
    }

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

     /**
     * Sets the diagnostic report field of RepairOrder.
     * 
     * @param diagnosticReport is created in controller and added to the order after technician's diagnosis.
     * 
     */
    
    public void setDiagnosticReport(DiagnosticReport diagnosticReport){
        this.diagnosticReport = diagnosticReport;
    }

    /**
     * Adds a RepairTask object to the repairTaskList.
     * 
     */
    public void addRepairTask(RepairTask repairTask){
        this.repairTaskList.add(repairTask);
    }

    private String generateUniqueRepairOrderId(){
        return UUID.randomUUID().toString();
    }

    public RepairOrderDTO toDTO() {
        return new RepairOrderDTO(
            this.problemDescription,
            this.creationDate,
            this.repairOrderId,
            this.status,         
            this.customerDTO,     
            this.diagnosticReport,
            new ArrayList<>(this.repairTaskList) 
        );
    }
    
    public CustomerDTO getCustomerDTO(){
        return this.customerDTO;
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

    public DiagnosticReport getDiagnosticReport(){
        return this.diagnosticReport;
    }
}
