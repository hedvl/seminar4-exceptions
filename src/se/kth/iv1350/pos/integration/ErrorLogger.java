package se.kth.iv1350.pos.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Logs exceptions to a file with timestamps.
 */
public class ErrorLogger {
    private static final String LOG_FILE_NAME = "error-log.txt";
    private PrintWriter logWriter;

    /**
     * Creates a new instance of ErrorLogger.
     * Opens the log file for writing.
     */
    public ErrorLogger() {
        try {
            logWriter = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
        } catch (IOException e) {
            System.out.println("Could not open log file: " + LOG_FILE_NAME);
        }
    }

    /**
     * Writes an exception and timestamp to the log file.
     * @param exception The exception to log.
     */
    public void logException(Exception exception) {
        LocalDateTime timestamp = LocalDateTime.now();
        logWriter.println("[" + timestamp + "] ERROR: " + exception.getMessage());
        exception.printStackTrace(logWriter);
    }
}
