ppackage org.sstctf.chatbot;

/**
 *  Proof of concept of adding allowing two chatbots to talk to each other
 *  All you need is to implement
 *  	getName()
 *  	getResponse(String statement)
 *  	getRandomResponse()
 *  in an manner and extend the Magpie class
 *  
 *  The code in this class is similar to that of Chatbot1
 *  
 *  @author Andrew Quach
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Chatbot2 extends Magpie {

	private String lastStatement = "";
	private String name = "";
	private String age = "";
	private String motherName = "";
	
	Map<String, String> keyTerms = new HashMap<String, String>()
	{{
		put("no", "Life is pretty negative.");
		
		put("maiden name", "My mother's maiden name is bottia.");
		put("how old are you", "I'm 32 years old");
		put("name", "Well, my name is AndrewBot3k16.");
		
		put("hello", "Hello! What is your name?");
		put("hi", "Hello! What is your name?");
		put("different topic", "Alright, let's talk about pets instead. How is your dog2?");
		
		put("mother", "Family is pretty important.");
		put("father", "Remember to treat your family with care.");
		put("sister", "Siblings can be pretty annoying.");
		put("brother", "Siblings can be pretty annoying.");
		
		put("cat", "Animals are pretty cool.");
		put("dog", "Pets are pretty cool.");

		put("wilson", "Wilson sounds like the name of a pretty good teacher.");
		
		put("life", "I am a robot. What is this l1fe?");
		put("robot", "B33P B00P");
	}};
	
	List<String> randomList = new ArrayList<String>();
	
	private int NUMBER_OF_RESPONSES;
	
	public Chatbot2() {
		initializeRandomList();
	}
	
	public String getName() {
		return "Chatbot2";
	}
	
	public void initializeRandomList() {
		randomList.add("Interesting, tell me more.");
		randomList.add("Hmm.");
		randomList.add("Do you really think so?");
		randomList.add("You don't say...");
		randomList.add("Same.");
		randomList.add("True.");
		
		this.NUMBER_OF_RESPONSES = randomList.size();
	}
	
	public String getResponse(String statement) {
				
		if (specialResponses(statement) != null) {
			this.lastStatement = specialResponses(statement);
			return this.lastStatement;
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
		
		return randomList.get(randomIndex);
	}
	
	public String specialResponses(String statement) {
		if (lastStatement.equals("Hello! What is your name?")) {
			String name = statement.replaceAll("well[,]|my|name|is|[.!]*", "").trim();
			this.name = name;
			randomList.add("I have no idea what you are talking about " + name + ".");
			this.NUMBER_OF_RESPONSES = randomList.size();
			return "Alright, hello " + name + ". How old are you?";
		}
		
		if (lastStatement.matches(".*How old are you?.*")) {
			String age = statement.replaceAll("\\bi['m]*\\b|\\bam\\b|\\byear[s]\\b|\\bold\\b|[.!]*", "").trim();
			if (age.matches("^[a-zA-Z0-9_]+$")) {
				this.age = age;
				randomList.add("A person of age " + age + " should not be talking about that.");
				this.NUMBER_OF_RESPONSES = randomList.size();
				return "Hmm..., a " + age + " year old. Well unrelated question, what's your mother's maiden name?";
			} else {
				return "I didn't quite get that. Well, I guess we should move on to a different topic. What's on your mind?";
			}
		}
		
		if (lastStatement.matches(".*what's your mother's maiden name.*")) {
			String motherName = statement.replaceAll("\\bmy\\b|\\bmother['s]*\\b|\\bmaiden\\b|\\bname\\b|\\bis\\b|[.!]*", "").trim();
			randomList.add("Would " + motherName + " be proud of you right now if she saw you talking like that?");
			this.NUMBER_OF_RESPONSES = randomList.size();
			this.motherName = motherName;
			return "Alright thanks for answering my question I suppose. Is there anything else on your mind?";
		}
		
		return null;
	}
	
}
