package Code;

import java.util.Scanner;

/* 
 *  BlackJack main file. Simulates game of basic game of BlackJack.
 *  Uses player, deck and card class from the same package.
 */

public class BlackJack {

	public static Player dealer;
	public static Player player;
	public static Deck deck;
	public static Scanner sc;
	
	public static void main (String args[]) {
		sc = new Scanner(System.in);
		System.out.println("Do you want to play BlackJack by Santosh Yelavarthy (y/n)");
		if (sc.nextLine().toLowerCase().equals("y")) {
			startGame();
		} else {
			System.out.println("Well have a good day then");
		}
	}
	
	
	// starts the game by initializing the players and deck
	 
	public static void startGame() {
		dealer = new Player();
		player = new Player();
		System.out.println("Starting game of Black Jack");
		deck = new Deck();
		System.out.println("Creating deck of cards to play with");
		deck.createDeck();
		System.out.println("Shuffling deck of cards");
		deck.shuffleDeck();
		initRound();
	}
	
	
	 // Start of the new game and checks for automatic blackjack wins
	
	public static void initRound() {
		scoreScreen();
		System.out.println("            New Round");
		dealCards();
		//if either player has blackjack from first 2 cards
		if (player.score() == 21) {
			System.out.println("Congrats you have BlackJack");
			results();
		} else if (dealer.score() == 21) {
			System.out.println("The Dealer has BlackJack");
			results();
		} else //play the game 
			additionalRounds();
	}
	
	
	// Method gives the player option of hitting or staying
	 
	
	public static void additionalRounds() {
		System.out.println("YOUR HAND :");
		System.out.println(player.toString()+" total = "+player.score());
		//if player's score is above 21 then dont give him the option to hit again
		if (player.bust()) {
			System.out.println("You have been busted :(");
			System.out.println();
			dealerTurn();
		} else if (player.score() == 21){ //if player has 21, he shouldn't hit since he has the max points
			dealerTurn();
		} else {
			System.out.println("Would you like to take a (H)IT or (S)TAND");
			String input = sc.nextLine();
			//reading input
			while (!input.toLowerCase().equals("h") && !input.toLowerCase().equals("s")) {
				System.out.println("not viable option");
				System.out.println("try again");
				System.out.println();
				input = sc.nextLine();
			}
			if (input.toLowerCase().equals("h")) {
				player.addCard(deck.getCard());
				additionalRounds();
			}
			else if (input.toLowerCase().equals("s"))
				dealerTurn();
		}
	}
	
	/*
	 * everything is automatic so no need to spread the functionality out
	 * dealer's turn
	 */
	
	public static void dealerTurn() {
		//dealer has to hit if score is below 17
		while(dealer.score() < 17) {
			dealer.addCard(deck.getCard());
		}
		//print out dealers hand for nice UI experience
		System.out.println("DEALERS HAND :");
		System.out.println("Cards : "+dealer.toString());
		results();
	}
	
	
	// calculates who won and prints the winner
	
	public static void results() {
		System.out.println();
		//checks for same score (takes into account a double BlackJack)
		if ((dealer.score() == player.score())){
			System.out.println("The round ended as a draw");
		} else { //checks for all possibilites
			if (dealer.bust() && player.bust()) {
				System.out.println("Both players busted thus");
				System.out.println("The dealer won this round");
				dealer.won();
			} else if (player.bust()) {
				System.out.println("Player busted");
				System.out.println("The dealer won this round");
				dealer.won();
			} else if (dealer.bust()){
				System.out.println("Dealer busted");
				System.out.println("The Player won this round");
				player.won();
			} else {
				if (player.score() > dealer.score()) {
					System.out.println("You have won this round");
					player.won();
				} else {
					System.out.println("The dealer won this round");
					dealer.won();
				}
			}
		}
		System.out.println();
		System.out.println("YOUR HAND : "+player.toString());
		System.out.println("DEALERS HAND : "+dealer.toString());
		System.out.println();
		System.out.println("Dealers score : "+dealer.score());
		System.out.println("Your score : "+player.score());
		player.clearHand();
		dealer.clearHand();
		playAgain();
	}
	
	
	// Reads input from user to check if they want to play another game
	 
	public static void playAgain() {
		System.out.println("Would you like to play another game of BlackJack? (y/n)");
		String input = sc.nextLine();
		while (!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n")) {
			System.out.println("not viable option");
			System.out.println("try again");
			input = sc.nextLine();
		}
		if (input.toLowerCase().equals("y")) {
			newDeck();
			System.out.println("Shuffling the remaining cards in the deck");
			deck.shuffleDeck();
			initRound();
		}
		else if (input.toLowerCase().equals("n"))
			endGame();
	}
	
	//end game screen
	
	public static void endGame() {
		System.out.println("Thank you for playing BlackJack created by Santosh Yelavarthy");
		System.out.println("The ending score is : ");
		scoreScreen();
	}
	
	/* 
	 * a sequence of print statements so that the UI would look a litte but more 
	 * presentable
	 */
	
	public static void scoreScreen() {
		System.out.println();
		System.out.println("*****************************");
		System.out.println("*            SCORE          *");
		System.out.println("*       Player   : "+player.getWins()+"        *");
		System.out.println("*       Dealer   : "+dealer.getWins()+"        *");
		System.out.println("*****************************");
		
	}
		
	
	//  Deals the cards out to the players
	 
	public static void dealCards() {
		player.addCard(deck.getCard());
		player.addCard(deck.getCard());
		dealer.addCard(deck.getCard());
		dealer.addCard(deck.getCard());
	}
	
	
	// creates a new deck and informs the user
	 
	public static void newDeck() {
		System.out.println();
		System.out.println("We will now use a new deck to continue playing");
		System.out.println();
		deck.createDeck();
	}
}
