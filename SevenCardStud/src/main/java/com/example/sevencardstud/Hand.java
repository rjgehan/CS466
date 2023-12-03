package com.example.sevencardstud;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

public class Hand
{
    public static List<Card> hand1;
    public static List<Card> hand2;
    public static List<Card> hand3;
    public static List<Card> hand4;
    public static List<Card> hand5;
    public static List<Card> hand6;
    public List<Card> testHand;

    public static List<Card> testHand2;
    public Deck newDeck;
    public int turn;
    public int round;

    public Hand() {
        hand1 = new ArrayList<>();
        hand2 = new ArrayList<>();
        hand3 = new ArrayList<>();
        hand4 = new ArrayList<>();
        hand5 = new ArrayList<>();
        hand6 = new ArrayList<>();
        testHand = new ArrayList<>();
        testHand2 = new ArrayList<>();
        newDeck = new Deck();
        turn = 0;
        round = 1;

        for (int i = 0; i <= 2; i++) {
            hand1.add(newDeck.drawCard());
            hand2.add(newDeck.drawCard());
            hand3.add(newDeck.drawCard());
            hand4.add(newDeck.drawCard());
            hand5.add(newDeck.drawCard());
            hand6.add(newDeck.drawCard());
        }



    }

    public void addCard(List<Card> hand, Card card)
    {
        hand.add(card);
    }

    public void playerTurnEnd() {
        turn++;
        newTurn();
    }

    public void newRound() {
        playerTurnEnd();
        while (turn != 0) {
            newTurn();
        }
    }

    public void newTurn() {
        System.out.println("Turn value: " + turn);
        if (turn != 7) {
            if (turn > 0) {
                handAction();
            }
            turn++;
        } else {
            System.out.println("Round value: " + round);
            turn = 0;
            if (round != 6) {
                round++;
            }
            else {
                round = 0;
            }
        }
    }

    public void handAction() {
        switch (turn) {
            case 1:
                hand1.add(newDeck.drawCard());
                break;
            case 2:
                //BOT LOGIC INPUT
                hand2.add(newDeck.drawCard());
                break;
            case 3:
                //BOT LOGIC INPUT
                hand3.add(newDeck.drawCard());
                break;
            case 4:
                //BOT LOGIC INPUT
                hand4.add(newDeck.drawCard());
                break;
            case 5:
                //BOT LOGIC INPUT
                hand5.add(newDeck.drawCard());
                break;
            case 6:
                //BOT LOGIC INPUT
                hand6.add(newDeck.drawCard());
                break;
            default:
                //DEFAULT
                break;
        }
    }


