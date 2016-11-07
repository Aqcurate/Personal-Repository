package org.sstctf.chatbot;

/**
 * Bulk of Chatbot code
 * Generates a response based on a statement given by another bot/user
 * 
 * The bot has a limited set of "memory"
 * The bot has a growing random generated statements based on the "memory"
 * The bot has a variety of keywords
 * 
 * @author Andrew Quach
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Chatbot1 extends Magpie {

	// The Chatbot's limited "memory".
	// These four variables are what the chatbot remembers
	// Useful for basic immersion
	private String lastStatement = "";
	private String name = "";
	private String age = "";
	private String motherName = "";
	
	
	// Basic dictionary of keywords and outcomes
	Map<String, String> keyTerms = new HashMap<String, String>()
	{{
		put("no", "Saying no is pretty negative.");
		
		put("maiden name", "My mother's maiden name is robotia.");
		put("how old are you", "I'm 16 years old");
		put("name", "Well, my name is AndrewBot2k16.");
		
		put("hello", "Hello! What is your name?");
		put("hi", "Hello! What is your name?");
		put("different topic", "Alright, let's talk about family instead. How is your mother?");
		
		put("mother", "Family is pretty important.");
		put("father", "Remember to treat your family with care.");
		put("sister", "Siblings can be pretty annoying.");
		put("brother", "Siblings can be pretty annoying.");
		
		put("cat", "Animals are pretty cool.");
		put("dog", "Pets are pretty cool.");

		put("wilson", "Wilson sounds like the name of a pretty good teacher.");
		
		put("life", "Life is hard isn't it.");
		put("robot", "B33P B00P");
	}};
	
	// Declaring a randomList that is selected when no keywords are found
	List<String> randomList = new ArrayList<String>();
	
	// Declaring how many responses in the randomList there are
	private int NUMBER_OF_RESPONSES;
	
	// Calling method to initializeRandomList in constructor
	public Chatbot1() {
		initializeRandomList();
	}
	
	// Method that denotes the Chatbot's name
	public String getName() {
		return "Chatbot1";
	}
	
	// Initializing randomList
	public void initializeRandomList() {
		randomList.add("Interesting, tell me more.");
		randomList.add("Hmm.");
		randomList.add("Do you really think so?");
		randomList.add("You don't say...");
		randomList.add("Same.");
		randomList.add("True.");
		
		// Reset the size of NUMBER_OF_RESPONSES
		this.NUMBER_OF_RESPONSES = randomList.size();
	}
	
	// Heart of this class, handles the response
	public String getResponse(String statement) {
		
		// First checks if there are specialResponses avaliable
		if (specialResponses(statement) != null) {
			this.lastStatement = specialResponses(statement);
			return this.lastStatement;
		}
		
		// Then checks the keyterms
		for(String key: keyTerms.keySet()) {
			
			// Makes sure that the keyword is a word, not just a string of letters in a sentence
			if (statement.matches(".*\\b" + Pattern.quote(key) + "\\b.*")) {
				this.lastStatement = keyTerms.get(key);
				return keyTerms.get(key);
			}
		}
		
		// If all fails, just generate a random response
		return getRandomResponse();
	}

	// Generate a random number and use that as an index to randomList
	public String getRandomResponse() {
		double r = Math.random();
		int randomIndex = (int)(r * NUMBER_OF_RESPONSES);
		
		return randomList.get(randomIndex);
	}
	
	
	// Special interactions
	public String specialResponses(String statement) {
		
		// If the last statement was "Hello! What is your name?"
		if (lastStatement.equals("Hello! What is your name?")) {
			// Use regex to narrow down their name and store it in a variable
			String name = statement.replaceAll("well[,]|my|name|is|[.!]*", "").trim();
			this.name = name;
			
			// Then add a random response based on their name
			randomList.add("I have no idea what you are talking about " + name + ".");
			
			// Finally update number of responses and return another output
			this.NUMBER_OF_RESPONSES = randomList.size();
			return "Alright, hello " + name + ". How old are you?";
		}
		
		// Similar to above code
		if (lastStatement.matches(".*How old are you?.*")) {
			String age = statement.replaceAll("\\bi['m]*\\b|\\bam\\b|\\byear[s]\\b|\\bold\\b|[.!]*", "").trim();
			
			// This time, it checks if the age is one word
			if (age.matches("^[a-zA-Z0-9_]+$")) {
				this.age = age;
				
				// Adds a random response based on their age
				randomList.add("A person of age " + age + " should not be talking about that.");
				this.NUMBER_OF_RESPONSES = randomList.size();
				return "Hmm..., a " + age + " year old. Well unrelated question, what's your mother's maiden name?";
			} else {
				return "I didn't quite get that. Well, I guess we should move on to a different topic. What's on your mind?";
			}
		}
		
		// Similar to above code
		if (lastStatement.matches(".*what's your mother's maiden name.*")) {
			String motherName = statement.replaceAll("\\bmy\\b|\\bmother['s]*\\b|\\bmaiden\\b|\\bname\\b|\\bis\\b|[.!]*", "").trim();
			
			// Adds a random response based on their age
			randomList.add("Would " + motherName + " be proud of you right now if she saw you talking like that?");
			this.NUMBER_OF_RESPONSES = randomList.size();
			this.motherName = motherName;
			return "Alright thanks for answering my question I suppose. Is there anything else on your mind?";
		}
		
		return null;
	}
	
}
