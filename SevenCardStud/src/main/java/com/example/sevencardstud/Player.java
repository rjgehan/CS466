package com.example.sevencardstud;

import java.util.List;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Player {
    public int betAmount;
    public boolean isFolded;
    public String gameResult;

    public static List<Card> currentHand;

    public Player(List<Card> givenHand) {
        betAmount = 0;
        isFolded = false;
        gameResult = "";
        currentHand = givenHand;
    }
}
