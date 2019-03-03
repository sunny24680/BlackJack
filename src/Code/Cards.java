package Code;
/*
 *  Card class that holds both suit and value of any specific card
 *  Used in Deck.java
 */
public class Cards {
	private String suit;
	private int value;
	
	public Cards(String suit, int num) {
		this.suit = suit;
		value = num;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		if (value == 1) {
			return "Ace of "+suit;
		} else if (value == 11) {
			return "Jack of "+suit;
		} else if (value == 12) {
			return "Queen of "+suit;
		} else if (value == 13) {
			return "King of "+suit;
		} else 
			return value+" of "+suit;
	}
}
