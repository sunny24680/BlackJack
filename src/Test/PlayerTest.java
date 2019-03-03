package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Code.Cards;
import Code.Player;

class PlayerTest {
	
	@Test
	void testBlackJack() {
		Player p1 = new Player();
		Cards a = new Cards("Spade", 1);
		Cards k = new Cards("Spade", 13);
		Cards q = new Cards("Spade", 12);
		Cards j = new Cards("Spade", 11);
		Cards ten = new Cards("Spade", 10);
		//testing for blackjack
		p1.addCard(a);
		p1.addCard(k);
		assertEquals(21, p1.score());
		p1.clearHand();
		p1.addCard(a);
		p1.addCard(q);
		assertEquals(21, p1.score());
		p1.clearHand();
		p1.addCard(a);
		p1.addCard(j);
		assertEquals(21, p1.score());
		p1.clearHand();
		p1.addCard(a);
		p1.addCard(ten);
		assertEquals(21, p1.score());
	}

	@Test 
	void testMultipleAces() {
		Player p1 = new Player();
		Cards a1 = new Cards(" ", 1);
		Cards a2 = new Cards("Spade", 1);
		Cards c2 = new Cards(" ", 2);
		Cards c8 = new Cards(" ", 8);
		Cards c9 = new Cards(" ", 9);
		p1.addCard(a1);
		p1.addCard(a2);
		p1.addCard(c2);		
		assertEquals(14, p1.score());
		p1.addCard(c8);
		//checks for aces that over lap and make total 22
		System.out.println("CHECKING");
		assertEquals(12, p1.score());
		System.out.println("FINISH");
		p1.addCard(a1);
		assertEquals(13, p1.score());
		p1.clearHand();
		p1.addCard(a1);
		p1.addCard(c9);
		p1.addCard(a2);
		assertEquals(21, p1.score());
	}
}
