package se.kth.iv1350.repairElectricBike.model;

import java.time.LocalDateTime;
import java.util.*;

import se.kth.iv1350.repairElectricBike.integration.Printer;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.RepairOrderDTO;

/**
 * The center of the scenario for the model. 
 * Handles operations concerning the repair order and is used through controller frequently.
 * 
 */
public class RepairOrder {
    private String problemDescription;
    private String creationDate;
    private String repairOrderId;
    private CustomerDTO customerDTO;
    private RepairOrderStatus status;
    private DiagnosticReport diagnosticReport;
    private List<RepairTask> repairTaskList;
    private float totalCost;
    private List<RepairOrderObserver> repairOrderObservers = new ArrayList<>();

    /**
     * Creates an instance of RepairOrder, no diagnosticReport or status.
     * 
     * @param customer is the scenarios customer, created in view (for now).
     * 
     */
    public RepairOrder(CustomerDTO customerDTO, String problemDescription){
        this.customerDTO = customerDTO;
        this.problemDescription = problemDescription;
        this.creationDate = LocalDateTime.now().toString();
        this.repairOrderId = generateUniqueRepairOrderId();
        this.repairTaskList = new ArrayList<>();
        this.status = RepairOrderStatus.NEWLY_CREATED;
    }

    /**
     * Adds a RepairOrderObserver to the list of observers that will be notified when a repair order is updated.
     * @param observer the RepairOrderObserver to be added to the list of observers.
     */
    public void addRepairOrderObserver(RepairOrderObserver observer) {
        repairOrderObservers.add(observer);
    }

    /**
     * Notifies all registered RepairOrderObservers of an update to the repair order by creating a RepairOrderDTO and calling the updateRepairOrder method on each observer.
     */
    private void notifyRepairOrderObservers() {
        RepairOrderDTO repairOrderDTO = repairOrderToDTO();
        for (RepairOrderObserver observer : repairOrderObservers) {
            observer.updateRepairOrderDTO(repairOrderDTO);
        }
    }

    /**
     * Changes the status field of the RepairOrder object.
     * 
     * @param repairOrderStatus Should be a String matching something in the enumeration.
     * <code>notifyRepairOrderObservers()</code> is called at the end of the method to update the view with the new status.
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
        } else{
            System.out.println("Unknown status: " + repairOrderStatus);
        }
        notifyRepairOrderObservers();
    }

    /**
     * Returns a RepairOrderDTO object containing the data of the RepairOrder.
     * 
     */
    public RepairOrderDTO repairOrderToDTO() {
        calculateTotalCost();
        return new RepairOrderDTO(
            this.problemDescription,
            this.creationDate,
            this.repairOrderId,
            this.status,         
            this.customerDTO,     
            this.diagnosticReport,
            new ArrayList<>(this.repairTaskList),
            this.totalCost
        );
    }

    /**
     * Adds a RepairTask object to the repairTaskList.
     * Now notifies the observers of the update to the repair order.
     * 
     * @param costList the list of costs for each repair task.
     * @param taskDescriptionList the list of descriptions for each repair task.
     */
    public void addRepairTasks(List<Float> costList, List<String> taskDescriptionList){

        for(int i = 0; i < costList.size(); i++){
            Float cost = costList.get(i);
            String taskDescription = taskDescriptionList.get(i);
            this.repairTaskList.add(new RepairTask(cost, taskDescription));
        }
        notifyRepairOrderObservers();
    }
    
    public void printRepairOrder(Printer printer){
        RepairOrderDTO repairOrderDTO = repairOrderToDTO();
        RepairOrderReceipt repairOrderReceipt = new RepairOrderReceipt();
        repairOrderReceipt.createReceipt(repairOrderDTO);
        printer.printRepairOrderReceipt(repairOrderReceipt.getRepairOrderReceipt());     
    }

    /**
     * Generates a unique repair order ID using UUID.
     *  
     */
    private String generateUniqueRepairOrderId(){
        return UUID.randomUUID().toString();
    }

    /**
     * Calculates the total cost of the repair order by summing the cost of all repair tasks in the repairTaskList.
     */
    private void calculateTotalCost(){
        float total = 0.0f;
        for(RepairTask task : repairTaskList){
            total += task.getCost();
        }
        this.totalCost = total;
    }

    /**
     * Sets the diagnostic report for the repair order and notifies all registered observers of the update.
     * @param reportText the text of the diagnostic report to be set for the repair order.
     */
    public void setDiagnosticReport(String reportText){
        this.diagnosticReport = new DiagnosticReport(reportText);
        notifyRepairOrderObservers();
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
