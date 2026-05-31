package se.kth.iv1350.repairElectricBike.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * FileLogger is a utility class that provides logging functionality to the application.  It allows for logging messages to a log file.
 * 
 */
public class FileLogger {
    private PrintWriter logFile;

    /**
     * Creates an instance of FileLogger and initializes the log file. 
     * 
     * @throws IOException if the log file cannot be created or accessed.
     */
    public FileLogger(String fileName) {
        try {
            this.logFile = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Failed to initialize log file: " +  e);
        }
    }

    /**
     * Logs a message to the log file. Each message is written on a new line.
     * @param message the message to log
     */
    public void log(String message) {
        logFile.println("LOG EVENT: " + LocalDateTime.now());
        logFile.println(message);
        logFile.flush();
    }

    /**
     * Logs an exception to the log file, including a custom message and the stack trace of the exception.
     * @param message the custom message to log
     * @param exception the exception to log
     */
    public void logException(String message, Throwable exception) {
        logFile.println("LOG EVENT: " + LocalDateTime.now());
        logFile.println(message);
        exception.printStackTrace(logFile);
        logFile.flush();
    }
}
