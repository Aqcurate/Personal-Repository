package org.sstctf.chatbot;

/**
 * Abstract class as a blueprint to easily create more chatbots
 * 
 * @author Andrew Quach
 */

public abstract class Magpie {
	
	// Feel free to override
	public String getGreeting() {
		return "Hello!";
	}
	
	public abstract String getName();
	public abstract String getResponse(String statement);
	public abstract String getRandomResponse();
	
}
