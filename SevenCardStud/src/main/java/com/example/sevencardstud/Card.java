package com.example.sevencardstud;

public class Card
{
    private final String suit;
    private final String number;

    public Card(String suit, String number)
    {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getNumber()
    {
        return number;
    }

    public int compare(Card secondCard)
    {
        int valueOne = 0;
        int valueTwo = 0;

        if(this.number.equals("A"))
            valueOne = 14;
        else if(this.number.equals("K"))
            valueOne = 13;
        else if(this.number.equals("Q"))
            valueOne = 12;
        else if(this.number.equals("J"))
            valueOne= 11;
        else
            valueOne = Integer.parseInt(this.number);

        if(secondCard.getNumber().equals("A"))
            valueTwo = 14;
        else if(secondCard.getNumber().equals("K"))
            valueTwo = 13;
        else if(secondCard.getNumber().equals("Q"))
            valueTwo = 12;
        else if(secondCard.getNumber().equals("J"))
            valueTwo= 11;
        else
            valueTwo = Integer.parseInt(secondCard.getNumber());

        return Integer.compare(valueOne, valueTwo);
    }
}
