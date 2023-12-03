import com.example.sevencardstud.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GamePlayTest {
    @Test
    public void testCreatingGamePlay() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertEquals(3, gp.botHand.size());
    }

    @Test
    public void testValueOneTrue() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueOne(newHand));
    }

    @Test
    public void testValueOneFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueOne(hand.testHand));
    }

    @Test
    public void testValueTwoTrue() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueTwo(hand.testHand));
    }

    @Test
    public void testValueTwoFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueTwo(hand.testHand));
    }

    @Test
    public void testValueThreeTrue() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "4");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueThree(hand.testHand));
    }

    @Test
    public void testValueThreeFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueThree(hand.testHand));
    }

    @Test
    public void testValueFourTrue() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "7");
        Card cardThree = new Card("Diamonds", "4");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueFour(hand.testHand));
    }

    @Test
    public void testValueFourFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueFour(hand.testHand));
    }

    @Test
    public void testValueFiveTrueMissingInMiddle() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "A");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Diamonds", "6");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueFive(hand.testHand));
    }

    @Test
    public void testValueFiveTrueMissingOnEnd() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "10");
        Card cardTwo = new Card("Clubs", "9");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Clubs", "6");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueFive(hand.testHand));
    }

    @Test
    public void testValueFiveFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "9");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "3");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueFive(hand.testHand));
    }

    @Test
    public void testValueSixTrue() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "J");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "2");
        Card cardFive = new Card("Diamonds", "K");
        Card cardSix = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueSix(hand.testHand));
    }

    @Test
    public void testValueSixFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "2");
        Card cardFive = new Card("Diamonds", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueSix(hand.testHand));
    }

    @Test
    public void testValueSevenTrueTwoPairs() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "4");
        Card cardFive = new Card("Spades", "7");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueSeven(hand.testHand));
    }

    @Test
    public void testValueSevenTrueThreeAndOne() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "4");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueSeven(hand.testHand));
    }

    @Test
    public void testValueSevenFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueSeven(hand.testHand));
    }

    @Test
    public void testValueEightTrue() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "4");
        Card cardFour = new Card("Clubs", "4");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueEight(hand.testHand));
    }

    @Test
    public void testValueEightFalse() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "4");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueEight(hand.testHand));
    }

    @Test
    public void testValueNineTrueMissingInMiddle() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Diamonds", "9");
        Card cardSix = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueNine(hand.testHand));
    }

    @Test
    public void testValueNineTrueMissingOnEnd() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Diamonds", "8");
        Card cardSix = new Card("Diamonds", "9");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueNine(hand.testHand));
    }

    @Test
    public void testValueNineFalseOnlyFlush() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "K");
        Card cardFive = new Card("Diamonds", "10");
        Card cardSix = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueNine(hand.testHand));
    }

    @Test
    public void testValueNineFalseOnlyStraight() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "6");
        Card cardFive = new Card("Diamonds", "9");
        Card cardSix = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueNine(hand.testHand));
    }

    @Test
    public void testValueTenTrueMissingInMiddle() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "J");
        Card cardFour = new Card("Diamonds", "A");
        Card cardFive = new Card("Diamonds", "Q");
        Card cardSix = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueTen(hand.testHand));
    }

    @Test
    public void testValueTenTrueMissingOnEnd() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "J");
        Card cardFour = new Card("Diamonds", "A");
        Card cardFive = new Card("Diamonds", "Q");
        Card cardSix = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.valueTen(hand.testHand));
    }

    @Test
    public void testValueTenFalseOnlyStraight() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "J");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "K");
        Card cardSix = new Card("Diamonds", "A");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueTen(hand.testHand));
    }

    @Test
    public void testValueTenFalseOnlyFlush() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "J");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Diamonds", "9");
        Card cardSix = new Card("Diamonds", "A");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.valueTen(hand.testHand));
    }

    @Test
    public void testMissingStraightValueInMiddle() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "J");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "K");
        Card cardSix = new Card("Diamonds", "A");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertEquals(12, gp.straightMissingValue(hand.testHand));
    }

    @Test
    public void testMissingStraightValueOnEnd() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "8");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "7");
        Card cardSix = new Card("Diamonds", "9");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertEquals(0, gp.straightMissingValue(hand.testHand));
    }

    @Test
    public void testMissingStraightValueAceLow() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "4");
        Card cardFour = new Card("Diamonds", "5");
        Card cardFive = new Card("Spades", "A");
        Card cardSix = new Card("Diamonds", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertEquals(2, gp.straightMissingValue(hand.testHand));
    }

    @Test
    public void testMissingFullHouseValueThreeOfLowerCard() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Diamonds", "5");
        Card cardFive = new Card("Spades", "9");
        Card cardSix = new Card("Diamonds", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {9};
        assertArrayEquals(expectedArray, gp.fullHouseMissingValues(hand.testHand));
    }

    @Test
    public void testMissingFullHouseValueThreeOfHigherCard() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "Q");
        Card cardFour = new Card("Diamonds", "4");
        Card cardFive = new Card("Spades", "Q");
        Card cardSix = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {4};
        assertArrayEquals(expectedArray, gp.fullHouseMissingValues(hand.testHand));
    }

    @Test
    public void testMissingFullHouseValueTwoPair() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "Q");
        Card cardFour = new Card("Diamonds", "7");
        Card cardFive = new Card("Spades", "7");
        Card cardSix = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {7, 12};
        assertArrayEquals(expectedArray, gp.fullHouseMissingValues(hand.testHand));
    }

    @Test
    public void testSearchRoyalFlushFound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "Q");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "A");
        Card cardSix = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Diamonds", "J");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Hearts", "7");
        Card cardSixSecond = new Card("Hearts", "K");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.searchRoyalandStraightFlush(cardHands, 11, "Diamonds"));
    }

    @Test
    public void testSearchRoyalFlushNotFound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "Q");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "A");
        Card cardSix = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "J");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Hearts", "7");
        Card cardSixSecond = new Card("Hearts", "K");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.searchRoyalandStraightFlush(cardHands, 11, "Diamonds"));
    }

    @Test
    public void testSearchStraightFlushFoundInMiddle() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Hearts", "7");
        Card cardFive = new Card("Hearts", "9");
        Card cardSix = new Card("Hearts", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Diamonds", "J");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Hearts", "6");
        Card cardSixSecond = new Card("Hearts", "K");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.searchRoyalandStraightFlush(cardHands, 6, "Hearts"));
    }

    @Test
    public void testSearchStraightFlushFoundOnEndAceLow() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Hearts", "3");
        Card cardFive = new Card("Hearts", "4");
        Card cardSix = new Card("Hearts", "2");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Spades", "3");
        Card cardThreeSecond = new Card("Diamonds", "J");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Hearts", "A");
        Card cardSixSecond = new Card("Hearts", "K");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.searchRoyalandStraightFlush(cardHands, 14, "Hearts"));
    }

    @Test
    public void testSearchStraightFlushFoundOnEndHigh() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Hearts", "3");
        Card cardFive = new Card("Hearts", "4");
        Card cardSix = new Card("Hearts", "2");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Spades", "3");
        Card cardThreeSecond = new Card("Diamonds", "J");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Hearts", "6");
        Card cardSixSecond = new Card("Hearts", "K");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.searchRoyalandStraightFlush(cardHands, 6, "Hearts"));
    }

    @Test
    public void testSearchStraightFlushNotFound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Hearts", "3");
        Card cardFive = new Card("Hearts", "4");
        Card cardSix = new Card("Hearts", "2");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Hearts", "6");
        Card cardTwoSecond = new Card("Spades", "3");
        Card cardThreeSecond = new Card("Diamonds", "J");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Hearts", "7");
        Card cardSixSecond = new Card("Hearts", "K");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.searchRoyalandStraightFlush(cardHands, 6, "Hearts"));
    }

    @Test
    public void testSearchStraightFound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Hearts", "4");
        Card cardSix = new Card("Clubs", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Hearts", "6");
        Card cardTwoSecond = new Card("Spades", "3");
        Card cardThreeSecond = new Card("Diamonds", "7");
        Card cardFourSecond = new Card("Clubs", "7");
        Card cardFiveSecond = new Card("Hearts", "7");
        Card cardSixSecond = new Card("Spades", "7");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.straightSearch(cardHands, 7));
    }

    @Test
    public void testSearchStraightFoundAceLow() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Hearts", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Diamonds", "2");
        Card cardFive = new Card("Hearts", "4");
        Card cardSix = new Card("Clubs", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Hearts", "6");
        Card cardTwoSecond = new Card("Spades", "3");
        Card cardThreeSecond = new Card("Diamonds", "A");
        Card cardFourSecond = new Card("Clubs", "A");
        Card cardFiveSecond = new Card("Hearts", "A");
        Card cardSixSecond = new Card("Spades", "A");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertTrue(gp.straightSearch(cardHands, 14));
    }

    @Test
    public void testSearchStraightNotFound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Clubs", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "5");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Hearts", "4");
        Card cardSix = new Card("Clubs", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Hearts", "6");
        Card cardTwoSecond = new Card("Spades", "3");
        Card cardThreeSecond = new Card("Diamonds", "7");
        Card cardFourSecond = new Card("Clubs", "7");
        Card cardFiveSecond = new Card("Hearts", "8");
        Card cardSixSecond = new Card("Spades", "7");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertFalse(gp.straightSearch(cardHands, 7));
    }

    @Test
    public void testFullHouseFoundThreeOfKind() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Hearts", "Q");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "Q");
        Card cardSix = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "10");
        Card cardFourSecond = new Card("Clubs", "2");
        Card cardFiveSecond = new Card("Spades", "10");
        Card cardSixSecond = new Card("Hearts", "10");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {10};
        assertTrue(gp.fullHouseSearch(cardHands, expectedArray));
    }

    @Test
    public void testFullHouseFoundTwoPair() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "Q");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "10");
        Card cardFourSecond = new Card("Clubs", "Q");
        Card cardFiveSecond = new Card("Hearts", "10");
        Card cardSixSecond = new Card("Hearts", "Q");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {10, 12};
        assertTrue(gp.fullHouseSearch(cardHands, expectedArray));
    }

    @Test
    public void testFullHouseSearchFalseThreeOfKind() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "Q");
        Card cardFour = new Card("Hearts", "Q");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "A");
        Card cardFourSecond = new Card("Clubs", "Q");
        Card cardFiveSecond = new Card("Hearts", "7");
        Card cardSixSecond = new Card("Hearts", "Q");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {10};
        assertFalse(gp.fullHouseSearch(cardHands, expectedArray));
    }

    @Test
    public void testFullHouseSearchFalseTwoPair() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "Q");
        Card cardFour = new Card("Hearts", "10");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "10");
        Card cardFourSecond = new Card("Clubs", "Q");
        Card cardFiveSecond = new Card("Diamonds", "7");
        Card cardSixSecond = new Card("Hearts", "Q");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        int[] expectedArray = {10, 12};
        assertFalse(gp.fullHouseSearch(cardHands, expectedArray));
    }

    @Test
    public void testShouldFoldPotentialStraight() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "6");
        Card cardFive = new Card("Diamonds", "9");
        Card cardSix = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertEquals(5, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldNothing() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "6");
        Card cardFive = new Card("Diamonds", "2");
        Card cardSix = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testFoldIsTrueAfterFourthRound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "7");
        Card cardFour = new Card("Hearts", "9");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Diamonds", "6");
        Card cardTwoSecond = new Card("Hearts", "3");
        Card cardThreeSecond = new Card("Clubs", "8");
        Card cardFourSecond = new Card("Hearts", "8");
        Card cardFiveSecond = new Card("Diamonds", "8");
        Card cardSixSecond = new Card("Spades", "8");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterFourthRound();
        assertTrue(gp.bot.isFolded);
    }


    @Test
    public void testFoldIsFalseAfterFourthRound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "7");
        Card cardFour = new Card("Hearts", "9");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Hearts", "6");
        Card cardTwoSecond = new Card("Clubs", "3");
        Card cardThreeSecond = new Card("Spades", "8");
        Card cardFourSecond = new Card("Clubs", "8");
        Card cardFiveSecond = new Card("Diamonds", "10");
        Card cardSixSecond = new Card("Hearts", "8");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterFourthRound();
        assertFalse(gp.bot.isFolded);
    }

    @Test
    public void testFoldIsFalseAfterFourthRoundTwo() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "7");
        Card cardFour = new Card("Hearts", "9");
        Card cardFive = new Card("Spades", "10");
        Card cardSix = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        Card cardOneSecond = new Card("Hearts", "6");
        Card cardTwoSecond = new Card("Clubs", "3");
        Card cardThreeSecond = new Card("Spades", "8");
        Card cardFourSecond = new Card("Clubs", "K");
        Card cardFiveSecond = new Card("Diamonds", "10");
        Card cardSixSecond = new Card("Hearts", "2");
        hand.addCard(hand.testHand2, cardOneSecond);
        hand.addCard(hand.testHand2, cardTwoSecond);
        hand.addCard(hand.testHand2, cardThreeSecond);
        hand.addCard(hand.testHand2, cardFourSecond);
        hand.addCard(hand.testHand2, cardFiveSecond);
        hand.addCard(hand.testHand2, cardSixSecond);
        newHand.addAll(hand.testHand);
        secondHand.addAll(hand.testHand2);
        cardHands.add(newHand);
        cardHands.add(secondHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterFourthRound();
        assertFalse(gp.bot.isFolded);
    }


    @Test
    public void testFoldIsFalseAfterThirdRound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "8");
        Card cardFour = new Card("Hearts", "2");
        Card cardFive = new Card("Spades", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertFalse(gp.bot.isFolded);
    }

    @Test
    public void testFoldIsFalseAfterThirdRoundTwo() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "8");
        Card cardFour = new Card("Hearts", "2");
        Card cardFive = new Card("Spades", "2");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertFalse(gp.bot.isFolded);
    }

    @Test
    public void testFoldIsTrueAfterThirdRound() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "2");
        Card cardFour = new Card("Hearts", "7");
        Card cardFive = new Card("Spades", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertTrue(gp.bot.isFolded);
    }



}


