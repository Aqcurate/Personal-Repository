package org.sst.chatbot;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Chatbot1 extends Magpie {

	private String lastStatement = "";
	private String name = "";
	
	Map<String, String> keyTerms = new HashMap<String, String>()
	{{
		put("no", "Why are you so negative?");
		
		put("name", "Well, my name is NotaBotBot.");
		
		put("hello", "Hello! What is your name?");
		put("hi", "Hello! What is your name?");
		
		put("' or '1' = '1", "Nice try kid. We don't use SQL here.");
		put("or 1 = 1", "Nice try kid. We don't use SQL here.");
		put("1 = 1", "That's true I guess...");

		
		put("alert(", "We don't use javascript man. This is a java program.");
		put("; ls", "Nope, not a bash script. Good try though.");
	}};
	
	String[] randomList = {
		"Interesting, tell me more.",
		"Hmm.",
		"Do you really think so?",
		"You don't say...",
		"Same.",
		"True."
	};
	
	final int NUMBER_OF_RESPONSES = randomList.length;
	
	public String getName() {
		return "Chatbot1";
	}
	
	public String getResponse(String statement) {
		
		if (specialReponses(statement) != null) {
			this.lastStatement = specialReponses(statement);
			return specialReponses(statement);
		}
		
		for(String key: keyTerms.keySet()) {
			if (statement.matches(".*\\b" + Pattern.quote(key) + "\\b.*")) {
				this.lastStatement = keyTerms.get(key);
				return keyTerms.get(key);
			}
		}
		return getRandomResponse();
	}

	public String getRandomResponse() {
		double r = Math.random();
		int randomIndex = (int)(r * NUMBER_OF_RESPONSES);
		
		return randomList[randomIndex];
	}
	
	public String specialReponses(String statement) {
		if (lastStatement.equals("Hello! What is your name?")) {
			String name = statement.replaceAll("my|name|is", "").trim();
			this.name = name;
			return "Alright, hello " + name + ". How old are you?";
			
		}
		return null;
	}
	
}
