package se.kth.iv1350.repairElectricBike.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.iv1350.repairElectricBike.dataTransferObjects.CustomerDTO;
import se.kth.iv1350.repairElectricBike.dataTransferObjects.ElectricBikeDTO;



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

    @After
    public void cleanupEach(){

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
        this.status = RepairOrderStatus.PAID;
        this.status = RepairOrderStatus.COMPLETED;
        assertEquals(RepairOrderStatus.COMPLETED, status);
        this.status = null;
        assertNull("Assert status null.", this.status);
    }

    @Test
    public void TestAddRepairTasks(){
        repairOrder.addRepairTasks(java.util.Arrays.asList(1.0f), java.util.Arrays.asList("something"));
        assertNotNull("Assert repairTaskList not null.", repairOrder.getRepairTaskList());
        assertEquals("Assert one task was added to repairTaskList.", 1, repairOrder.getRepairTaskList().size());
        List<RepairTask> repairTaskList = repairOrder.getRepairTaskList();
        assertEquals("Assert description of task is correct.", "something", repairTaskList.get(0).getTaskDescription());
        assertEquals("Assert cost of task is correct.", 1.0f, repairTaskList.get(0).getCost(), 0.001);
    }
}
