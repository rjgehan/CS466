package com.example.sevencardstud;

import java.util.*;
public class GamePlay
{
    public Bot bot;
    public List<List<Card>> allCardHands;
    public List<Card> botHand;

    public GamePlay(List<List<Card>> cardHands, List<Card> hand)
    {
        this.allCardHands = cardHands;
        this.botHand = hand;

        bot = new Bot("Bot", botHand, allCardHands);
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

    public boolean aceLowThreeCards(List<Card> hand)
    {
        boolean aceLow = false;
        int sortedCards[] = new int[hand.size() - 2];
        int index = 0;
        for (int i = 2; i < hand.size(); i++) {
            sortedCards[index] = cardNumberValue(hand.get(i).getNumber());
            index++;
        }
        Arrays.sort(sortedCards);

        int count = 0;
        for(int i = 0; i < 3; i++)
        {
            int currentValue = sortedCards[i];
            if(currentValue == 2 || currentValue == 3 || currentValue == 4 || currentValue == 5)
            {
                count++;
            }
        }

        if(sortedCards[2] == 14 && count == 2)
            aceLow = true;
        else if(count == 3)
            aceLow = true;

        return aceLow;
    }

    public boolean aceLowFourCards(List<Card> hand)
    {
        boolean aceLow = false;
        int sortedCards[] = new int[hand.size() - 2];
        int index = 0;
        for (int i = 2; i < hand.size(); i++) {
            sortedCards[index] = cardNumberValue(hand.get(i).getNumber());
            index++;
        }
        Arrays.sort(sortedCards);

        int count = 0;
        for(int i = 0; i < 4; i++)
        {
            int currentValue = sortedCards[i];
            if(currentValue == 2 || currentValue == 3 || currentValue == 4 || currentValue == 5)
            {
                count++;
            }
        }

        if(sortedCards[3] == 14 && count == 3)
            aceLow = true;
        else if(count == 4)
            aceLow = true;

        return aceLow;
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

            if(hand.size() == 5 && sortedCards[2] == 14)
            {
                if(aceLowThreeCards(hand))
                {
                    sortedCards[2] = 1;
                    Arrays.sort(sortedCards);
                }
            }
            else
            {
                if(aceLowFourCards(hand) && sortedCards[3] == 14)
                {
                    sortedCards[3] = 1;
                    Arrays.sort(sortedCards);
                }
            }

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

        if(aceLowFourCards(hand) && sortedCards[3] == 14)
        {
            sortedCards[3] = 1;
            Arrays.sort(sortedCards);
        }

        if(sortedCards[3] - sortedCards[2] != 1)
            return (sortedCards[3] - 1);
        else if(sortedCards[2] - sortedCards[1] != 1)
            return (sortedCards[2] - 1);
        else if(sortedCards[1] - sortedCards[0] != 1)
            return (sortedCards[1] - 1);
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

        if(sortedCards[1] == sortedCards[3])
        {
            int fullHouseValues[] = new int[1];
            fullHouseValues[0] = sortedCards[0];
            return fullHouseValues;
        }
        else if(sortedCards[0] == sortedCards[2])
        {
            int fullHouseValues[] = new int[1];
            fullHouseValues[0] = sortedCards[3];
            return fullHouseValues;
        }
        else
        {
            int fullHouseValues[] = new int[2];
            fullHouseValues[0] = sortedCards[0];
            fullHouseValues[1] = sortedCards[2];
            return fullHouseValues;
        }
    }

    public boolean searchRoyalandStraightFlush(List<List<Card>> cardHands, int value, String suit)
    {
        boolean cardFound = false;

        for(int i = 0; i < cardHands.size(); i++)
        {
            for(int j = 2; j < cardHands.get(i).size(); j++)
            {
                if(cardNumberValue(cardHands.get(i).get(j).getNumber()) == value && cardHands.get(i).get(j).getSuit().equals(suit))
                {
                    cardFound = true;
                    break;
                }
            }
        }
        return cardFound;
    }

    public boolean straightSearch(List<List<Card>> cardHands, int value)
    {
        int count = 0;
        for(int i = 0; i < cardHands.size(); i++)
        {
            for(int j = 2; j < cardHands.get(i).size(); j++)
            {
                if(cardNumberValue(cardHands.get(i).get(j).getNumber()) == value)
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

    public boolean fullHouseSearch(List<List<Card>> cardHands, int[] valueArray)
    {
        boolean isFound = false;

        if (valueArray.length == 1) {
            int value = valueArray[0];
            int count = 0;
            for (int i = 0; i < cardHands.size(); i++)
            {
                for (int j = 2; j < cardHands.get(i).size(); j++)
                {
                    if (cardNumberValue(cardHands.get(i).get(j).getNumber()) == value)
                    {
                        count++;
                    }
                }
            }
            if (count == 4)
                isFound = true;
        }
        else if (valueArray.length == 2)
        {
            int valueOne = valueArray[0];
            int valueTwo = valueArray[1];
            int countOne = 0;
            int countTwo = 0;
            for (int i = 0; i < cardHands.size(); i++)
            {
                for (int j = 2; j < cardHands.get(i).size(); j++)
                {
                    if (cardNumberValue(cardHands.get(i).get(j).getNumber()) == valueOne)
                        countOne++;
                    else if (cardNumberValue(cardHands.get(i).get(j).getNumber()) == valueTwo)
                        countTwo++;
                }
            }
            if (countOne == 4 && countTwo == 4)
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

    public void betting(int foldValue)
    {
        if(foldValue > 8)
            bot.bettingAction = 1;
    }

    public void afterThirdRound()
    {
        int value = shouldFold(botHand);

        if(value < 1)
            bot.isFolded = true;
        else
            betting(value);
    }

    public void afterFourthRound()
    {
        int value = shouldFold(botHand);
        if(value == 10)
        {
            int missingCard = straightMissingValue(botHand);
            String suit = botHand.get(2).getSuit();
            if(searchRoyalandStraightFlush(allCardHands, missingCard, suit))
                value = 6;
        }
        else if(value == 9)
        {
            int missingCard = straightMissingValue(botHand);
            String suit = botHand.get(2).getSuit();
            if(missingCard == 0)
            {
                int missingCardLow = 0;
                int missingCardHigh = 0;
                if(aceLowFourCards(botHand))
                {
                    missingCardLow = 14;
                    missingCardHigh = 6;
                }
                else
                {
                    int sortedCards[] = new int[botHand.size() - 2];
                    int index = 0;
                    for (int i = 2; i < botHand.size(); i++) {
                        sortedCards[index] = cardNumberValue(botHand.get(i).getNumber());
                        index++;
                    }
                    Arrays.sort(sortedCards);

                    missingCardLow = sortedCards[0] - 1;
                    missingCardHigh = sortedCards[3] + 1;
                }

                if(searchRoyalandStraightFlush(allCardHands,missingCardLow, suit) && searchRoyalandStraightFlush(allCardHands, missingCardHigh, suit))
                    value = 6;
            }
            else if(searchRoyalandStraightFlush(allCardHands, missingCard, suit))
                value = 6;
        }
        else if(value == 7)
        {
            int[] missingCards = fullHouseMissingValues(botHand);
            if(fullHouseSearch(allCardHands, missingCards))
                value = 4; // MAYBE A TWO PAIR OR THREE OF A KIND BUT DON'T KNOW
        }
        else if(value == 5)
        {
            int missingCard = straightMissingValue(botHand);
            if(missingCard == 0)
            {
                int missingCardLow = 0;
                int missingCardHigh = 0;
                if (aceLowFourCards(botHand)) {
                    missingCardLow = 14;
                    missingCardHigh = 6;
                } else {
                    int sortedCards[] = new int[botHand.size() - 2];
                    int index = 0;
                    for (int i = 2; i < botHand.size(); i++) {
                        sortedCards[index] = cardNumberValue(botHand.get(i).getNumber());
                        index++;
                    }
                    Arrays.sort(sortedCards);

                    missingCardLow = sortedCards[0] - 1;
                    missingCardHigh = sortedCards[3] + 1;
                }
                if (straightSearch(allCardHands, missingCardLow) && straightSearch(allCardHands, missingCardHigh))
                    value = 1;
            }
            else if(straightSearch(allCardHands, missingCard))
                value = 1;
        }

        if(value < 4)
            bot.isFolded = true;
        else
            betting(value);
    }

    public void botInGame(int round)
    {
        if(round == 3)
            afterThirdRound();
        else if(round == 4)
            afterFourthRound();
    }


    public static void main(String[] args)
    {
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

        String valueHolding = "";
        gp.botInGame(1);
        gp.botInGame(2);
        if(gp.bot.isFolded)
            valueHolding = "True";
        else if(!gp.bot.isFolded)
            valueHolding = "False";

        System.out.println(valueHolding);

        /*
        hand.newRound();
        gp.afterFirstRound(gp.bot1);
        gp.afterFirstRound(gp.bot2);
        gp.afterFirstRound(gp.bot3);
        gp.afterFirstRound(gp.bot4);
        gp.afterFirstRound(gp.bot5);


        System.out.println("Bot 1 Initial");
        for(int i = 0; i < gp.bot1.hand.size(); i++)
            System.out.print(gp.bot1.hand.get(i).getNumber() + gp.bot1.hand.get(i).getSuit() + '\t');

        System.out.println("");

        System.out.println("Bot 2 Initial");
        for(int i = 0; i < gp.bot2.hand.size(); i++)
            System.out.print(gp.bot2.hand.get(i).getNumber() + gp.bot2.hand.get(i).getSuit() + '\t');

        System.out.println("");

        System.out.println("Bot 3 Initial");
        for(int i = 0; i < gp.bot3.hand.size(); i++)
            System.out.print(gp.bot3.hand.get(i).getNumber() + gp.bot3.hand.get(i).getSuit() + '\t');

        System.out.println("");

        System.out.println("Bot 4 Initial");
        for(int i = 0; i < gp.bot4.hand.size(); i++)
            System.out.print(gp.bot4.hand.get(i).getNumber() + gp.bot4.hand.get(i).getSuit() + '\t');

        System.out.println("");

        System.out.println("Bot 5 Initial");
        for(int i = 0; i < gp.bot5.hand.size(); i++)
            System.out.print(gp.bot5.hand.get(i).getNumber() + gp.bot5.hand.get(i).getSuit() + '\t');

        System.out.println("");

        System.out.println("Hand 6 Initial");
        for(int i = 0; i < hand.hand6.size(); i++)
            System.out.print(hand.hand6.get(i).getNumber() + hand.hand6.get(i).getSuit() + '\t');

        System.out.println("");

         */
    }


}

