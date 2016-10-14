package org.sst.chatbot;

import java.util.ArrayList;
import java.util.Scanner;

public class MagpieRunner {
	
	private static String talkToBot(String statement, Magpie chat) {
		String lowerStatement = statement.toLowerCase();
		return chat.getResponse(lowerStatement);
	}

	public static void main(String[] args) {
		
		Magpie chat1 = new Chatbot1();
		Magpie chat2 = new Chatbot2();
		Scanner input = new Scanner(System.in);
		
		ArrayList<Magpie> chatBots = new ArrayList<Magpie>();
		chatBots.add(chat1);
		chatBots.add(chat2);
		
		String statement = chat1.getGreeting();
		
		System.out.println("Type 1 to talk to a chatbot.");
		System.out.println("Type 2 to see two chatbots talk to each other.");
		
		int choice = input.nextInt();

		switch (choice) {
			case 1:
				String userStatement;
				System.out.println(statement);
				input.next();
				while (!statement.equals("Bye")) {
					userStatement = input.nextLine();
					statement = talkToBot(userStatement, chat1);
					System.out.println(statement);

					
				}
				break;
			
			case 2:
				while (!statement.equals("Bye")) {
					for(Magpie chat: chatBots) {
						statement = talkToBot(statement, chat);
						System.out.println(chat.getName() + ": " + statement);
						
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
		}
	}
}
