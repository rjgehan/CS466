package com.example.sevencardstud;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

public class Game {
    public Hand hands;
    public List<List<Card>> gameHands = new ArrayList<>();



    public Game() {
        hands = new Hand();
        gameHands.add(Hand.hand1);
        gameHands.add(Hand.hand2);
        gameHands.add(Hand.hand3);
        gameHands.add(Hand.hand4);
        gameHands.add(Hand.hand5);

        //Third Street
        playRound();
    }

    public Hand getGameHand() {
        return hands;
    }

    public void playRound() {
        hands.newRound();
    }

    public void playTurn() {
        hands.newTurn();
    }

    public void startNewGame() {
        hands.initializeHands();
    }
}
