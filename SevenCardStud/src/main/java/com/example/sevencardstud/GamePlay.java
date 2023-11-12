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

    public int shouldFold(List<Card> hand)
    {
        int shouldFoldLevel = 0;
        // don't fold if there are only two, three, or four cards in the deck
        if(hand.size() == 2 || hand.size() == 3)
            shouldFoldLevel = 0;
        else if(hand.size() == 4)
        {
            int thirdValue = cardNumberValue(hand.get(2).getNumber());
            int fourthValue = cardNumberValue(hand.get(3).getNumber());
            if(thirdValue == fourthValue)
                shouldFoldLevel = 0;
            else if(hand.get(2).getSuit().equals((hand.get(3).getSuit())))
                shouldFoldLevel = 0;
            else if(thirdValue + 1 == fourthValue || thirdValue - 1 == fourthValue)
                shouldFoldLevel = 0;
            else
                shouldFoldLevel = 2;
        }
        else if(hand.size() == 5)
        {
            int thirdValue = cardNumberValue(hand.get(2).getNumber());
            int fourthValue = cardNumberValue(hand.get(3).getNumber());
            int fifthValue = cardNumberValue(hand.get(4).getNumber());
            String thirdSuit = hand.get(2).getSuit();
            String fourthSuit = hand.get(3).getSuit();
            String fifthSuit = hand.get(4).getSuit();
            int sortedCards[] = new int[3];
            sortedCards[0] = thirdValue;
            sortedCards[1] = fourthValue;
            sortedCards[2] = fifthValue;
            Arrays.sort(sortedCards);
            if(thirdValue == fourthValue && fourthValue == fifthValue)
                shouldFoldLevel = 0;
            else if(thirdValue == fourthValue || thirdValue == fifthValue || fourthValue == fifthValue)
                shouldFoldLevel = 1;
            else if(thirdSuit.equals(fourthSuit) && fourthSuit.equals(fifthSuit))
                shouldFoldLevel = 0;
            else if(thirdSuit.equals(fourthSuit) || thirdSuit.equals(fifthSuit) || fourthSuit.equals(fifthSuit))
                shouldFoldLevel = 1;
            else if(sortedCards[2] - 1 == sortedCards[1] && sortedCards[1] - 1 == sortedCards[0])
                shouldFoldLevel = 0;
            else if(sortedCards[2] - 1 == sortedCards[1] || sortedCards[1] - 1 == sortedCards[0])
                shouldFoldLevel = 1;
            else shouldFoldLevel = 2;
        }

        else if(hand.size() == 6)
        {
            int thirdValue = cardNumberValue(hand.get(2).getNumber());
            int fourthValue = cardNumberValue(hand.get(3).getNumber());
            int fifthValue = cardNumberValue(hand.get(4).getNumber());
            int sixthValue = cardNumberValue(hand.get(5).getNumber());
            String thirdSuit = hand.get(2).getSuit();
            String fourthSuit = hand.get(3).getSuit();
            String fifthSuit = hand.get(4).getSuit();
            String sixthSuit = hand.get(5).getSuit();
            int sortedCards[] = new int[4];
            sortedCards[0] = thirdValue;
            sortedCards[1] = fourthValue;
            sortedCards[2] = fifthValue;
            sortedCards[3] = sixthValue;
            Arrays.sort(sortedCards);
            if(thirdValue == fourthValue && fourthValue == fifthValue && fifthValue == sixthValue)
                shouldFoldLevel = 0;
            else if(thirdValue == fourthValue && fourthValue == fifthValue)
                shouldFoldLevel = 1;
            else if(thirdValue == fourthValue || thirdValue == fifthValue || thirdValue == sixthValue || fourthValue == fifthValue || fourthValue == sixthValue || fifthValue == sixthValue)
                shouldFoldLevel = 1;
            else if(thirdSuit.equals(fourthSuit) && fourthSuit.equals(fifthSuit) && fifthSuit.equals(sixthSuit))
                shouldFoldLevel = 0;
            else if(thirdSuit.equals(fourthSuit) || thirdSuit.equals(fifthSuit) || thirdSuit.equals(sixthSuit) || fourthSuit.equals(fifthSuit) || fourthSuit.equals(sixthSuit) || fifthSuit.equals(sixthSuit))
                shouldFoldLevel = 1;
            else if(sortedCards[3] - 1 == sortedCards[2] && sortedCards[2] - 1 == sortedCards[1] && sortedCards[1] - 1 == sortedCards[0])
                shouldFoldLevel = 0;
            else shouldFoldLevel = 2;
        }

        return shouldFoldLevel;
    }

    public void afterFirstRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
            bot1.hand.add(hand.hand1.get(2));
        else if(bot == bot2)
            bot2.hand.add(hand.hand2.get(2));
        else if(bot == bot3)
            bot3.hand.add(hand.hand3.get(2));
        else if(bot == bot4)
            bot4.hand.add(hand.hand4.get(2));
        else if(bot == bot5)
            bot5.hand.add(hand.hand5.get(2));
    }

    public void afterSecondRound(Bot bot)
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

    public void afterThirdRound(Bot bot)
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

    public void afterFourthRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
            bot1.hand.add(hand.hand1.get(5));
        else if(bot == bot2)
            bot2.hand.add(hand.hand2.get(5));
        else if(bot == bot3)
            bot3.hand.add(hand.hand3.get(5));
        else if(bot == bot4)
            bot4.hand.add(hand.hand4.get(5));
        else if(bot == bot5)
            bot5.hand.add(hand.hand5.get(5));
    }

    public void afterFifthRound(Bot bot)
    {
        hand.newRound();
        if(bot == bot1)
            bot1.hand.add(hand.hand1.get(6));
        else if(bot == bot2)
            bot2.hand.add(hand.hand2.get(6));
        else if(bot == bot3)
            bot3.hand.add(hand.hand3.get(6));
        else if(bot == bot4)
            bot4.hand.add(hand.hand4.get(6));
        else if(bot == bot5)
            bot5.hand.add(hand.hand5.get(6));
    }
}
