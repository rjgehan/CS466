package com.example.sevencardstud;

public class Game {
    private Hand gameHand;

    public Game() {
        gameHand = new Hand();
    }

    public Hand getGameHand() {
        return gameHand;
    }

    public void playRound() {
        gameHand.newRound();
    }

    public void playTurn() {
        gameHand.newTurn();
    }

    public void startNewGame() {
        gameHand.initializeHands();
    }
}
