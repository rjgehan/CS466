package com.example.sevencardstud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Hand
{
    public static List<Card> hand1;
    public static List<Card> hand2;
    public static List<Card> hand3;
    public static List<Card> hand4;
    public static List<Card> hand5;
    public static List<Card> hand6;
    public static List<Card> testHand;
    public Deck newDeck;

    public Hand() {
        hand1 = new ArrayList<>();
        hand2 = new ArrayList<>();
        hand3 = new ArrayList<>();
        hand4 = new ArrayList<>();
        hand5 = new ArrayList<>();
        hand6 = new ArrayList<>();
        testHand = new ArrayList<>();
        newDeck = new Deck();
        newDeck.getCards();
        for (int i = 0; i < 2; i++) {
            hand1.add(newDeck.drawCard());
            hand2.add(newDeck.drawCard());
            hand3.add(newDeck.drawCard());
            hand4.add(newDeck.drawCard());
            hand5.add(newDeck.drawCard());
            hand6.add(newDeck.drawCard());
        }

        /*
        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "A");
        testHand.add(cardOne);
        testHand.add(cardTwo);
        testHand.add(cardThree);
        testHand.add(cardFour);
        testHand.add(cardFive);
        testHand.add(cardSix);
        testHand.add(cardSeven);

         */
    }

    public void addCard(List<Card> hand, Card card)
    {
        hand.add(card);
    }

    public void newRound() {
        hand1.add(newDeck.drawCard());
        hand2.add(newDeck.drawCard());
        hand3.add(newDeck.drawCard());
        hand4.add(newDeck.drawCard());
        hand5.add(newDeck.drawCard());
        hand6.add(newDeck.drawCard());
    }

    public int getSize(List<Card> hand) {
        return hand.size();
    }

    public boolean aceHighOrLow(List<Card> hand)
    {
        boolean aceHigh = true;
        boolean containsTwo = false;
        boolean containsThree = false;
        boolean containsFour = false;
        boolean containsFive = false;
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getNumber().equals("2"))
                containsTwo = true;
            else if(hand.get(i).getNumber().equals("3"))
                containsThree = true;
            else if(hand.get(i).getNumber().equals("4"))
                containsFour = true;
            else if(hand.get(i).getNumber().equals("5"))
                containsFive = true;
        }

        if(containsTwo && containsThree && containsFour && containsFive)
            aceHigh = false;

        return aceHigh;
    }

    public int[] sort(List<Card> hand)
    {
        int valueArray[] = new int[hand.size()];

        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getNumber().equals("A"))
            {
                if(aceHighOrLow(hand))
                    valueArray[i] = 14;
                else
                    valueArray[i] = 1;
            }
            else if(hand.get(i).getNumber().equals("K"))
                valueArray[i] = 13;
            else if(hand.get(i).getNumber().equals("Q"))
                valueArray[i] = 12;
            else if(hand.get(i).getNumber().equals("J"))
                valueArray[i] = 11;
            else
                valueArray[i] = Integer.parseInt(hand.get(i).getNumber());
        }

        Arrays.sort(valueArray);
        return valueArray;
    }

    public int highCard(List<Card> hand)
    {
        int max = 0;
        int value;
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getNumber().equals("A"))
            {
                if(aceHighOrLow(hand))
                    value = 14;
                else
                    value = 1;
            }
            else if(hand.get(i).getNumber().equals("K"))
                value = 13;
            else if(hand.get(i).getNumber().equals("Q"))
                value = 12;
            else if(hand.get(i).getNumber().equals("J"))
                value= 11;
            else
                value = Integer.parseInt(hand.get(i).getNumber());

            if(value > max)
            {
                max = value;
            }
        }

        return max;
    }

    public boolean onePair(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int count = 1;
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    count++;
            }

            if(count == 2)
                return true;
        }

        return false;
    }

    public boolean twoPair(List<Card> hand)
    {
        int count = 0;
        for (int i = 0; i < hand.size(); i++)
        {
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    count++;
            }
        }

        if (count == 2)
            return true;
        else
            return false;
    }

    public boolean threeOfaKind(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int individualCardCount = 1;
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    individualCardCount++;
            }

            if (individualCardCount == 3)
                return true;
        }

        return false;
    }

    public boolean straight(List<Card> hand)
    {
        if (hand.size() < 5)
            return false;
        else {
            int sortedCards[] = sort(hand);
            int acesSorted[] = new int[sortedCards.length];
            if(!aceHighOrLow(hand))
            {
                for(int i = 0; i < sortedCards.length; i++)
                {
                    int value = sortedCards[i];
                    if(value == 14)
                        acesSorted[i] = 1;
                    else
                        acesSorted[i] = value;
                }
                Arrays.sort(acesSorted);
            }
            else
                acesSorted = sortedCards;
            int count = 1;

            for (int i = hand.size() - 1; i > 0; i--)
            {
                if (acesSorted[i] == acesSorted[i - 1] + 1)
                {
                    count++;
                    if (count == 5)
                        break;
                }

                else if((acesSorted[i] == acesSorted[i-1]) && (acesSorted[i] == acesSorted[i-2] + 1))
                {
                    count++;
                    if(count == 5)
                        break;
                }

                else
                    count = 1;
            }

            if (count < 5)
                return false;
            else
                return true;
        }
    }

    public boolean flush(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int sameSuitCount = 1;
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getSuit().equals(hand.get(j).getSuit()))
                    sameSuitCount++;
            }

            if(sameSuitCount == 5)
                return true;
        }

        return false;
    }

    public boolean fullHouse(List<Card> hand)
    {
        if(threeOfaKind(hand))
        {
            List<Card> duplicateHand = new ArrayList<>(hand);
            int sortedCards[] = sort(duplicateHand);
            int count = 1;
            int numberValue = 0;

            for (int i = 0; i < hand.size() - 1; i++) {
                if (sortedCards[i] == sortedCards[i + 1]) {
                    count++;
                    if (count == 3) {
                        numberValue = sortedCards[i];
                        break;
                    }
                } else
                    count = 1;
            }

            int value = 0;
            for (int i = hand.size() - 1; i > 0; i--) {
                if (hand.get(i).getNumber().equals("A"))
                    value = 14;
                else if (hand.get(i).getNumber().equals("K"))
                    value = 13;
                else if (hand.get(i).getNumber().equals("Q"))
                    value = 12;
                else if (hand.get(i).getNumber().equals("J"))
                    value = 11;
                else
                    value = Integer.parseInt(hand.get(i).getNumber());

                if (value == numberValue) {
                    duplicateHand.remove(i);
                }
            }

            if (onePair(duplicateHand))
                return true;
            else
                return false;
        }

        else
            return false;
    }

    public boolean fourOfaKind(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int individualCardCount = 1;
            for (int j = 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    individualCardCount++;
            }

            if(individualCardCount == 4)
                return true;
        }

        return false;
    }

    public boolean straightFlush(List<Card> hand)
    {
        if (flush(hand))
        {
            String flushSuit = "";
            for (int i = 0; i < hand.size(); i++)
            {
                int sameSuitCount = 1;
                for (int j = i + 1; j < hand.size(); j++)
                {
                    if (hand.get(i).getSuit().equals(hand.get(j).getSuit()))
                    {
                        sameSuitCount++;
                        if (sameSuitCount == 5)
                        {
                            flushSuit = hand.get(i).getSuit();
                        }
                    }
                }
            }

            List<Card> duplicateHand = new ArrayList<>(hand);
            Collections.sort(duplicateHand, Card::compare);
            List<Card> potentialStraightCards = new ArrayList<>();

            for (int j = 0; j < hand.size(); j++) {
                if (duplicateHand.get(j).getSuit().equals(flushSuit))
                    potentialStraightCards.add(duplicateHand.get(j));
            }

            Collections.sort(potentialStraightCards, Card::compare);

            if(potentialStraightCards.size() == 5)
            {
                if(straight(potentialStraightCards))
                    return true;
                else
                    return false;
            }
            else {

                if (straight(potentialStraightCards))
                    return true;
                else
                    return false;
            }
        }

        else
            return false;
    }

    public boolean royalFlush(List<Card> hand)
    {
        if (flush(hand))
        {
            String flushSuit = "";
            for (int i = 0; i < hand.size(); i++) {
                int sameSuitCount = 1;
                for (int j = i + 1; j < hand.size(); j++) {
                    if (hand.get(i).getSuit().equals(hand.get(j).getSuit()))
                    {
                        sameSuitCount++;
                        if (sameSuitCount == 5)
                        {
                            flushSuit = hand.get(i).getSuit();
                        }
                    }
                }
            }

            List<Card> duplicateHand = new ArrayList<>(hand);
            Collections.sort(duplicateHand, Card::compare);
            List<Card> potentialStraightCards = new ArrayList<>();

            for (int j = 0; j < hand.size(); j++) {
                if (duplicateHand.get(j).getSuit().equals(flushSuit))
                    potentialStraightCards.add(duplicateHand.get(j));
            }

            String firstNumber = potentialStraightCards.get(potentialStraightCards.size() - 5).getNumber();
            String secondNumber = potentialStraightCards.get(potentialStraightCards.size() - 4).getNumber();
            String thirdNumber = potentialStraightCards.get(potentialStraightCards.size() - 3).getNumber();
            String fourthNumber = potentialStraightCards.get(potentialStraightCards.size() - 2).getNumber();
            String fifthNumber = potentialStraightCards.get(potentialStraightCards.size() - 1).getNumber();

            if (straight(potentialStraightCards)) {
                if (firstNumber.equals("10") && secondNumber.equals("J") && thirdNumber.equals("Q") && fourthNumber.equals("K") && fifthNumber.equals("A"))
                    return true;
                else
                    return false;
            }

            else
                return false;
        }

        else
            return false;
    }

    public int handValue(List<Card> hand)
    {
        int value = 0;
        if(royalFlush(hand))
            value = 10;
        if(straightFlush(hand))
            value = 9;
        if(fourOfaKind(hand))
            value = 8;
        if(fullHouse(hand))
            value = 7;
        if(flush(hand))
            value = 6;
        if(straight(hand))
            value = 5;
        if(threeOfaKind(hand))
            value = 4;
        if(twoPair(hand))
            value = 3;
        if(onePair(hand))
            value = 2;

        return value;
    }

    public void tie(List<Card> handOne, List<Card> handTwo)
    {
        // HERE YOU WILL HAVE TO SPLIT THE WINNINGS BETWEEN THE TWO HANDS
    }

    /*
    public List<Card> compareHands(List<Card> handOne, List<Card> handTwo)
    {
        // SHOULD WE HAVE A NEW DECK THAT ONLY CONTAINS THE FIVE CARDS YOU ARE USING AS YOUR HAND
        if(handValue(handOne) > handValue(handTwo))
            return handOne;
        else if(handValue(handOne) < handValue(handTwo))
            return handTwo;
        else if(handValue(handOne) == 10 && handValue(handTwo) == 10)
        {
            // IF TWO ROYAL FLUSHES THEN THERE IS A TIE;
            tie(handOne, handTwo);
        }
        else if(handValue(handOne) == 9 && handValue(handTwo) == 9)
        {
            // HIGH CARD HAS TO BE OF THE 5 CARDS BEING USED IN THE STRAIGHT
            // NEED TO CHANGE THE PARAMETERS TO JUST THE FOUR OF A KIND
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else if(highCard(handOne) < highCard(handTwo))
                return handTwo;
            else
                tie(handOne, handTwo);
            // THERE IS A TIE
        }
        else if(handValue(handOne) == 8 && handValue(handTwo) == 8)
        {
            // HAVE TO SEE WHICH CARD IN THE FOUR OF A KIND IS HIGHER
            // NEED TO CHANGE THE PARAMETERS TO JUST THE FOUR OF A KIND)
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else
                return handTwo;
        }
        else if(handValue(handOne) == 7 && handValue(handTwo) == 7)
        {
            // HAVE TO SEE WHICH OF THE THREE OF A KIND IS A HIGHER CARD
            // NEED TO CHANGE THE PARAMETERS TO JUST THE THREE OF A KIND
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else
                return handTwo;
        }
        else if(handValue(handOne) == 6 && handValue(handTwo) == 6)
        {
            // HIGH CARD HAS TO BE OF THE 5 CARDS BEING USED
            // NEED TO CHANGE PARAMETERS TO JUST THE 5 CARDS BEING USED
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else if(highCard(handOne) < highCard(handTwo))
                return handTwo;
            else
                tie(handOne, handTwo);
            // THERE IS A TIE;
        }
        else if(handValue(handOne) == 5 && handValue(handTwo) == 5)
        {
            // HIGH CARD HAS TO BE OF THE 5 CARDS BEING USED
            // NEED TO CHANGE PARAMETERS TO JUST THE 5 CARDS BEING USED
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else if(highCard(handOne) < highCard(handTwo))
                return handTwo;
            else
                tie(handOne, handTwo);
            // THERE IS A TIE
        }
        else if(handValue(handOne) == 4 && handValue(handTwo) == 4)
        {
            // HIGH CARD HAS TO COME FROM THE THREE OF A KIND CARDS
            // NEED TO CHANGE PARAMETERS TO JUST THE THREE OF A KIND CARDS
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else if(highCard(handOne) < highCard(handTwo))
                return handTwo;
        }
        else if(handValue(handOne) == 3 && handValue(handTwo) == 3)
        {
            // FIRST CHECK FOR A HIGH CARD FROM THE FOUR PAIRS
            // IF FIRST TWO ARE THE SAME THEN CHECK FOR THE SECOND PAIR
            // THEN IF THE SAME CHECK FOR A HIGH CARD ON THE LAST REMAINING ONE
            // OTHERWISE TIE
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else if(highCard(handOne) < highCard(handTwo))
                return handTwo;
            else
            {
                if(highCard(handOne) > highCard(handTwo))
                    return handOne;
                else if(highCard(handOne) < highCard(handTwo))
                    return handTwo;
                else
                    tie(handOne, handTwo);
                // THERE IS A TIE
            }
        }
        else if(handValue(handOne) == 2 && handValue(handTwo) == 2)
        {
            // FIRST CHECK FOR THE HIGHER OF THE PAIRS
            // IF THE SAME CHECK FOR THE HIGHEST CARD IN THE THREE REMAINING
            // IF SAME CHECK IN TWO REMAINING AND SO ON
            // OTHERWISE TIE
            if(highCard(handOne) > highCard(handTwo))
                return handOne;
            else if(highCard(handOne) < highCard(handTwo))
                return handTwo;
            else
            {
                if(highCard(handOne) > highCard(handTwo))
                    return handOne;
                else if(highCard(handOne) < highCard(handTwo))
                    return handTwo;
                else
                {
                    tie(handOne, handTwo);
                }
            }
        }
    }

     */

    public void printHand(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            System.out.print(hand.get(i).getNumber() + hand.get(i).getSuit() + " ");
        }
        System.out.println();
    }
}