    public void initializeHands() {
        newDeck = new Deck();

        hand1.clear();
        hand2.clear();
        hand3.clear();
        hand4.clear();
        hand5.clear();
        hand6.clear();

        for (int i = 0; i < 3; i++) { // Deal two cards to each hand as an example
            hand1.add(newDeck.drawCard());
            hand2.add(newDeck.drawCard());
            hand3.add(newDeck.drawCard());
            hand4.add(newDeck.drawCard());
            hand5.add(newDeck.drawCard());
            hand6.add(newDeck.drawCard());
        }
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

    public int numberStringValue(String cardNumber)
    {
        if(cardNumber.equals("A"))
            return 14;
        else if(cardNumber.equals("K"))
            return 13;
        else if(cardNumber.equals("Q"))
            return 12;
        else if(cardNumber.equals("J"))
            return 11;
        else
            return Integer.parseInt(cardNumber);
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
            else
                valueArray[i] = numberStringValue(hand.get(i).getNumber());
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
            else
                value = numberStringValue(hand.get(i).getNumber());

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

                else if(i != 1)
                {
                    if((acesSorted[i] == acesSorted[i-1]) && (acesSorted[i] == acesSorted[i-2] + 1))
                    {
                        count++;
                        if(count == 5)
                            break;
                    }
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
                value = numberStringValue(hand.get(i).getNumber());

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
        boolean isFourOfAKind = false;

        int sortedHand[] = sort(hand);

        Map<Integer, Integer> handMap = new HashMap<Integer, Integer>();

        for (int value : sortedHand) {
            handMap.put(value, handMap.getOrDefault(value, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> values : handMap.entrySet())
        {
            if(values.getValue() == 4)
            {
                isFourOfAKind = true;
                break;
            }
        }

        return isFourOfAKind;
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
        else if(straightFlush(hand))
            value = 9;
        else if(fourOfaKind(hand))
            value = 8;
        else if(fullHouse(hand))
            value = 7;
        else if(flush(hand))
            value = 6;
        else if(straight(hand))
            value = 5;
        else if(threeOfaKind(hand))
            value = 4;
        else if(twoPair(hand))
            value = 3;
        else if(onePair(hand))
            value = 2;

        return value;
    }

    public int straightFlushTie(List<Card> handOne, List<Card> handTwo)
    {
        String flushSuit = "";
        for (int i = 0; i < handOne.size(); i++)
        {
            int sameSuitCount = 1;
            for (int j = i + 1; j < handOne.size(); j++)
            {
                if (handOne.get(i).getSuit().equals(handOne.get(j).getSuit()))
                {
                    sameSuitCount++;
                    if (sameSuitCount == 5)
                    {
                        flushSuit = handOne.get(i).getSuit();
                    }
                }
            }
        }
        int potentialStraightFlush[] = new int[handOne.size()];
        int sfIndex = 0;
        for(int i = 0; i < handOne.size(); i++)
        {
            int value = 0;
            if(handOne.get(i).getSuit().equals(flushSuit))
            {
                if(handOne.get(i).getNumber().equals("A"))
                {
                    if(aceHighOrLow(handOne))
                        value = 14;
                    else
                        value = 1;
                }
                else
                    value = numberStringValue(handOne.get(i).getNumber());
                potentialStraightFlush[sfIndex] = value;
                sfIndex++;
            }
        }
        Arrays.sort(potentialStraightFlush);
        int straightHandOne[] = new int[handOne.size()];
        int count = 1;
        int highestValue = 0;
        int index = 0;

        for (int i = handOne.size() - 1; i >= 1; i--)
        {
            if (potentialStraightFlush[i] == potentialStraightFlush[i - 1] + 1)
            {
                count++;
                straightHandOne[index] = potentialStraightFlush[i];
                index++;
                if (count == 5)
                {
                    break;
                }
            }

            else
            {
                count = 1;
            }
        }
        Arrays.sort(straightHandOne);
        highestValue = straightHandOne[6];

        String flushSuitTwo = "";
        for (int i = 0; i < handTwo.size(); i++)
        {
            int sameSuitCountTwo = 1;
            for (int j = i + 1; j < handTwo.size(); j++)
            {
                if (handTwo.get(i).getSuit().equals(handTwo.get(j).getSuit()))
                {
                    sameSuitCountTwo++;
                    if (sameSuitCountTwo == 5)
                    {
                        flushSuitTwo = handTwo.get(i).getSuit();
                    }
                }
            }
        }
        int potentialStraightFlushTwo[] = new int[handTwo.size()];
        int sfIndexTwo = 0;
        for(int i = 0; i < handTwo.size(); i++)
        {
            int value = 0;
            if(handTwo.get(i).getSuit().equals(flushSuitTwo))
            {
                if(handTwo.get(i).getNumber().equals("A"))
                {
                    if(aceHighOrLow(handTwo))
                        value = 14;
                    else
                        value = 1;
                }
                else
                    value = numberStringValue(handTwo.get(i).getNumber());
                potentialStraightFlushTwo[sfIndexTwo] = value;
                sfIndexTwo++;
            }
        }
        Arrays.sort(potentialStraightFlushTwo);
        int straightHandTwo[] = new int[handTwo.size()];
        int countTwo = 1;
        int highestValueTwo = 0;
        int indexTwo = 0;

        for (int i = handTwo.size() - 1; i >= 1; i--)
        {
            if (potentialStraightFlushTwo[i] == potentialStraightFlushTwo[i - 1] + 1)
            {
                countTwo++;
                straightHandTwo[indexTwo] = potentialStraightFlushTwo[i];
                indexTwo++;
                if (countTwo == 5)
                {
                    break;
                }
            }

            else
            {
                countTwo = 1;
            }
        }
        Arrays.sort(straightHandTwo);
        highestValueTwo = straightHandTwo[6];

        if(highestValue > highestValueTwo)
            return 1;
        else if(highestValue < highestValueTwo)
            return 2;
        else
            return 0;
    }

    public int fourOfAKindTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int sortedHandTwo[] = sort(handTwo);

        Map<Integer, Integer> handOneMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> handTwoMap = new HashMap<Integer, Integer>();

        for (int value : sortedHandOne) {
            handOneMap.put(value, handOneMap.getOrDefault(value, 0) + 1);
        }

        for (int value : sortedHandTwo) {
            handTwoMap.put(value, handTwoMap.getOrDefault(value, 0) + 1);
        }

        int handOneValue = 0;
        int handTwoValue = 0;
        for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
        {
            if(values.getValue() == 4)
            {
                handOneValue = values.getKey();
                break;
            }
        }

        for(Map.Entry<Integer, Integer> values2 : handTwoMap.entrySet())
        {
            if(values2.getValue() == 4)
            {
                handTwoValue = values2.getKey();
                break;
            }
        }

        if(handOneValue > handTwoValue)
            return 1;
        else if(handOneValue < handTwoValue)
            return 2;
        else
            return 0;
    }

    public int fullHouseTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int sortedHandTwo[] = sort(handTwo);

        Map<Integer, Integer> handOneMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> handTwoMap = new HashMap<Integer, Integer>();

        for (int value : sortedHandOne) {
            handOneMap.put(value, handOneMap.getOrDefault(value, 0) + 1);
        }

        for (int value : sortedHandTwo) {
            handTwoMap.put(value, handTwoMap.getOrDefault(value, 0) + 1);
        }

        int handOneValue = 0;
        int handTwoValue = 0;
        int handOneCount = 0;
        int handTwoCount = 0;
        for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
        {
            if(values.getValue() == 3)
            {
                handOneCount++;
            }
        }

        for(Map.Entry<Integer, Integer> values2 : handTwoMap.entrySet())
        {
            if(values2.getValue() == 3)
            {
                handTwoCount++;
            }
        }

        if(handOneCount == 1)
        {
            for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
            {
                if(values.getValue() == 3)
                {
                    handOneValue = values.getKey();
                    break;
                }
            }
        }

        else if(handOneCount == 2)
        {
            ArrayList<Integer> handOneThrees = new ArrayList<Integer>();
            for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
            {
                if(values.getValue() == 3)
                {
                    handOneThrees.add(values.getKey());
                }
            }
            if(handOneThrees.get(0) > handOneThrees.get(1))
                handOneValue = handOneThrees.get(0);
            else
                handOneValue = handOneThrees.get(1);
        }

        if(handTwoCount == 1)
        {
            for(Map.Entry<Integer, Integer> values : handTwoMap.entrySet())
            {
                if(values.getValue() == 3)
                {
                    handTwoValue = values.getKey();
                    break;
                }
            }
        }

        else if(handTwoCount == 2)
        {
            ArrayList<Integer> handTwoThrees = new ArrayList<Integer>();
            for(Map.Entry<Integer, Integer> values : handTwoMap.entrySet())
            {
                if(values.getValue() == 3)
                {
                    handTwoThrees.add(values.getKey());
                }
            }
            if(handTwoThrees.get(0) > handTwoThrees.get(1))
                handTwoValue = handTwoThrees.get(0);
            else
                handTwoValue = handTwoThrees.get(1);
        }

        if(handOneValue > handTwoValue)
            return 1;
        else if(handOneValue < handTwoValue)
            return 2;
        else
            return 0;
    }

    public int flushTie(List<Card> handOne, List<Card> handTwo)
    {
        String handOneSuit = "";
        for(int i = 0; i < handOne.size(); i++)
        {
            int sameSuitCount = 1;
            for(int j = i + 1; j < handOne.size(); j++)
            {
                if(handOne.get(i).getSuit().equals(handOne.get(j).getSuit()))
                    sameSuitCount++;
                if(sameSuitCount == 5)
                    handOneSuit = handOne.get(i).getSuit();
            }
        }

        String handTwoSuit = "";
        for(int i = 0; i < handTwo.size(); i++)
        {
            int sameSuitCount = 1;
            for(int j = i + 1; j < handTwo.size(); j++)
            {
                if(handTwo.get(i).getSuit().equals(handTwo.get(j).getSuit()))
                    sameSuitCount++;
                if(sameSuitCount == 5)
                    handTwoSuit = handTwo.get(i).getSuit();
            }
        }

        int handOneValues[] = new int[handOne.size()];
        int index = 0;
        int value = 0;
        for(int i = 0; i < handOne.size(); i++)
        {
            if(handOne.get(i).getSuit().equals(handOneSuit))
            {
                if(handOne.get(i).getNumber().equals("A"))
                {
                    if(aceHighOrLow(handOne))
                        value = 14;
                    else
                        value = 1;
                }
                else
                    value = numberStringValue(handOne.get(i).getNumber());
                handOneValues[index] = value;
                index++;
            }
        }

        int handTwoValues[] = new int[handTwo.size()];
        int indexTwo = 0;
        int valueTwo = 0;
        for(int i = 0; i < handTwo.size(); i++)
        {
            if(handTwo.get(i).getSuit().equals(handTwoSuit))
            {
                if(handTwo.get(i).getNumber().equals("A"))
                {
                    if(aceHighOrLow(handTwo))
                        valueTwo = 14;
                    else
                        valueTwo = 1;
                }
                else
                    valueTwo = numberStringValue(handTwo.get(i).getNumber());
                handTwoValues[indexTwo] = valueTwo;
                indexTwo++;
            }
        }

        int returnValue = 0;
        for(int i = 6; i > 1; i--)
        {
            if(handOneValues[i] > handTwoValues[i])
            {
                returnValue = 1;
                break;
            }
            else if(handOneValues[i] < handTwoValues[i])
            {
                returnValue = 2;
                break;
            }
        }
        return returnValue;
    }

    public int straightTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int straightHandOne[] = new int[handOne.size()];
        int count = 1;
        int highestValue = 0;
        int index = 0;

        for (int i = handOne.size() - 1; i >= 1; i--)
        {
            if (sortedHandOne[i] == sortedHandOne[i - 1] + 1)
            {
                count++;
                straightHandOne[index] = sortedHandOne[i];
                index++;
                if (count == 5)
                {
                    break;
                }
            }

            else
            {
                count = 1;
            }
        }
        Arrays.sort(straightHandOne);
        highestValue = straightHandOne[6];

        int sortedHandTwo[] = sort(handTwo);
        int straightHandTwo[] = new int[handTwo.size()];
        int indexTwo = 0;
        int countTwo = 1;
        int highestValueTwo = 0;

        for (int i = handTwo.size() - 1; i >= 1; i--)
        {
            if (sortedHandTwo[i] == sortedHandTwo[i - 1] + 1)
            {
                countTwo++;
                straightHandTwo[indexTwo] = sortedHandTwo[i];
                indexTwo++;
                if (countTwo == 5)
                {
                    break;
                }
            }

            else
            {
                countTwo = 1;
            }
        }
        Arrays.sort(straightHandTwo);
        highestValueTwo = straightHandTwo[6];

        if(highestValue > highestValueTwo)
            return 1;
        else if(highestValue < highestValueTwo)
            return 2;
        else
            return 0;
    }

    public int threeOfAKindTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int sortedHandTwo[] = sort(handTwo);

        Map<Integer, Integer> handOneMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> handTwoMap = new HashMap<Integer, Integer>();

        for (int value : sortedHandOne) {
            handOneMap.put(value, handOneMap.getOrDefault(value, 0) + 1);
        }

        for (int value : sortedHandTwo) {
            handTwoMap.put(value, handTwoMap.getOrDefault(value, 0) + 1);
        }

        int handOneValue = 0;
        int handTwoValue = 0;
        for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
        {
            if(values.getValue() == 3)
            {
                handOneValue = values.getKey();
                break;
            }
        }

        for(Map.Entry<Integer, Integer> values2 : handTwoMap.entrySet())
        {
            if(values2.getValue() == 3)
            {
                handTwoValue = values2.getKey();
                break;
            }
        }

        if(handOneValue > handTwoValue)
            return 1;
        else if(handOneValue < handTwoValue)
            return 2;
        else
            return 0;
    }

