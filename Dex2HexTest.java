// Import all necessary libraries
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.*;

public class Dex2HexTest {

    // ByteArrayOutputStream to get the output of the logger
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    // Logger instance to get log message outputs
    private final Logger logger = Logger.getLogger(Dex2Hex.class.getName());
    // Custom handler to redirect log output to the ByteArrayOutputStream 
    private Handler customHandler;  

    // Before setup method to initialize the custom handler and attach it to the logger
    @Before
    public void setUp() {
        // Create a custom Handler object to capture log messages
        customHandler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                try {
		    // Capture log message
                    outputStreamCaptor.write(record.getMessage().getBytes()); 
                } catch (IOException e) {
		    // Handle IOException
                    e.printStackTrace(); 
                }
            }

	    // If needed extend this class to handle more complex resources, override these methods to close or flush
            @Override
            public void flush() {
                // No flushing needed for this example
            }

            @Override
            public void close() throws SecurityException {
                // No cleanup required for this handler
            }
        };
	
	// Capture all log levels
        customHandler.setLevel(Level.ALL);
	// Add the custom handler to the logger 
        logger.addHandler(customHandler); 
    }

    // Method to remove the custom handler after each test
    @After
    public void tearDown() {
	// Remove the custom handler
        logger.removeHandler(customHandler); 
    }

    @Test
    public void testDecimalToHex() {
        // Sample input to the main method of Dex2Hex
        String[] args = {"15"};
        
        // Call the main method of Dex2Hex (assuming it generates logs)
        Dex2Hex.main(args);

        // Save the output from the logger and check if it contains the expected log messages
        String logOutput = outputStreamCaptor.toString();

        // Check that the log contains the expected messages
        assertTrue(logOutput.contains("Converting the Decimal Value 15 to Hex..."));
        assertTrue(logOutput.contains("Hexadecimal representation is: F"));
    }

    @Test
    public void testDecimalToHexInvalidInteger() {
        // Test with invalid input
        String[] args = {"r"};

	 // Call the main method of Dex2Hex (assuming it generates logs)
        Dex2Hex.main(args);

        // Save the output from the logger and check if it contains the expected log messages
        String logOutput = outputStreamCaptor.toString();

        // Check for the expected error message for invalid input
        assertTrue(logOutput.contains("Input Error: Invalid input. Please enter a valid integer."));
    }

    @Test
    public void testDecimalToHexNoInteger() {
        // Test with no input
        String[] args = {};

	 // Call the main method of Dex2Hex (assuming it generates logs)
        Dex2Hex.main(args);

        // Save the output from the logger and check if it contains the expected log messages
        String logOutput = outputStreamCaptor.toString();

        // Check for the expected error message when no input is provided
        assertTrue(logOutput.contains("Input Error: Please provide a number input."));
    }
}

