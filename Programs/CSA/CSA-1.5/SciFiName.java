package us.to.sstctf;

public class SciFiName {
    /**
     * All input that you provide should be at least three letters long
     * 
     * For best results, use only letters
     */
	
    public static void main(String[] args) {
    	
    	// Intro information
    	
        System.out.println("If you provide me some information I will provide a science fiction name for you.");
        System.out.println("Please all responses must be at least three characters long.");
        System.out.println("Only alphabet characters will be processed.\n");

        // Getting user input
        
        System.out.print("Enter your first name: ");
        String firstName = UserInput.getString();
        System.out.print("Enter your last name: ");
        String lastName = UserInput.getString();
        System.out.print("Enter the city where you or one of your parents were born: ");
        String city = UserInput.getString();
        System.out.print("Enter the name of your grammar school: ");
        String school = UserInput.getString();
        System.out.print("Enter the first name of a sibling or other relative: ");
        String relativeName1 = UserInput.getString();
        System.out.print("Enter the first name of a second sibling or relative: ");
        String relativeName2 = UserInput.getString();

        // Generating sciFi names and origin
   
        String firstSciFiName = firstName.substring(0, 3) + lastName.substring(0, 2);
        String lastSciFiName = city.substring(0, 2) + school.substring(0, 3);
        String originSciFi = randomIndexString(relativeName1) + randomIndexString(relativeName2);
        
        System.out.println("Hello " + capitalizeLetter(firstSciFiName) + " " + capitalizeLetter(lastSciFiName) + " of " + capitalizeLetter(originSciFi) + ". Welcome!");
    }
    
    public static String randomIndexString(String s) {
    	return s.substring((int) (Math.random() * (s.length()-1)) + 1);
    }
    
    public static String capitalizeLetter(String s) {
    	s = s.substring(0,1).toUpperCase() + s.substring(1);
    	return s;
    }
}

