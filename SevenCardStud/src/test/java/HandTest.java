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
}