import java.util.Scanner;

public class Dex2Hex{
    public static int Arg1;
    public static void main(String args[]) {
	// Check if the user provided an input
        if (args.length < 1) {
            System.out.println("Input Error: Please provide a number input.");
            return;
	}	
        int num2;

        // Try to parse the provided argument into an integer
        try {
            num2 = Integer.parseInt(args[0]);
        } 
	catch (NumberFormatException e) {

            // If the argument is not a valid integer, print an error message
            System.out.println("Input Error: Invalid input. Please enter a valid integer.");
            return;
        }

        Arg1 = Integer.parseInt(args[0]);
        char ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem, num;
        num = Arg1;
        String hexadecimal="";
        System.out.println("Converting the Decimal Value " + num + " to Hex...");
	System.out.println("Automatic Build Test for Jenkins");
        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }

        System.out.println("Hexadecimal representation is: " + hexadecimal);

    }

}
