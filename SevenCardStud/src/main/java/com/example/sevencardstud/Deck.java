package com.example.sevencardstud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private List<Card> cardsDeck;

    public Deck() {
        cardsDeck = new ArrayList<>();
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits)
        {
            for (String rank : ranks)
            {
                this.cardsDeck.add(new Card(suit, rank));
            }
        }
        this.shuffleDeck();
    }

    public List<Card> getCards()
    {
        return cardsDeck;
    }

    public void shuffleDeck()
    {
        Collections.shuffle(this.cardsDeck);
    }

    public Card drawCard()
    {
        if (cardsDeck.isEmpty())
        {
            return null;
        }
        Card card = this.cardsDeck.get(cardsDeck.size() - 1);
        this.cardsDeck.remove(cardsDeck.size() - 1);
        return card;
    }
}
