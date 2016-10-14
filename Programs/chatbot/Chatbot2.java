package org.sst.chatbot;

import java.util.HashMap;
import java.util.Map;

public class Chatbot2 extends Magpie {

	Map<String, String> keyTerms = new HashMap<String, String>()
	{{
		put("no", "Why are you so negative?");
		
		put("' OR '1' = '1", "Nice try kid. We don't use SQL here.");
		put("OR 1 = 1", "Nice try kid. We don't use SQL here.");
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
		return "Chatbot2";
	}
	
	public String getResponse(String statement) {
		for(String key: keyTerms.keySet()) {
			if (statement.contains(key)) {
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

}
