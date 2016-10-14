package org.sstctf.chatbot;

/**
 * This class contains the main method
 * Run the program from this class
 * 
 * This class allows the user to talk to a chatbot
 * Or allows the user to see two chatbots talk to each other
 * 
 * If you decide to use a default MagpieRunner java class
 * Make sure you create a Chatbot1() object under the Magpie data type
 * 
 * @author Andrew Quach
 * @date 10/13/2016
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MagpieRunner {
	
	// Method that calls the bot
	// Trims and lowercases the statement
	private static String talkToBot(String statement, Magpie chat) {
		String lowerStatement = statement.toLowerCase().trim();
		return chat.getResponse(lowerStatement);
	}

	public static void main(String[] args) {
		
		// Declaring chatbot objects under type of Magpie
		// Polymorphism 
		Magpie chat1 = new Chatbot1();
		Magpie chat2 = new Chatbot2();
		
		// Declares scanner object
		Scanner input = new Scanner(System.in);
		
		// Declare an arraylist of chatBots for easy access
		ArrayList<Magpie> chatBots = new ArrayList<Magpie>();
		chatBots.add(chat1);
		chatBots.add(chat2);
		
		// Set initial statement by chatbot1
		String statement = chat1.getGreeting();
		
		// Allow the user to choose whether to talk to a chatbot or see chatbots talk to each other
		System.out.println("Type 1 to talk to a chatbot.");
		System.out.println("Type 2 to see two chatbots talk to each other.");
		
		String choice = input.nextLine();

		// Case 1 = human and chatbot
		// Case 2 = chatbot and chatbot
		switch (choice) {
			case "1":
				System.out.println(statement);
				String userStatement = input.nextLine();
				
				while (!statement.equals("Bye")) {
					System.out.println(talkToBot(userStatement, chat1));
					userStatement = input.nextLine();
				}
				break;
			
			case "2":
				while (!statement.equals("Bye")) {
					for(Magpie chat: chatBots) {
						statement = talkToBot(statement, chat);
						System.out.println(chat.getName() + ": " + statement);
						
						// Sleep to prevent program running too much too fast
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}		
				}
				break;
			default:
				System.out.println("Invalid choice.");
				
			input.close();
		}
	}
}
