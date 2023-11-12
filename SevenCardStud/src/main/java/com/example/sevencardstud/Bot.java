package com.example.sevencardstud;

public class Bot
{
    private String botName;
    private Hand hand;
    private int botMoney;
    private int wins;

    public Bot(String name, Hand hand)
    {
        this.botName = name;
        this.hand = hand;
        this.botMoney = 50;
        this.wins = 0;
    }

    public String getBotName()
    {
        return botName;
    }

    public Hand getHand()
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
}
