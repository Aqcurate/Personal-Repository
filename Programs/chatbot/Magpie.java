package org.sst.chatbot;

public abstract class Magpie {
	
	// Feel free to override
	public String getGreeting() {
		return "Let's talk.";
	}
	
	public abstract String getName();
	public abstract String getResponse(String statement);
	public abstract String getRandomResponse();
	
}
