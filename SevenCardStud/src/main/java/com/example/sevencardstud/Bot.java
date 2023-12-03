package com.example.sevencardstud;

import java.util.*;
public class Bot
{
    public String botName;
    public List<Card> hand;
    public List<List<Card>> cardHands;
    public int botMoney;
    public int wins;

    public boolean isFolded;
    public int bettingAction;

    public Bot(String name, List<Card> hand, List<List<Card>> cardHands)
    {
        this.botName = name;
        this.hand = hand;
        this.cardHands = cardHands;
        this.botMoney = 50;
        this.wins = 0;
        this.isFolded = false;
        this.bettingAction = 0;
    }

    public String getBotName()
    {
        return botName;
    }

    public List<Card> getHand()
    {
        return hand;
    }

    public int getBotMoney()
    {
        return botMoney;
    }

    public int getWins()
    {
        return wins;
    }

    public void increaseWins()
    {
        wins++;
    }

    public boolean getIsFolded()
    {
        return isFolded;
    }

    public int getBettingAction()
    {
        return bettingAction;
    }
}

