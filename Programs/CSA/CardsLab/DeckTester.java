package org.sstctf;

public class DeckTester {
	
	public static void main(String[] args) {
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
		int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
		
		Deck deck1 = new Deck(ranks, suits, values);
		
		// Full deck
		System.out.println("Size: " + deck1.size() + "\n");
		System.out.println(deck1);
		System.out.println("Is the deck empty? " + deck1.isEmpty());
		
		deck1.deal();
		
		System.out.println("------");
		
		// One card dealt
		System.out.println("Size: " + deck1.size() + "\n");
		System.out.println(deck1);
		System.out.println("Is the deck empty? " + deck1.isEmpty());
		
		System.out.println("------");
		
		// All cards dealt
		
		for (int i = 0; i < 51; i++) {
			deck1.deal();
		}
		System.out.println("Size: " + deck1.size() + "\n");
		System.out.println(deck1);
		System.out.println("Is the deck empty? " + deck1.isEmpty());
		
	}
}