    public int twoPairTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int sortedHandTwo[] = sort(handTwo);

        Map<Integer, Integer> handOneMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> handTwoMap = new HashMap<Integer, Integer>();

        for (int value : sortedHandOne) {
            handOneMap.put(value, handOneMap.getOrDefault(value, 0) + 1);
        }

        for (int value : sortedHandTwo) {
            handTwoMap.put(value, handTwoMap.getOrDefault(value, 0) + 1);
        }

        int handOneTwos[] = new int[handOne.size()];
        int remainingHandOne[] = new int[3];
        int index = 0;
        int remainingIndex = 0;
        for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
        {
            if(values.getValue() == 2)
            {
                handOneTwos[index] = values.getKey();
                index++;
            }
            else
            {
                remainingHandOne[remainingIndex] = values.getKey();
                remainingIndex++;
            }
        }
        if(handOneTwos[2] != 0)
        {
            remainingHandOne[remainingIndex] = handOneTwos[0];
            remainingIndex++;
        }

        int handTwoTwos[] = new int[handOne.size()];
        int remainingHandTwo[] = new int[3];
        int indexTwo = 0;
        int remainingIndexTwo = 0;
        for(Map.Entry<Integer, Integer> values2 : handTwoMap.entrySet())
        {
            if(values2.getValue() == 2)
            {
                handTwoTwos[indexTwo] = values2.getKey();
                indexTwo++;
            }
            else
            {
                remainingHandTwo[remainingIndexTwo] = values2.getKey();
                remainingIndexTwo++;
            }
        }
        if(handTwoTwos[2] != 0)
        {
            remainingHandTwo[remainingIndexTwo] = handTwoTwos[0];
            remainingIndexTwo++;
        }


