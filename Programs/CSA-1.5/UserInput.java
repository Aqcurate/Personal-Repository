package us.to.sstctf;

import java.util.Scanner;

/**
 * Convenience class for getting input from a user
 */

public class UserInput {
	public static String getString() {
        
		Scanner in = new Scanner(System.in);
		
		// Converting everything to lowercase and removing special characters
		String input = in.next().toLowerCase().replaceAll("[^a-z]","");
		
		
		// Make sure the input length is greater than 3 characters
		if (input.length() < 3) {
			System.out.println("An input needs to be at least 3 characters.");
			System.exit(-1);
		}
			
		return input;
    }
}