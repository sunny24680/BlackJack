package Code;
import java.util.ArrayList;

/*
 * Stores all the information regarding the hand and wins
 * Implemented in BlackJack.java
 */
public class Player {
	private ArrayList<Cards> hand = new ArrayList<Cards>();
	private int wins = 0;
	
	public void addCard(Cards newCard) {
		hand.add(newCard);
	}
	
	public void clearHand() {
		hand.clear();
	}
	
	
	//method that gets the highest score of the person without going over 21 if possible
	
	public int score() {
		int total = 0;
		int numAces = 0;
		//adds all the numbers but the aces 
		for (Cards inHand: hand) {
			if (inHand.getValue() > 10)
				total += 10;
			else if (inHand.getValue() == 1) {
				numAces++;
			} else 
				total += inHand.getValue();
		}
		/*
		 * adds the aces to the total score after
		 * this way the aces will maximize the score  
		 * but wont go over the limit
		 */
		System.out.println("aces "+numAces+" "+total);
		for (int x = 0; x < numAces; x++) {
			if (total + 11 + (numAces+x-1) < 22) {
				System.out.println("add 11");
				total += 11;
			} else {
				System.out.println("TOTAL = "+total);
				total += 1;
			}
		}
		return total;
	}
	
	
	//checks if player has gone above 21
	
	public boolean bust() {
		if (score() > 21)
			return true;
		else 
			return false;
	}
	
	//increments win counter
	
	public void won() {
		wins++;
	}
	
	public int getWins() {
		return wins;
	}
	
	/*
	 * to string of the player returns the cards in the player object
	 * and the tostring of them
	 */
	public String toString() {
		String result = "Cards : ";
		for(int x = 0; x < hand.size(); x++) {
			if (x == hand.size() - 1) {
				result += hand.get(x).toString();				
			} else 
				result += hand.get(x).toString()+ ", ";
		}
		return result;
	}
}
