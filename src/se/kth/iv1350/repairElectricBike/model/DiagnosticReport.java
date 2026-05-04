package se.kth.iv1350.repairElectricBike.model;

/**
 * DiagnosticReport class has a single private attribute and acts as a simple data container.
 * 
 */
public class DiagnosticReport {
    private String reportText;

    /**
     * Creates an instance of DiagnosticReport.
     * 
     * @param reportText is a String but would be more appropriate as a pdf or alternative report files
     * String is used for simplicity and would represent an entire report on theory.
     * 
     */
    public DiagnosticReport(String reportText){
        this.reportText = reportText;
    }
}
