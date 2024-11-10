import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dex2HexTest {

    // Utility method to capture log output
    public String getLoggerOutput(String[] args) {
        // Set up a ByteArrayOutputStream to capture log output
        ByteArrayOutputStream logContent = new ByteArrayOutputStream();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setOutputStream(logContent);

        // Get the logger for the Dex2Hex class
        Logger logger = Logger.getLogger(Dex2Hex.class.getName());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);  // Capture all levels of log messages

        try {
            // Call the main method with the provided arguments
            Dex2Hex.main(args);
        } finally {
            // Remove the handler to prevent duplication
            logger.removeHandler(consoleHandler);
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

