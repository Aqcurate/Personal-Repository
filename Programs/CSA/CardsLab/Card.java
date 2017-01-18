package org.sstctf;

public class Card {
	
	private String rank;
	private String suit;
	private int point;
	
	public Card(String rank, String suit, int point) {
		this.setRank(rank);
		this.setSuit(suit);
		this.setPoint(point);
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Card)) return false;
		
		Card other = (Card) obj;
		
		return (this.rank == other.getRank() &&
				this.suit == other.getSuit() &&
				this.point == other.getPoint());
	}
	
	@Override
	public String toString() {
		return this.rank + " of " + this.suit + " (Point Value = " + this.point + ")"; 
	}
}
