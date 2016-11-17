package us.to.sstctf;

/**
 * 
 * Answer to Scrambled String FRQ for Computer Science A
 * 
 * @author Andrew Quach
 * @date 11-4-16
 *
 */

public class ScrambledStrings {
	
	/**
	 * Scrambles a string by swapping any index containing 'A' with the next index value
	 * If there are two 'A's in a row, the second 'A' gets swapped with the next index value after
	 * 
	 * @param word
	 * @return Scrambled string
	 * 
	 */
	
	public static String scrambleWord(String word) {
		
		// Create a result char array with the length of word
		char[] result = new char[word.length()];
		
		// Loop through word
		for(int i = 0; i < word.length(); i++) {
			
			// Check if the index at word contains 'A'
			// Check if the index after the 'A' exists
			if(word.charAt(i) == 'A' && i+1 < word.length()) {
				
				// Swap the values of the index at A and the index after A
				// Store result in the result array
				result[i+1] = 'A';
				result[i] = word.charAt(i+1); 
				
				// Check if the value of the index after A is A
				// If it is not, we can skip that index on the next loop
				if(word.charAt(i+1) != 'A') i++;
			
			} else {
				// If there is no A, just add the value at the current index to the result array
				result[i] = word.charAt(i);
			}
						
		}
		
		// Change char array back into a String
		return String.valueOf(result);
	}
	
	// Test Cases
	public static void main(String[] args) {
		System.out.println(scrambleWord("TAN"));
		System.out.println(scrambleWord("ABRACADABRA"));
		System.out.println(scrambleWord("WHOA"));
		System.out.println(scrambleWord("AARDVARK"));
		System.out.println(scrambleWord("EGGS"));
		System.out.println(scrambleWord("A"));
		System.out.println(scrambleWord(""));
	}
	
}

