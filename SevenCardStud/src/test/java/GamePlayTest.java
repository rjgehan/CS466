import com.example.sevencardstud.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GamePlayTest {
    @Test
    public void testCreatingGamePlay()
    {
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
        assertEquals(3, gp.bot.getHand().size());
    }

    @Test
    public void testValueOneTrue()
    {
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
    public void testMissingStraightValue() {
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

}