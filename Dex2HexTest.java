import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.*;

public class Dex2HexTest {

    // Utility method to capture log output as wanted from sonarqube
    public String getLoggerOutput(String[] args) {
        // Set up a ByteArrayOutputStream to capture log output
        ByteArrayOutputStream logContent = new ByteArrayOutputStream();
        
        // Create a stream handler that writes logs to the ByteArrayOutputStream
        StreamHandler streamHandler = new StreamHandler(logContent, new SimpleFormatter());
        
        // Get the logger for the Dex2Hex class
        Logger logger = Logger.getLogger(Dex2Hex.class.getName());
        
        // Remove any default handlers, then add custom handler
        logger.setUseParentHandlers(false);
        logger.addHandler(streamHandler);

        // Set the log level for the logger (capture all levels of logs)
        logger.setLevel(Level.ALL);

        try {
            // Call the main method with the provided arguments
            Dex2Hex.main(args);
        } finally {
            // Remove the handler to prevent duplication
            logger.removeHandler(streamHandler);
        }

        // Return the captured log content as a string
        return logContent.toString();
    }

    @Test
    public void testDecimalToHex() {
        // Test with valid input
        String[] args = {"15"};
	// Using logger here as wanted from sonarqube
        String output = getLoggerOutput(args);

        // Check that the log output contains the expected messages
        assertTrue(output.contains("Converting the Decimal Value 15 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: F"));
    }

    @Test
    public void testDecimalToHexInvalidInteger() {
        // Test with invalid input
        String[] args = {"r"};
	//Using logger here as wanted from sonarqube
        String output = getLoggerOutput(args);

        // Check for the expected error message for invalid input
        assertTrue(output.contains("Input Error: Invalid input. Please enter a valid integer."));
    }

    @Test
    public void testDecimalToHexNoInteger() {
        // Test with no input
        String[] args = {};
	//Using logger here as wanted from sonarqube
        String output = getLoggerOutput(args);

        // Check for the expected error message when no input is provided
        assertTrue(output.contains("Input Error: Please provide a number input."));
    }
}

