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
        assertEquals(3, hand.getSize(hand.hand1));
    }

    @Test
    public void testNewRoundHandSize()
    {
        Hand hand = new Hand();
        hand.newRound();
        assertEquals(4, hand.getSize(hand.hand1));
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

    @Test
    public void testBettingCallRoundThree() {
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
        assertEquals(0, gp.bot.getBettingAction());
    }

    @Test
    public void testBettingRaiseRoundThree() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Diamonds", "J");
        Card cardFive = new Card("Diamonds", "Q");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertEquals(1, gp.bot.getBettingAction());
    }

    @Test
    public void testBettingRaiseRoundThreeTwo() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Diamonds", "7");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertEquals(1, gp.bot.getBettingAction());
    }

    @Test
    public void testBettingCallRoundFour() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Spades", "2");
        Card cardFour = new Card("Hearts", "7");
        Card cardFive = new Card("Spades", "5");
        Card cardSix = new Card("Diamonds", "4");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertEquals(0, gp.bot.getBettingAction());
    }

    @Test
    public void testBettingRaiseRoundFour() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "10");
        Card cardFour = new Card("Diamonds", "J");
        Card cardFive = new Card("Diamonds", "Q");
        Card cardSix = new Card("Diamonds", "K");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertEquals(1, gp.bot.getBettingAction());
    }

    @Test
    public void testBettingRaiseRoundFourTwo() {
        Hand hand = new Hand();
        List<Card> newHand = new ArrayList<>();
        List<Card> secondHand = new ArrayList<>();
        List<List<Card>> cardHands = new ArrayList<>();
        Card cardOne = new Card("Hearts", "6");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Diamonds", "6");
        Card cardFive = new Card("Diamonds", "7");
        Card cardSix = new Card("Diamonds", "8");
        hand.addCard(hand.testHand, cardOne);
        hand.addCard(hand.testHand, cardTwo);
        hand.addCard(hand.testHand, cardThree);
        hand.addCard(hand.testHand, cardFour);
        hand.addCard(hand.testHand, cardFive);
        newHand.addAll(hand.testHand);
        cardHands.add(newHand);
        GamePlay gp = new GamePlay(cardHands, newHand);
        gp.afterThirdRound();
        assertEquals(1, gp.bot.getBettingAction());
    }

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