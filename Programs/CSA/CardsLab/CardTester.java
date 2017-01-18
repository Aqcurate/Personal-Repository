package org.sstctf;

public class CardTester {
	public static void main(String[] args) {
		
		Card card1 = new Card("Queen", "Hearts", 10);
		Card card2 = new Card("King", "Clubs", 10);
		Card card3 = new Card("Jack", "Spades", 10);
		
		Card[] cards = {card1, card2, card3};
		
		int tmp = 1;
		
		// Print Info
		for (Card card : cards) {
			System.out.println("Card " + tmp + " Info:");
			System.out.println(card.getRank());
			System.out.println(card.getSuit());
			System.out.println(card.getPoint());
			System.out.println();
			tmp++;
		}
		
		// Compare Testing
		
		System.out.println("Card 1 equals Card 2? " + card1.equals(card2));
		
		card2.setRank("Queen");
		card2.setSuit("Hearts");
		
		System.out.println("Card 1 equals new Card 2? " + card1.equals(card2));
		System.out.println();

		// Compare Reference
		System.out.println("Object: " + card1);
		System.out.println("Object.toString(): " + card1.toString());
	}
}
