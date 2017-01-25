package org.sstctf;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	private int size;
	
	public Deck(String[] ranks, String[] suits, int[] values) {
		if(ranks.length != values.length) throw new IllegalArgumentException("Size of rank and suit arrays should equal");
		
		for(int i = 0; i < ranks.length; i++) {
			for(int j = 0; j < suits.length; j++) {
				cards.add(new Card(ranks[i], suits[j], values[i]));
			}
		}
		
		size = cards.size();
		shuffle();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return size;
	}
	
	public Card deal() {
		if (size == 0) return null;
		size--;
		return cards.get(size);
	}
	
	public void shuffle() {
		/*
		System.out.println("Before shuffling: ");
		System.out.println(this);
		for(int i = 0; i < 7; i++) {
			System.out.println("Amount of times shuffled: " + (i+1));
			cards = Shuffler.realisticShuffle(cards);
			System.out.println(this);
		}
		*/
		cards = Shuffler.selectionShuffle(cards);
		size = cards.size();
	}
	
	@Override
	public String toString() {
		String message = "Undealt cards: \n";
		
		for (int i = size - 1; i >= 0; i--) {
			message += cards.get(i);
			if (i != 0) {
				message += ", ";
			}
			if ((size-i) % 2 == 0) {
				message += "\n";
			}
		}
		
		message += "\nDealt cards: \n";
		for (int i = cards.size() - 1; i >= size; i--) {
			message += cards.get(i);
			if (i != size) {
				message += ", ";
			}
			if ((i - cards.size()) % 2 == 0) {
				message += "\n";
			}
		}
		
		message += "\n";
		return message;
	}
	
}
