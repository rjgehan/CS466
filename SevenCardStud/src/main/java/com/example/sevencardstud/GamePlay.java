package com.example.sevencardstud;

import java.util.*;
public class GamePlay
{
    public static Bot bot1;
    public static Bot bot2;
    public static Bot bot3;
    public static Bot bot4;
    public static Bot bot5;
    public static Hand hand;

    public GamePlay()
    {
        List<Card> bot1Hand = new ArrayList<>();
        List<Card> bot2Hand = new ArrayList<>();
        List<Card> bot3Hand = new ArrayList<>();
        List<Card> bot4Hand = new ArrayList<>();
        List<Card> bot5Hand = new ArrayList<>();

        bot1 = new Bot("Bot 1", bot1Hand);
        bot2 = new Bot("Bot 2", bot2Hand);
        bot3 = new Bot("Bot 3", bot3Hand);
        bot4 = new Bot("Bot 4", bot4Hand);
        bot5 = new Bot("Bot 5", bot5Hand);

        hand = new Hand();
        bot1Hand.addAll(hand.hand1);
        bot2Hand.addAll(hand.hand2);
        bot3Hand.addAll(hand.hand3);
        bot4Hand.addAll(hand.hand4);
        bot5Hand.addAll(hand.hand5);
    }

    public int cardNumberValue(String number)
    {
        // fix this for ace high or low
        if(number.equals("A"))
            return 14;
        else if(number.equals("K"))
            return 13;
        else if(number.equals("Q"))
            return 12;
        else if(number.equals("J"))
            return 11;
        else
            return Integer.parseInt(number);
    }

    public boolean valueOne(List<Card> hand)
    {
        int max = 0;
        for(int i = 2; i < hand.size(); i++)
        {
            if(cardNumberValue(hand.get(i).getNumber()) > max)
                max = cardNumberValue(hand.get(i).getNumber());
        }

        if(max >= 8)
            return true;
        else
            return false;
    }

