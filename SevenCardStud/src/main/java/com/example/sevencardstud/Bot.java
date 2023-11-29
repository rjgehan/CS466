package com.example.sevencardstud;

import java.util.*;
public class Bot
{
    public String botName;
    public List<Card> hand;
    public int botMoney;
    public int wins;

    public boolean isFolded;

    public Bot(String name, List<Card> hand)
    {
        this.botName = name;
        this.hand = hand;
        this.botMoney = 50;
        this.wins = 0;
        this.isFolded = false;
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

    public boolean getIsFolded(){return isFolded;}
}
