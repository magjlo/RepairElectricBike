package se.kth.iv1350.repairElectricBike.model.RepairOrderTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.ElectricBikeDTO;
import se.kth.iv1350.repairElectricBike.model.*;


public class RepairOrderTest {
    private ElectricBikeDTO electricBike;
    private CustomerDTO customer;
    private RepairOrder repairOrder;
    private RepairOrderStatus status;

    @BeforeClass
    public static void prepare(){
        System.out.println("Starting.");
    }

    @AfterClass
    public static void cleanup(){
        System.out.println("Ending.");
    }

    @Before
    public void prepareEach(){
        
        electricBike = new ElectricBikeDTO("brand", "model", "Serial number");
        customer = new CustomerDTO("number", "Email", "Name", electricBike);
        repairOrder = new RepairOrder(customer, "Any description.");
    }

    @Test
    public void TestInitialRepairTaskList(){
        assertNotNull("Assert not null RepairTaskList.", repairOrder.getRepairTaskList());
        assertTrue("Asserts true if empty RepairTaskList.", repairOrder.getRepairTaskList().isEmpty());
    }

    @Test
    public void TestSetRepairOrderStatus(){

        assertNull("Assert status null.", this.status);
        
        this.status = RepairOrderStatus.APPROVED;
        assertEquals(RepairOrderStatus.APPROVED, status);
 
        this.status = null;
        assertNull("Assert status null.", this.status);
    }

    @Test
    public void TestAddRepairTasks(){
        RepairTask repairTask = new RepairTask(null, null);
        
        repairOrder.addRepairTask(repairTask);
        assertEquals("Assert one task was added to repairTaskList.", 1, repairOrder.getRepairTaskList().size());
        
        repairTask = new RepairTask(1f, "something");
        assertNotNull("Assert cost not null.", repairTask.getCost());
        assertNotNull("Assert description not null", repairTask.getTaskDescription());
        
        RepairTask secondRepairTask = new RepairTask(1f, "anything");
        assertFalse("Asserting different object descriptions as different.", repairTask.getTaskDescription().equals(secondRepairTask.getTaskDescription()));
        assertEquals("Different objects assert same cost", repairTask.getCost(), secondRepairTask.getCost());
    }
}
