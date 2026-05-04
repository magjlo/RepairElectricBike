package se.kth.iv1350.repairElectricBike.model;

/**
 * Individual RepairTask structure which comes with a description and cost for each task.
 * 
 */
public class RepairTask {
    private Float cost;
    private String taskDescription;

    /**
     * Creates an instance of RepairTask.
     * @param cost
     * @param description
     * Are both specified during addRepairTask.
     */
    public RepairTask(Float cost, String description){
        this.cost = cost;
        this.taskDescription = description;
    }

    /**
    **/
    public Float getCost(){
        return this.cost;
    }

    /**
    **/
    public String getTaskDescription(){
        return this.taskDescription;
    }
}
