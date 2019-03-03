package Code;
import java.util.ArrayList;

/*
 * Deck Class which is used in main BlackJack program
 * Uses Cards.java and is implemented in BlackJack.java
 */
public class Deck {
	ArrayList<Cards> deck = new ArrayList<Cards>();
	
	 //Creates new deck of cards while getting rid of the old cards  
	
	public void createDeck() {
		deck.clear();
		//creates deck with each suit and value
		for(int x = 0; x < 4; x++) {
			String suit = "";
			switch (x) {
			case 0 : suit = "Hearts";
				break;
			case 1 : suit = "Diamonds";
				break;
			case 2 : suit = "Spades";
				break;
			case 3 : suit = "Clubs";
				break;
			}
			for (int y = 1; y < 14; y++) {
				Cards newCard = new Cards(suit, y);
				deck.add(newCard);
			}
		}
	}
	
	
	// created my own shuffle method instead of using Collections.shuffle();
	 
	public void shuffleDeck() {
		//makes sure that every card in the deck is swapped into another position
		for(int x = 0; x < deck.size(); x++) {
			//System.out.println("New Shuffle");
			int r = (int) (Math.random() * deck.size());
			//System.out.println("random num = "+r);
			Cards temp = deck.get(x);
			deck.set(x, deck.get(r));
			deck.set(r, temp);
			//printDeck();
		}
	}
	
	/*
	 * returns a card from the deck and check 
	 */
	public Cards getCard() {
		if (!isEmpty()) {
			return deck.remove(0);
		} else 
			BlackJack.endGame();
		return null;
	}
	
	// checks if the deck is empty (since we create a new deck each game should never be empty)
	public boolean isEmpty() {
		if (deck.size() == 0)
			return true;
		else 
			return false;
	}
	
	// DEBUGGING purposes
	/*
	 * public void printDeck() {
	 *	for(int x = 0; x < deck.size(); x++) {
	 *		Cards t = deck.get(x);
	 *		System.out.print("Card = "+t.toString());
     *		System.out.println();
	 *	}
	 *}
	 */
}
