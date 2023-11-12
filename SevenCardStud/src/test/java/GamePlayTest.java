import com.example.sevencardstud.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePlayTest {
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