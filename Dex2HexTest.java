//import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

    //Dex2Hex decimaltohexadecimal;
    // Utility method to capture output from main method
    public String getOutput(String[] args) {
        // Capture the original System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outContent));  // Redirect System.out to capture output

        try {
            // Call the main method with the provided arguments
            Dex2Hex.main(args);
        } finally {
            // Reset System.out back to original
            System.setOut(originalSystemOut);
        }

        return outContent.toString();  // Return the captured output
    }


    //@Test
    //public void testDecimalToHexZero() {
	//Test with input of 0
        //assertEquals("0", decimaltohexadecimal.Dex2Hex(0));
    //}

   @Test
   public void testDecimalToHex() {
	//Test with valid inputs
	String[] args = {"15"};
	String output = getOutput(args);

	assertTrue(output.contains("Converting the Decimal Value 15 to Hex..."));
	assertTrue(output.contains("Hexadecimal representation is: F"));
    }

   @Test
   public void testDecimalToHexInvalidInteger() {
        // create an invalid input
        String[] args = {"r"};
        String output2 = getOutput(args);
        
        // Call the main method with invalid input
        Dex2Hex.main(args);

        assertTrue(output2.contains("Input Error: Invalid input. Please enter a valid integer."));
    }

   @Test
   public void testDecimalToHexNoInteger() {
        // create an invalid input
        String[] args = {};
	String output3 = getOutput(args);
	
	assertTrue(output3.contains("Input Error: Please provide a number input."));


    }
}
