package org.sstctf;

public class CardTester {
	
	public static void main(String[] args) {
		Card c1 = new Card("ace", "hearts", 1);
		Card c2 = new Card("ace", "hearts", 1);
		Card c3 = new Card("ace", "hearts", 2);
		Card c4 = new Card("ace", "spades", 1);
		Card c5 = new Card("king", "hearts", 1);
		Card c6 = new Card("queen", "clubs", 3);
		
		assert c1.getRank().equals("ace") : "Wrong rank: " + c1.getRank();
		assert c1.getSuit().equals("hearts") : "Wrong suit: " + c1.getSuit();
		assert c1.getPoint() == 1 : "Wrong point value: " + c1.getPoint();
		assert c6.getRank().equals("queen") : "Wrong rank: " + c6.getRank();
		assert c6.getSuit().equals("clubs") : "Wrong suit: " + c6.getSuit();
		assert c6.getPoint() == 3: "Wrong point value : " + c6.getPoint();
		
		assert c1.equals(c1) : "Card doesn't match itself: " + c1;
		assert c1.equals(c2) : "Duplicate cards aren't equal: " + c1;
		assert !c1.equals(c3) : "Different cards are equal: " + c1 + ", " + c3;
		assert !c1.equals(c4) : "Different cards are equal: " + c1 + ", " + c4;
		assert !c1.equals(c5) : "Different cards are equal: " + c1 + ", " + c5;
		assert !c1.equals(c6) : "Different cards are equal: " + c1 + ", " + c6;
		
		assert c1.toString().equals("ace of hearts (Point Value = 1)") : "Wrong toString: " + c1;
		assert c6.toString().equals("queen of clubs (Point Value = 3)") : "Wrong toString: " + c6;
		
		System.out.println("All tests passed!");
	}
}
