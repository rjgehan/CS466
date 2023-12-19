import com.example.sevencardstud.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GameTest
{
    @Test
    public void testCreatingGamePotAmount() {
        Game gm = new Game();
        assertEquals(6, gm.currentPot);
    }

    @Test
    public void testBotBrainOutput() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Diamonds", "7");
        //Card cardSix = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        Game gm = new Game();
        gm.hands.round = 3;
        assertEquals(1, gm.botBrain(cardHands, newHand));
    }

    @Test
    public void testBotCall() {
        List<Integer> bets = new ArrayList<>();
        bets.add(0);
        bets.add(4);
        Game gm = new Game();
        gm.hands.round = 1;
        gm.bringInCalled = true;
        gm.botCall(bets, 0);
        assertEquals(7, gm.currentPot);
    }

    @Test
    public void testBotRaise() {
        List<Integer> bets = new ArrayList<>();
        bets.add(0);
        bets.add(4);
        Game gm = new Game();
        gm.hands.round = 1;
        gm.bringInCalled = true;
        gm.botRaise(bets, 0);
        assertEquals(8, gm.currentPot);
    }

    @Test
    public void testPlay() {
        Game gm = new Game();
        gm.hands.turn = 1;
        gm.play();
        assertEquals(2, gm.hands.turn);
    }

    @Test
    public void testGetGameHand() {
        Game gm = new Game();
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Diamonds", "7");
        //Card cardSix = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        gm.hands = hand;
        assertEquals(hand, gm.getGameHand());
    }

    @Test
    public void testGetCurrentPot() {
        Game gm = new Game();
        gm.currentPot = 10;
        assertEquals(10, gm.getCurrentPot());
    }

    @Test
    public void testSetCurrentPot() {
        Game gm = new Game();
        gm.currentPot = 10;
        gm.setCurrentPot(15);
        assertEquals(15, gm.currentPot);
    }

    @Test
    public void testUpdateCurrentPot() {
        Game gm = new Game();
        gm.currentPot = 10;
        gm.updateCurrentPot(12);
        assertEquals(22, gm.currentPot);
    }

    @Test
    public void testPlayerWithSmallestCard() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "10");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        Game gm = new Game();
        assertEquals(1, gm.findPlayerWithSmallestCard(cardHands));
    }
}
