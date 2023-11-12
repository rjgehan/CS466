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
}
