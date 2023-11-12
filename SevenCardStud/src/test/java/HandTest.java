import com.example.sevencardstud.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


public class HandTest
{
    @Test
    public void testCreatingHandSize()
    {
        Hand hand = new Hand();
        assertEquals(2, hand.getSize(hand.hand1));
    }

    @Test
    public void testNewRoundHandSize()
    {
        Hand hand = new Hand();
        hand.newRound();
        assertEquals(3, hand.getSize(hand.hand1));
    }

    @Test
    public void testCorrectSize()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "A");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertEquals(7, hand.getSize(hand.testHand));
    }

    @Test
    public void testCorrectSort()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand.sort(hand.testHand);
        int [] sortedTestArray = {2, 3, 5, 6, 7, 11, 13};
        assertArrayEquals(sortedTestArray, hand.sort(hand.testHand));
    }

    @Test
    public void testHighCard()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertEquals(13, hand.highCard(hand.testHand));
    }

    @Test
    public void testHighCardWithHighAce()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertEquals(14, hand.highCard(hand.testHand));
    }

    @Test
    public void testHighCardWithLowAce()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "5");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Diamonds", "2");
        Card cardSix = new Card("Hearts", "3");
        Card cardSeven = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertEquals(5, hand.highCard(hand.testHand));
    }

    @Test
    public void testOnePairTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.onePair(hand.testHand));
    }

    @Test
    public void testOnePairFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "8");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.onePair(hand.testHand));
    }

    @Test
    public void testTwoPairTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.twoPair(hand.testHand));
    }

    @Test
    public void testTwoPairFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.twoPair(hand.testHand));
    }

    @Test
    public void testThreeOfaKindTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Diamonds", "7");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.threeOfaKind(hand.testHand));
    }

    @Test
    public void testThreeOfaKindFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Diamonds", "A");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.threeOfaKind(hand.testHand));
    }

    @Test
    public void testStraightTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Diamonds", "A");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straight(hand.testHand));
    }

    @Test
    public void testStraightWithPair()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straight(hand.testHand));
    }

    @Test
    public void testStraightWithHighAce()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "A");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Spades", "Q");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Hearts", "K");
        Card cardSeven = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straight(hand.testHand));
    }

    @Test
    public void testStraightWithLowAce()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "A");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Spades", "Q");
        Card cardFive = new Card("Clubs", "4");
        Card cardSix = new Card("Hearts", "2");
        Card cardSeven = new Card("Diamonds", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straight(hand.testHand));
    }

    @Test
    public void testStraightFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Diamonds", "A");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.straight(hand.testHand));
    }

    @Test
    public void testFlushTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Diamonds", "3");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Diamonds", "A");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.flush(hand.testHand));
    }

    @Test
    public void testFlushFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Diamonds", "3");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Clubs", "A");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Diamonds", "J");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.flush(hand.testHand));
    }

    @Test
    public void testFullHouseTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Clubs", "7");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.fullHouse(hand.testHand));
    }

    @Test
    public void testFullHouseFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Clubs", "7");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "6");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.fullHouse(hand.testHand));
    }

    @Test
    public void testFourOfaKindTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Clubs", "7");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.fourOfaKind(hand.testHand));
    }

    @Test
    public void testFourOfaKindFalse()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "2");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Clubs", "7");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.fourOfaKind(hand.testHand));
    }

    @Test
    public void testStraightFlushTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Spades", "A");
        Card cardFive = new Card("Diamonds", "5");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straightFlush(hand.testHand));
    }

    @Test
    public void testStraightFlushWithPair()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Spades", "A");
        Card cardFive = new Card("Diamonds", "5");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straightFlush(hand.testHand));
    }

    @Test
    public void testStraightFlushWithAllSameSuit()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Diamonds", "A");
        Card cardFive = new Card("Diamonds", "5");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Diamonds", "2");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straightFlush(hand.testHand));
    }

    @Test
    public void testStraightFlushWithLowAce()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Diamonds", "A");
        Card cardFive = new Card("Diamonds", "5");
        Card cardSix = new Card("Diamonds", "9");
        Card cardSeven = new Card("Diamonds", "2");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.straightFlush(hand.testHand));
    }

    @Test
    public void testStraightFlushFalseSuit()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Spades", "A");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.straightFlush(hand.testHand));
    }

    @Test
    public void testStraightFlushFalseNumber()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "7");
        Card cardTwo = new Card("Diamonds", "4");
        Card cardThree = new Card("Diamonds", "3");
        Card cardFour = new Card("Spades", "A");
        Card cardFive = new Card("Diamonds", "8");
        Card cardSix = new Card("Diamonds", "6");
        Card cardSeven = new Card("Spades", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.straightFlush(hand.testHand));
    }

    @Test
    public void testRoyalFlushTrue()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Diamonds", "J");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Diamonds", "Q");
        Card cardSeven = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.royalFlush(hand.testHand));
    }

    @Test
    public void testRoyalFlushWithPair()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Diamonds", "J");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "K");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Diamonds", "Q");
        Card cardSeven = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.royalFlush(hand.testHand));
    }

    @Test
    public void testRoyalFlushWithAllSameSuit()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Diamonds", "J");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Diamonds", "9");
        Card cardFive = new Card("Diamonds", "5");
        Card cardSix = new Card("Diamonds", "Q");
        Card cardSeven = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertTrue(hand.royalFlush(hand.testHand));
    }

    @Test
    public void testRoyalFlushFalseSuit()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Diamonds", "J");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Clubs", "Q");
        Card cardSeven = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.royalFlush(hand.testHand));
    }

    @Test
    public void testRoyalFlushFalseNumber()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Diamonds", "J");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Diamonds", "9");
        Card cardSeven = new Card("Diamonds", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertFalse(hand.royalFlush(hand.testHand));
    }

    @Test
    public void testHandValueFlush()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Diamonds", "7");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "2");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Diamonds", "9");
        Card cardSeven = new Card("Diamonds", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        assertEquals(6, hand.handValue(hand.testHand));
    }

    @Test
    public void testCompareHigherFirst()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Clubs", "K");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "K");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Hearts", "K");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "A");
        Card cardTwo2 = new Card("Spades", "2");
        Card cardThree2 = new Card("Diamonds", "A");
        Card cardFour2 = new Card("Spades", "7");
        Card cardFive2 = new Card("Clubs", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(1, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareHigherSecond()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "K");
        Card cardTwo = new Card("Clubs", "K");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "K");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Hearts", "A");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Spades", "2");
        Card cardThree2 = new Card("Diamonds", "9");
        Card cardFour2 = new Card("Spades", "9");
        Card cardFive2 = new Card("Clubs", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareRoyalFlushTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Diamonds", "10");
        Card cardTwo = new Card("Diamonds", "K");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Spades", "3");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Diamonds", "J");
        Card cardSeven = new Card("Diamonds", "Q");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "Q");
        Card cardTwo2 = new Card("Clubs", "J");
        Card cardThree2 = new Card("Clubs", "A");
        Card cardFour2 = new Card("Clubs", "K");
        Card cardFive2 = new Card("Clubs", "5");
        Card cardSix2 = new Card("Clubs", "10");
        Card cardSeven2 = new Card("Diamonds", "3");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(0, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareStraightFlushTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Hearts", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Hearts", "9");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Hearts", "Q");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "2");
        Card cardThree2 = new Card("Diamonds", "A");
        Card cardFour2 = new Card("Diamonds", "3");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(1, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareFourOfaKindTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Diamonds", "8");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Spades", "8");
        Card cardFive = new Card("Clubs", "8");
        Card cardSix = new Card("Hearts", "Q");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "10");
        Card cardTwo2 = new Card("Diamonds", "10");
        Card cardThree2 = new Card("Diamonds", "A");
        Card cardFour2 = new Card("Spades", "10");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "10");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareFullHouseTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Diamonds", "10");
        Card cardThree = new Card("Spades", "J");
        Card cardFour = new Card("Hearts", "J");
        Card cardFive = new Card("Clubs", "8");
        Card cardSix = new Card("Hearts", "Q");
        Card cardSeven = new Card("Diamonds", "8");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "A");
        Card cardTwo2 = new Card("Diamonds", "K");
        Card cardThree2 = new Card("Diamonds", "A");
        Card cardFour2 = new Card("Clubs", "K");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "K");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareFlushTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Hearts", "2");
        Card cardThree = new Card("Hearts", "7");
        Card cardFour = new Card("Hearts", "10");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Hearts", "Q");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "2");
        Card cardThree2 = new Card("Diamonds", "Q");
        Card cardFour2 = new Card("Diamonds", "8");
        Card cardFive2 = new Card("Diamonds", "3");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(1, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareStraightTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Diamonds", "9");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Spades", "Q");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "2");
        Card cardThree2 = new Card("Spades", "A");
        Card cardFour2 = new Card("Hearts", "3");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(1, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareStraightSameValuesTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Diamonds", "9");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Spades", "Q");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "8");
        Card cardThree2 = new Card("Spades", "J");
        Card cardFour2 = new Card("Hearts", "Q");
        Card cardFive2 = new Card("Diamonds", "10");
        Card cardSix2 = new Card("Hearts", "2");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(0, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareThreeOfaKindTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "5");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Diamonds", "5");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Spades", "Q");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "2");
        Card cardThree2 = new Card("Spades", "9");
        Card cardFour2 = new Card("Hearts", "3");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareTwoPairTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Diamonds", "8");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Spades", "10");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "2");
        Card cardThree2 = new Card("Spades", "2");
        Card cardFour2 = new Card("Hearts", "3");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(1, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareTwoPairHighCardTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Diamonds", "8");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Spades", "10");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "8");
        Card cardTwo2 = new Card("Diamonds", "10");
        Card cardThree2 = new Card("Spades", "8");
        Card cardFour2 = new Card("Hearts", "10");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "A");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareOnePairTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "8");
        Card cardTwo = new Card("Clubs", "10");
        Card cardThree = new Card("Hearts", "J");
        Card cardFour = new Card("Diamonds", "8");
        Card cardFive = new Card("Clubs", "5");
        Card cardSix = new Card("Spades", "A");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "9");
        Card cardTwo2 = new Card("Diamonds", "2");
        Card cardThree2 = new Card("Spades", "J");
        Card cardFour2 = new Card("Hearts", "3");
        Card cardFive2 = new Card("Diamonds", "5");
        Card cardSix2 = new Card("Hearts", "9");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    @Test
    public void testCompareHighCardTie()
    {
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "4");
        Card cardThree = new Card("Hearts", "6");
        Card cardFour = new Card("Diamonds", "8");
        Card cardFive = new Card("Clubs", "J");
        Card cardSix = new Card("Spades", "10");
        Card cardSeven = new Card("Diamonds", "3");
        Hand hand2 = new Hand();
        Card cardOne2 = new Card("Clubs", "3");
        Card cardTwo2 = new Card("Diamonds", "5");
        Card cardThree2 = new Card("Spades", "7");
        Card cardFour2 = new Card("Hearts", "9");
        Card cardFive2 = new Card("Diamonds", "Q");
        Card cardSix2 = new Card("Hearts", "8");
        Card cardSeven2 = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        hand.addCard(hand.testHand, cardSeven);
        hand2.addCard(hand.testHand2, cardOne2);
        hand2.addCard(hand.testHand2, cardTwo2);
        hand2.addCard(hand.testHand2, cardThree2);
        hand2.addCard(hand.testHand2, cardFour2);
        hand2.addCard(hand.testHand2, cardFive2);
        hand2.addCard(hand.testHand2, cardSix2);
        hand2.addCard(hand.testHand2, cardSeven2);
        assertEquals(2, hand.compareHands(hand.testHand, hand.testHand2));
    }

    // GamePlayTests
    @Test
    public void testCreatingGamePlay() {
        GamePlay gp = new GamePlay();
        assertEquals(2, gp.bot1.getHand().size());
    }

    @Test
    public void testAfterFirstRound() {
        GamePlay gp = new GamePlay();
        gp.afterFirstRound(gp.bot1);
        assertEquals(3, gp.bot1.getHand().size());
    }

    @Test
    public void testAfterSecondRound() {
        GamePlay gp = new GamePlay();
        gp.afterFirstRound(gp.bot1);
        gp.afterSecondRound(gp.bot1);
        assertEquals(4, gp.bot1.getHand().size());
    }

    @Test
    public void testAfterThirdRound() {
        GamePlay gp = new GamePlay();
        gp.afterFirstRound(gp.bot1);
        gp.afterSecondRound(gp.bot1);
        gp.afterThirdRound(gp.bot1);
        assertEquals(5, gp.bot1.getHand().size());
    }

    @Test
    public void testAfterFourthRound() {
        GamePlay gp = new GamePlay();
        gp.afterFirstRound(gp.bot1);
        gp.afterSecondRound(gp.bot1);
        gp.afterThirdRound(gp.bot1);
        gp.afterFourthRound(gp.bot1);
        assertEquals(6, gp.bot1.getHand().size());
    }

    @Test
    public void testAfterFifthRound() {
        GamePlay gp = new GamePlay();
        gp.afterFirstRound(gp.bot1);
        gp.afterSecondRound(gp.bot1);
        gp.afterThirdRound(gp.bot1);
        gp.afterFourthRound(gp.bot1);
        gp.afterFifthRound(gp.bot1);
        assertEquals(7, gp.bot1.getHand().size());
    }

    @Test
    public void testShouldFoldSizeTwo() {
        GamePlay gp = new GamePlay();
        assertEquals(0, gp.shouldFold(gp.bot1.getHand()));
    }

    @Test
    public void testShouldFoldSizeThree() {
        GamePlay gp = new GamePlay();
        gp.afterFirstRound(gp.bot1);
        assertEquals(0, gp.shouldFold(gp.bot1.getHand()));
    }

    @Test
    public void testShouldFoldSizeFourSameNumber() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Spades", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFourSameSuit() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Diamonds", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFourPotentialStraight() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "9");
        Card cardFour = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFourWithNothing() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "A");
        Card cardFour = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        assertEquals(2, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFiveAllSameNumber() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Hearts", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFiveTwoSameNumber() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Spades", "10");
        Card cardFive = new Card("Hearts", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(1, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFiveAllSameSuit() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "10");
        Card cardFive = new Card("Diamonds", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFiveTwoSameSuit() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "10");
        Card cardFive = new Card("Diamonds", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(1, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFivePotentialThreeStraight() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "8");
        Card cardFive = new Card("Spades", "9");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFivePotentialTwoStraight() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Clubs", "9");
        Card cardFive = new Card("Spades", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(1, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeFiveWithNothing() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "A");
        Card cardFour = new Card("Clubs", "9");
        Card cardFive = new Card("Spades", "5");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        assertEquals(2, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeSixAllSameNumber() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Hearts", "7");
        Card cardSix = new Card("Clubs", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeSixThreeSameNumber() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Spades", "7");
        Card cardFive = new Card("Hearts", "J");
        Card cardSix = new Card("Clubs", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        assertEquals(1, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeSixAllSameSuit() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Diamonds", "4");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Diamonds", "A");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeSixPotentialStraight() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "9");
        Card cardFive = new Card("Spades", "8");
        Card cardSix = new Card("Hearts", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        assertEquals(0, gp.shouldFold(hand.testHand));
    }

    @Test
    public void testShouldFoldSizeSixWithNothing() {
        GamePlay gp = new GamePlay();
        Hand hand = new Hand();
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "7");
        Card cardFour = new Card("Clubs", "2");
        Card cardFive = new Card("Spades", "4");
        Card cardSix = new Card("Hearts", "10");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        hand.addCard(hand.testHand, cardSix);
        assertEquals(2, gp.shouldFold(hand.testHand));
    }
}