import java.util.logging.Logger;

public class Dex2Hex {
public static int Arg1;
private static final Logger logger = Logger.getLogger(Dex2Hex.class.getName());

    public static void main(String[] args) {
        // Check if the user provided an input
        if (args.length < 1) {
            logger.severe("Input Error: Please provide a number input.");
            return;
        }

        // Try to parse the provided argument into an integer
        try {
            Arg1 = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {

            // If the argument is not a valid integer, print an error message
            logger.severe("Input Error: Invalid input. Please enter a valid integer.");
            return;
        }

        Arg1 = Integer.parseInt(args[0]);
        char[] ch={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem;
	int num;
        num = Arg1;
        String hexadecimal="";
        logger.info(String.format("Converting the Decimal Value %d to Hex...", num));


        while(num != 0)
        {
            rem=num%16;
            hexadecimal.insert(0, ch[rem]);
            num= num/16;
        }

        logger.info(String.format("Hexadecimal representation is: %s", hexadecimal));

    }

}
