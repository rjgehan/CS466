package com.example.sevencardstud;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

public class Game {
    public Hand hands;
    public List<List<Card>> foldedHands;
    public String result;
    public int winner;
    private int currentBet;


    public Game() {
        hands = new Hand();

        foldedHands = new ArrayList<>();

        result = "";
        winner = -1;
        currentBet = 0;

        //bringIn(hands);


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

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public void updateCurrentBet(int update) {
        this.currentBet += update;
    }

    // Game Logic
    public int findPlayerWithSmallestCard(List<List<Card>> cardHands) {
        int smallestCardValue = Integer.MAX_VALUE;
        int smallestCardIndex = -1;

        for (int i = 0; i < cardHands.size(); i++) {
            List<Card> hand = cardHands.get(i);

            // Check if the hand has at least three cards
            if (hand.size() >= 3) {
                Card thirdCard = hand.get(2);
                int thirdCardValue = getCardValue(thirdCard);

                // Update smallest card information
                if (thirdCardValue < smallestCardValue) {
                    smallestCardValue = thirdCardValue;
                    smallestCardIndex = i;
                }
            }
        }
        return smallestCardIndex;
    }

    private int getCardValue(Card card) {
        if ("A".equals(card.getNumber())) {
            return 14;
        } else if ("K".equals(card.getNumber())) {
            return 13;
        } else if ("Q".equals(card.getNumber())) {
            return 12;
        } else if ("J".equals(card.getNumber())) {
            return 11;
        } else {
            return Integer.parseInt(card.getNumber());
        }
    }

    public String gameResult(List<Card> hand) {
        Hand handAnalyzer = new Hand();
        int handValue = handAnalyzer.handValue(hand);
        switch (handValue) {
            case 10:
                result = "Royal Flush";
                break;
            case 9:
                result = "Straight Flush";
                break;
            case 8:
                result = "Four of a Kind";
                break;
            case 7:
                result = "Full House";
                break;
            case 6:
                result = "Flush";
                break;
            case 5:
                result = "Straight";
                break;
            case 4:
                result = "Three of a Kind";
                break;
            case 3:
                result = "Two Pair";
                break;
            case 2:
                result = "One Pair";
                break;
            default:
                result = "High Card";
                break;
        }
        return result;
    }

    public int determineWinner(List<List<Card>> cardHands) {
        int winningPlayer = -1; // Initialize to an invalid value
        for (int i = 0; i < cardHands.size(); i++) {

            List<Card> currentHand = cardHands.get(i);
            if (!foldedHands.contains(currentHand) ) {
                for (int j = i + 1; j < cardHands.size(); j++) {
                    List<Card> otherHand = cardHands.get(j);

                    int result = hands.compareHands(currentHand, otherHand);

                    if (result == 1) {
                        winningPlayer = i + 1; // Player index is 0-based, so add 1
                    } else if (result == 2) {
                        winningPlayer = j + 1; // Player index is 0-based, so add 1
                    } else if (result == 0) {
                        // Handle tie-breaking logic
                    }
                }
            }
        }
        return winningPlayer;
    }
}