    public boolean valueTwo(List<Card> hand)
    {
        for (int i = 2; i < hand.size(); i++)
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

    public boolean valueThree(List<Card> hand)
    {
        int count = 0;
        for (int i = 2; i < hand.size(); i++)
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

    public boolean valueFour(List<Card> hand)
    {
        for (int i = 2; i < hand.size(); i++)
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

    public boolean valueFive(List<Card> hand)
    {
        if(hand.size() == 5 || hand.size() == 6) {
            int sortedCards[] = new int[hand.size() - 2];
            int index = 0;
            for (int i = 2; i < hand.size(); i++) {
                sortedCards[index] = cardNumberValue(hand.get(i).getNumber());
                index++;
            }
            Arrays.sort(sortedCards);

            for (int i = 0; i < sortedCards.length - 1; i++)
            {
                if (sortedCards[i] == sortedCards[i + 1])
                    return false;
            }

            if (sortedCards[sortedCards.length - 1] - sortedCards[0] <= 4)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public boolean valueSix(List<Card> hand)
    {
        boolean isFlush = true;
        for (int i = 2; i < hand.size() - 1; i++)
        {
            if(!hand.get(i).getSuit().equals(hand.get(i+1).getSuit()))
            {
                isFlush = false;
                break;
            }
        }
        return isFlush;
    }

    public boolean valueSeven(List<Card> hand)
    {
        if(valueThree(hand) || valueFour(hand))
            return true;
        else
            return false;
    }

    public boolean valueEight(List<Card> hand)
    {
        boolean isFourOfKind = true;
        if(hand.size() == 5)
            isFourOfKind = false;
        else if(hand.size() == 6)
        {
            for (int i = 2; i < hand.size() - 1; i++)
            {
                if(!hand.get(i).getNumber().equals(hand.get(i+1).getNumber()))
                {
                    isFourOfKind = false;
                    break;
                }
            }
        }
        else
            isFourOfKind = false;

        return isFourOfKind;
    }

    public boolean valueNine(List<Card> hand)
    {
        if(valueFive(hand) && valueSix(hand))
            return true;
        else
            return false;
    }

    public boolean valueTen(List<Card> hand)
    {
        if(valueSix(hand))
        {
            if(!valueTwo(hand))
            {
                int sum = 0;
                for(int i = 2; i < hand.size(); i++)
                {
                    sum += cardNumberValue(hand.get(i).getNumber());
                }
                if(hand.size() == 5)
                {
                    if(sum >= 33)
                        return true;
                    else
                        return false;
                }

                else if(hand.size() == 6)
                {
                    if(sum >= 46)
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
        else
            return false;
    }

    /*
    public int royalFlushMissingValue(List<Card> hand)
    {
        int sum = 0;
        for(int i = 2; i < hand.size(); i++)
        {
            sum += cardNumberValue(hand.get(i).getNumber());
        }

        if(sum == 46)
            return 14;
        else if(sum == 47)
            return 13;
        else if(sum == 48)
            return 12;
        else if(sum == 49)
            return 11;
        else if(sum == 50)
            return 10;
        else
            return 0;
    }

     */

    public int straightMissingValue(List<Card> hand)
    {
        int sortedCards[] = new int[hand.size() - 2];
        int index = 0;
        for (int i = 2; i < hand.size(); i++) {
            sortedCards[index] = cardNumberValue(hand.get(i).getNumber());
            index++;
        }
        Arrays.sort(sortedCards);

        if(sortedCards[6] - sortedCards[5] != 1)
            return (sortedCards[6] - 1);
        else if(sortedCards[5] - sortedCards[4] != 1)
            return (sortedCards[5] - 1);
        else if(sortedCards[4] - sortedCards[3] != 1)
            return (sortedCards[4] - 1);
        else if(sortedCards[3] - sortedCards[2] != 1)
            return (sortedCards[3] - 1);
        else // IF ZERO IS RETURNED THAT MEANS THE STRAIGHT CAN BE A HIGH OR LOW
            return 0;
    }

    public int[] fullHouseMissingValues(List<Card> hand)
    {
        int sortedCards[] = new int[hand.size() - 2];
        int index = 0;
        for (int i = 2; i < hand.size(); i++) {
            sortedCards[index] = cardNumberValue(hand.get(i).getNumber());
            index++;
        }
        Arrays.sort(sortedCards);

        if(sortedCards[2] == sortedCards[4])
        {
            int fullHouseValues[] = new int[1];
            fullHouseValues[0] = sortedCards[5];
            return fullHouseValues;
        }
        else if(sortedCards[3] == sortedCards[5])
        {
            int fullHouseValues[] = new int[1];
            fullHouseValues[0] = sortedCards[2];
            return fullHouseValues;
        }
        else
        {
            int fullHouseValues[] = new int[2];
            fullHouseValues[0] = sortedCards[2];
            fullHouseValues[1] = sortedCards[4];
            return fullHouseValues;
        }
    }

    public boolean searchRoyalandStraightFlush(int value, String suit)
    {
        boolean cardFound = false;
       // List<Card> handArray[] = new List<Card>[6];
       // handArray = {bot1.hand, bot2.hand, bot3.hand, bot4.hand, bot5.hand};

        for(int i = 1; i <= 6; i++)
        {
            List<Card> currentHand = null;
            if(i == 1)
                currentHand = bot1.hand;
            else if(i == 2)
                currentHand = bot2.hand;
            else if(i == 3)
                currentHand = bot3.hand;
            else if(i == 4)
                currentHand = bot4.hand;
            else if(i == 5)
                currentHand = bot5.hand;
            else if(i == 6)
                currentHand = hand.hand6;
            for(int j = 2; j <= 5; i++)
            {
                if(cardNumberValue(currentHand.get(j).getNumber()) == value && currentHand.get(j).getSuit().equals(suit))
                {
                    cardFound = true;
                    break;
                }
            }
        }
        return cardFound;
    }

    public boolean straightSearch(int value)
    {
        int count = 0;
        for(int i = 1; i <= 6; i++)
        {
            List<Card> currentHand = null;
            if(i == 1)
                currentHand = bot1.hand;
            else if(i == 2)
                currentHand = bot2.hand;
            else if(i == 3)
                currentHand = bot3.hand;
            else if(i == 4)
                currentHand = bot4.hand;
            else if(i == 5)
                currentHand = bot5.hand;
            else if(i == 6)
                currentHand = hand.hand6;
            for(int j = 2; j <= 5; i++)
            {
                if(cardNumberValue(currentHand.get(j).getNumber()) == value)
                {
                    count++;
                }
            }
        }
        if(count == 4)
            return true;
        else
            return false;
    }

    public boolean fullHouseSearch(int[] valueArray)
    {
        boolean isFound = false;

        if (valueArray.length == 1) {
            int value = valueArray[0];
            int count = 0;
            for (int i = 1; i <= 6; i++) {
                List<Card> currentHand = null;
                if (i == 1)
                    currentHand = bot1.hand;
                else if (i == 2)
                    currentHand = bot2.hand;
                else if (i == 3)
                    currentHand = bot3.hand;
                else if (i == 4)
                    currentHand = bot4.hand;
                else if (i == 5)
                    currentHand = bot5.hand;
                else if (i == 6)
                    currentHand = hand.hand6;
                for (int j = 2; j <= 5; i++) {
                    if (cardNumberValue(currentHand.get(j).getNumber()) == value) {
                        count++;
                    }
                }
            }
            if (count == 3)
                isFound = true;
        }
        else if (valueArray.length == 2)
        {
            int valueOne = valueArray[0];
            int valueTwo = valueArray[1];
            int countOne = 0;
            int countTwo = 0;
            for (int i = 1; i <= 6; i++)
            {
                List<Card> currentHand = null;
                if (i == 1)
                    currentHand = bot1.hand;
                else if (i == 2)
                    currentHand = bot2.hand;
                else if (i == 3)
                    currentHand = bot3.hand;
                else if (i == 4)
                    currentHand = bot4.hand;
                else if (i == 5)
                    currentHand = bot5.hand;
                else if (i == 6)
                    currentHand = hand.hand6;
                for (int j = 2; j <= 5; i++)
                {
                    if (cardNumberValue(currentHand.get(j).getNumber()) == valueOne)
                        countOne++;
                    else if (cardNumberValue(currentHand.get(j).getNumber()) == valueTwo)
                        countTwo++;
                }
            }
            if (countOne == 2 && countTwo == 2)
                isFound = true;
        }
        return isFound;
    }

    public int shouldFold(List<Card> hand)
    {
        int value = 0;

        if(valueTen(hand))
            value = 10;
        else if(valueNine(hand))
            value = 9;
        else if(valueEight(hand))
            value = 8;
        else if(valueSeven(hand))
            value = 7;
        else if(valueSix(hand))
            value = 6;
        else if(valueFive(hand))
            value = 5;
        else if(valueFour(hand))
            value = 4;
        else if(valueThree(hand))
            value = 3;
        else if(valueTwo(hand))
            value = 2;
        else if(valueOne(hand))
            value = 1;
        else
            return value;

        return value;

    }

    public void afterFirstRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
            bot1.hand.add(hand.hand1.get(3));
        else if(bot == bot2)
            bot2.hand.add(hand.hand2.get(3));
        else if(bot == bot3)
            bot3.hand.add(hand.hand3.get(3));
        else if(bot == bot4)
            bot4.hand.add(hand.hand4.get(3));
        else if(bot == bot5)
            bot5.hand.add(hand.hand5.get(3));
    }

    public void afterSecondRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
            bot1.hand.add(hand.hand1.get(4));
        else if(bot == bot2)
            bot2.hand.add(hand.hand2.get(4));
        else if(bot == bot3)
            bot3.hand.add(hand.hand3.get(4));
        else if(bot == bot4)
            bot4.hand.add(hand.hand4.get(4));
        else if(bot == bot5)
            bot5.hand.add(hand.hand5.get(4));
    }

    public void afterThirdRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
        {
            int value = shouldFold(bot1.hand);
            if(value >= 1)
            {
                bot1.hand.add(hand.hand1.get(5));
            }

            else
                bot1.isFolded = true;
        }
        else if(bot == bot2)
        {
            int value = shouldFold(bot2.hand);
            if(value >= 1)
            {
                bot2.hand.add(hand.hand2.get(5));
            }

            else
                bot2.isFolded = true;
        }
        else if(bot == bot3)
        {
            int value = shouldFold(bot3.hand);
            if(value >= 1)
            {
                bot3.hand.add(hand.hand3.get(5));
            }

            else
                bot3.isFolded = true;
        }
        else if(bot == bot4)
        {
            int value = shouldFold(bot4.hand);
            if(value >= 1)
            {
                bot4.hand.add(hand.hand4.get(5));
            }

            else
                bot4.isFolded = true;
        }
        else if(bot == bot5)
        {
            int value = shouldFold(bot5.hand);
            if(value >= 1)
            {
                bot5.hand.add(hand.hand5.get(5));
            }

            else
                bot5.isFolded = true;
        }
    }

    public void afterFourthRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
        {
            int value = shouldFold(bot1.hand);
            if(value == 10 || value == 9)
            {
                int missingCard = straightMissingValue(bot1.hand);
                String suit = bot1.hand.get(2).getSuit();
                if(searchRoyalandStraightFlush(missingCard, suit))
                    value = 6;
            }
            else if(value == 7)
            {
                int[] missingCards = fullHouseMissingValues(bot1.hand);
                if(fullHouseSearch(missingCards))
                    value = 4; // MAY BE A TWO PAIR OR THREE OF A KIND BUT DON'T KNOW
            }
            else if(value == 5)
            {
                int missingCard = straightMissingValue(bot1.hand);
                if(straightSearch(missingCard))
                    value = 1;
            }

            if(value >= 4)
            {
                bot1.hand.add(hand.hand1.get(6));
            }

            else
                bot1.isFolded = true;
        }
        else if(bot == bot2)
        {
            int value = shouldFold(bot2.hand);
            if(value == 10 || value == 9)
            {
                int missingCard = straightMissingValue(bot2.hand);
                String suit = bot2.hand.get(2).getSuit();
                if(searchRoyalandStraightFlush(missingCard, suit))
                    value = 6;
            }
            else if(value == 7)
            {
                int[] missingCards = fullHouseMissingValues(bot2.hand);
                if(fullHouseSearch(missingCards))
                    value = 4; // MAY BE A TWO PAIR OR THREE OF A KIND BUT DON'T KNOW
            }
            else if(value == 5)
            {
                int missingCard = straightMissingValue(bot2.hand);
                if(straightSearch(missingCard))
                    value = 1;
            }

            if(value >= 4)
            {
                bot2.hand.add(hand.hand2.get(6));
            }

            else
                bot2.isFolded = true;
        }
        else if(bot == bot3)
        {
            int value = shouldFold(bot3.hand);
            if(value == 10 || value == 9)
            {
                int missingCard = straightMissingValue(bot3.hand);
                String suit = bot3.hand.get(2).getSuit();
                if(searchRoyalandStraightFlush(missingCard, suit))
                    value = 6;
            }
            else if(value == 7)
            {
                int[] missingCards = fullHouseMissingValues(bot3.hand);
                if(fullHouseSearch(missingCards))
                    value = 4; // MAY BE A TWO PAIR OR THREE OF A KIND BUT DON'T KNOW
            }
            else if(value == 5)
            {
                int missingCard = straightMissingValue(bot3.hand);
                if(straightSearch(missingCard))
                    value = 1;
            }

            if(value >= 4)
            {
                bot3.hand.add(hand.hand3.get(6));
            }

            else
                bot3.isFolded = true;
        }
        else if(bot == bot4)
        {
            int value = shouldFold(bot4.hand);
            if(value == 10 || value == 9)
            {
                int missingCard = straightMissingValue(bot4.hand);
                String suit = bot4.hand.get(2).getSuit();
                if(searchRoyalandStraightFlush(missingCard, suit))
                    value = 6;
            }
            else if(value == 7)
            {
                int[] missingCards = fullHouseMissingValues(bot4.hand);
                if(fullHouseSearch(missingCards))
                    value = 4; // MAY BE A TWO PAIR OR THREE OF A KIND BUT DON'T KNOW
            }
            else if(value == 5)
            {
                int missingCard = straightMissingValue(bot4.hand);
                if(straightSearch(missingCard))
                    value = 1;
            }

            if(value >= 4)
            {
                bot4.hand.add(hand.hand4.get(6));
            }

            else
                bot4.isFolded = true;
        }
        else if(bot == bot5)
        {
            int value = shouldFold(bot5.hand);
            if(value == 10 || value == 9)
            {
                int missingCard = straightMissingValue(bot5.hand);
                String suit = bot5.hand.get(2).getSuit();
                if(searchRoyalandStraightFlush(missingCard, suit))
                    value = 6;
            }
            else if(value == 7)
            {
                int[] missingCards = fullHouseMissingValues(bot5.hand);
                if(fullHouseSearch(missingCards))
                    value = 4; // MAY BE A TWO PAIR OR THREE OF A KIND BUT DON'T KNOW
            }
            else if(value == 5)
            {
                int missingCard = straightMissingValue(bot5.hand);
                if(straightSearch(missingCard))
                    value = 1;
            }

            if(value >= 4)
            {
                bot5.hand.add(hand.hand5.get(6));
            }

            else
                bot5.isFolded = true;
        }
    }
}

