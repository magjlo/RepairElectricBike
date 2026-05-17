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

        assertNull("Assert status null.", repairOrder.getStatus());
        
        repairOrder.setRepairOrderStatus("APPROVED");
        assertEquals(RepairOrderStatus.APPROVED, repairOrder.getStatus());
 
        repairOrder.setRepairOrderStatus("REJECTED");
        assertEquals(RepairOrderStatus.REJECTED, repairOrder.getStatus());
    }

    @Test
    public void testSetDiagnosticReport(){
        DiagnosticReport diagnosticReport = new DiagnosticReport("Any description.");
        repairOrder.setDiagnosticReport(diagnosticReport);
        assertEquals(diagnosticReport, repairOrder.getDiagnosticReport());
    }
}