        if(handOneTwos[index - 1] > handTwoTwos[indexTwo - 1])
            return 1;
        else if(handOneTwos[index - 1] < handTwoTwos[indexTwo - 1])
            return 2;
        else //if(handOneTwos[index - 1] == handTwoTwos[indexTwo - 1])
        {
            if(handOneTwos[index - 2] > handTwoTwos[indexTwo - 2])
                return 1;
            else if(handOneTwos[index - 2] < handTwoTwos[indexTwo - 2])
                return 2;
            else
            {
                Arrays.sort(remainingHandOne);
                Arrays.sort(remainingHandTwo);
                if(remainingHandOne[remainingHandOne.length - 1] > remainingHandTwo[remainingHandTwo.length - 1])
                    return 1;
                else if(remainingHandOne[remainingHandOne.length - 1] < remainingHandTwo[remainingHandTwo.length - 1])
                    return 2;
                else
                    return 0;
            }
        }

    }

    public int onePairTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int sortedHandTwo[] = sort(handTwo);

        Map<Integer, Integer> handOneMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> handTwoMap = new HashMap<Integer, Integer>();

        for (int value : sortedHandOne) {
            handOneMap.put(value, handOneMap.getOrDefault(value, 0) + 1);
        }

        for (int value : sortedHandTwo) {
            handTwoMap.put(value, handTwoMap.getOrDefault(value, 0) + 1);
        }

        int handOnePairValue = 0;
        int remainingHandOne[] = new int[5];
        int remainingIndex = 0;
        for(Map.Entry<Integer, Integer> values : handOneMap.entrySet())
        {
            if(values.getValue() == 2)
            {
                handOnePairValue = values.getKey();
            }
            else
            {
                remainingHandOne[remainingIndex] = values.getKey();
                remainingIndex++;
            }
        }

        int handTwoPairValue = 0;
        int remainingHandTwo[] = new int[5];
        int remainingIndexTwo = 0;
        for(Map.Entry<Integer, Integer> values2 : handTwoMap.entrySet())
        {
            if(values2.getValue() == 2)
            {
                handTwoPairValue = values2.getKey();
            }
            else
            {
                remainingHandTwo[remainingIndexTwo] = values2.getKey();
                remainingIndexTwo++;
            }
        }

        if(handOnePairValue > handTwoPairValue)
            return 1;
        else if(handOnePairValue < handTwoPairValue)
            return 2;
        else
        {
            Arrays.sort(remainingHandOne);
            Arrays.sort(remainingHandTwo);

            int returnValue = 0;
            for(int i = 4; i > 1; i--)
            {
                if(remainingHandOne[i] > remainingHandTwo[i])
                {
                    returnValue = 1;
                    break;
                }
                else if(remainingHandOne[i] < remainingHandTwo[i])
                {
                    returnValue = 2;
                    break;
                }
            }
            return returnValue;
        }
    }

    public int highCardTie(List<Card> handOne, List<Card> handTwo)
    {
        int sortedHandOne[] = sort(handOne);
        int sortedHandTwo[] = sort(handTwo);
        int returnValue = 0;

        for(int i = sortedHandOne.length - 2; i >= 2; i--)
        {
            if(sortedHandOne[i] > sortedHandTwo[i])
            {
                returnValue = 1;
                break;
            }
            else if(sortedHandOne[i] < sortedHandTwo[i])
            {
                returnValue = 2;
                break;
            }
        }

        return returnValue;
    }

    public void tie(List<Card> handOne, List<Card> handTwo)
    {
        // HERE YOU WILL HAVE TO SPLIT THE WINNINGS BETWEEN THE TWO HANDS
    }

    public int compareHands(List<Card> handOne, List<Card> handTwo)
    {
        // SHOULD WE HAVE A NEW DECK THAT ONLY CONTAINS THE FIVE CARDS YOU ARE USING AS YOUR HAND
        if(handValue(handOne) > handValue(handTwo))
            return 1;
        else if(handValue(handOne) < handValue(handTwo))
            return 2;
        else if(handValue(handOne) == 10 && handValue(handTwo) == 10)
        {
            System.out.println("Comparing royal flush");
            tie(handOne, handTwo);
            return 0;
        }
        else if(handValue(handOne) == 9 && handValue(handTwo) == 9)
        {
            System.out.println("Comparing straight flush");
            return straightFlushTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 8 && handValue(handTwo) == 8)
        {
            System.out.println("Comparing four of a kind");
            return fourOfAKindTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 7 && handValue(handTwo) == 7)
        {
            System.out.println("Comparing full house");
            return fullHouseTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 6 && handValue(handTwo) == 6)
        {
            System.out.println("Comparing flush");
            return flushTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 5 && handValue(handTwo) == 5)
        {
            System.out.println("Comparing straight");
            return straightTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 4 && handValue(handTwo) == 4)
        {
            System.out.println("Comparing three of a kind");
            return threeOfAKindTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 3 && handValue(handTwo) == 3)
        {
            System.out.println("Comparing two pair");
            return twoPairTie(handOne, handTwo);
        }
        else if(handValue(handOne) == 2 && handValue(handTwo) == 2)
        {
            System.out.println("Comparing one pair");
            return onePairTie(handOne, handTwo);
        }
        else
        {
            System.out.println("Comparing high card");
            if(highCard(handOne) > highCard(handTwo))
                return 1;
            else if(highCard(handOne) < highCard(handTwo))
                return 2;
            else
                return highCardTie(handOne, handTwo);
        }
    }

    public void printHand(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            System.out.print(hand.get(i).getNumber() + hand.get(i).getSuit() + " ");
        }
        System.out.println();
    }

    public static List<List<Card>> getAllHands() {
        return Arrays.asList(hand1, hand2, hand3, hand4, hand5, hand6);
    }

    public List<Card> getHand1() {return hand1;}
    public List<Card> getHand2() {return hand2;}
    public List<Card> getHand3() {return hand3;}
    public List<Card> getHand4() {return hand4;}
    public List<Card> getHand5() {return hand5;}
    public List<Card> getHand6() {return hand6;}

}
