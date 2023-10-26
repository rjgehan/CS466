package com.example.sevencardstud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

@WebServlet(name = "newGameServlet", value = "/new-game-servlet")
public class NewGameServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // Check if deck already exists in session
        Deck deck = (Deck) session.getAttribute("deck");
        if (deck == null) {
            deck = new Deck();
            session.setAttribute("deck", deck);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");

        // Include the CSS for the cards in the head of your HTML
        out.println("<head>");
        out.println("<style>");
        // add css here
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        // Add a shuffle button
        out.println("<form method='post'>");
        out.println("<input type='submit' value='Shuffle Deck' name='shuffle'>");
        out.println("</form>");

        String contextPath = request.getContextPath();

        for (Card card : deck.getCards()) {
            String imageName = "card" + capitalizeFirstLetter(card.getSuit()) + capitalizeFirstLetter(card.getNumber()) + ".png";
            out.println("<img src='" + contextPath + "/images/PNG/Cards/" + imageName + "' alt='" + card.getNumber() + " of " + card.getSuit() + "'>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Deck deck = (Deck) session.getAttribute("deck");

        String shuffleAction = request.getParameter("shuffle");
        if (shuffleAction != null && shuffleAction.equals("Shuffle Deck") && deck != null) {
            deck.shuffleDeck();
        }

        // Redirect back to doGet
        response.sendRedirect(request.getContextPath() + "/new-game-servlet");
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

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
}

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

public class Hand {
    private static List<Card> hand1;
    private static List<Card> hand2;
    private static List<Card> hand3;
    private static List<Card> hand4;
    private static List<Card> hand5;
    private static List<Card> hand6;
    private static List<Card> testHand;
    private Deck newDeck;

    public Hand() {
        hand1 = new ArrayList<>();
        hand2 = new ArrayList<>();
        hand3 = new ArrayList<>();
        hand4 = new ArrayList<>();
        hand5 = new ArrayList<>();
        hand6 = new ArrayList<>();
        testHand = new ArrayList<>();
        newDeck = new Deck();
        newDeck.getCards();
        for (int i = 0; i < 2; i++) {
            hand1.add(newDeck.drawCard());
            hand2.add(newDeck.drawCard());
            hand3.add(newDeck.drawCard());
            hand4.add(newDeck.drawCard());
            hand5.add(newDeck.drawCard());
            hand6.add(newDeck.drawCard());
        }

        Card cardOne = new Card("Hearts", "2");
        Card cardTwo = new Card("Clubs", "3");
        Card cardThree = new Card("Diamonds", "5");
        Card cardFour = new Card("Spades", "4");
        Card cardFive = new Card("Diamonds", "J");
        Card cardSix = new Card("Hearts", "6");
        Card cardSeven = new Card("Diamonds", "A");
        testHand.add(cardOne);
        testHand.add(cardTwo);
        testHand.add(cardThree);
        testHand.add(cardFour);
        testHand.add(cardFive);
        testHand.add(cardSix);
        testHand.add(cardSeven);
    }

    public void newRound() {
        hand1.add(newDeck.drawCard());
        hand2.add(newDeck.drawCard());
        hand3.add(newDeck.drawCard());
        hand4.add(newDeck.drawCard());
        hand5.add(newDeck.drawCard());
        hand6.add(newDeck.drawCard());
    }

    public int getSize(List<Card> hand) {
        return hand.size();
    }

    /*
    public int numberStringValue(String cardNumber)
    {
        if(cardNumber.equals("A"))
            return 14;
        else if(cardNumber.equals("K"))
            return 13;
        else if(cardNumber.equals("Q"))
            return 12;
        else if(cardNumber.equals("J"))
            return 11;
        else
            return Integer.parseInt(cardNumber);
    }

     */

    public int[] sort(List<Card> hand) {
        int valueArray[] = new int[hand.size()];

        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getNumber().equals("A"))
                valueArray[i] = 14;
            else if (hand.get(i).getNumber().equals("K"))
                valueArray[i] = 13;
            else if (hand.get(i).getNumber().equals("Q"))
                valueArray[i] = 12;
            else if (hand.get(i).getNumber().equals("J"))
                valueArray[i] = 11;
            else
                valueArray[i] = Integer.parseInt(hand.get(i).getNumber());
        }

        Arrays.sort(valueArray);
        return valueArray;
    }

    public int highCard(List<Card> hand) {
        int max = 0;
        int value;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getNumber().equals("A"))
                value = 14;
            else if (hand.get(i).getNumber().equals("K"))
                value = 13;
            else if (hand.get(i).getNumber().equals("Q"))
                value = 12;
            else if (hand.get(i).getNumber().equals("J"))
                value = 11;
            else
                value = Integer.parseInt(hand.get(i).getNumber());

            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public boolean onePair(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int count = 1;
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    count++;
            }

            if(count == 2)
                return true;
        }

        return false;
    }

    public boolean twoPair(List<Card> hand)
    {
        int count = 0;
        for (int i = 0; i < hand.size(); i++)
        {
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    count++;
            }
        }

        if (count == 2)
            return true;
        else
            return false;
    }

    public boolean threeOfaKind(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int individualCardCount = 1;
            for (int j = i + 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    individualCardCount++;
            }

            if (individualCardCount == 3)
                return true;
        }

        return false;
    }

    public boolean straight(List<Card> hand)
    {
        // NEEDS TO BE FIXED TO COUNT ACE AS HIGH OR LOW CARD
        if (hand.size() < 5)
            return false;
        else
        {
            int sortedCards[] = sort(hand);
            int count = 1;

            for (int i = 0; i < hand.size() - 1; i++)
            {
                if (sortedCards[i] + 1 == sortedCards[i + 1])
                {
                    count++;
                    if (count == 5)
                        break;
                }
                else
                    count = 1;
            }

            if (count < 5)
                return false;
            else
                return true;
        }
    }

    public boolean flush(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int sameSuitCount = 1;
            for (int j = 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getSuit()))
                    sameSuitCount++;
            }

            if(sameSuitCount == 5)
                return true;
        }

        return false;
    }

    public boolean fullHouse(List<Card> hand)
    {
        if(threeOfaKind(hand))
        {
            List<Card> duplicateHand = new ArrayList<>(hand);
            int sortedCards[] = sort(duplicateHand);
            int count = 1;
            int numberValue = 0;

            for (int i = 0; i < hand.size() - 1; i++) {
                if (sortedCards[i] == sortedCards[i + 1]) {
                    count++;
                    if (count == 3) {
                        numberValue = sortedCards[i];
                        break;
                    }
                } else
                    count = 1;
            }

            int value = 0;
            for (int i = hand.size() - 1; i > 0; i--) {
                if (hand.get(i).getNumber().equals("A"))
                    value = 14;
                else if (hand.get(i).getNumber().equals("K"))
                    value = 13;
                else if (hand.get(i).getNumber().equals("Q"))
                    value = 12;
                else if (hand.get(i).getNumber().equals("J"))
                    value = 11;
                else
                    value = Integer.parseInt(hand.get(i).getNumber());

                if (value == numberValue) {
                    duplicateHand.remove(i);
                }
            }

            if (onePair(duplicateHand))
                return true;
            else
                return false;
        }

        else
            return false;
    }

    public boolean fourOfaKind(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            int individualCardCount = 1;
            for (int j = 1; j < hand.size(); j++)
            {
                if (hand.get(i).getNumber().equals(hand.get(j).getNumber()))
                    individualCardCount++;
            }

            if(individualCardCount == 4)
                return true;
        }

        return false;
    }

    public boolean straightFlush(List<Card> hand)
    {
        // NEED TO FIX FOR TWO OF THE SAME NUMBER
        // NEED TO FIX BECAUSE WHAT IF THERE ARE SIX CARDS IN A ROW BUT FIRST IS NOT SAME SUIT
        if(straight(hand))
        {
            List<Card> straightCards = new ArrayList<>();
            int sortedCards[] = sort(hand);
            int count = 1;
            int endIndex = 0;

            for (int i = 0; i < hand.size() - 1; i++)
            {
                if (sortedCards[i] + 1 == sortedCards[i + 1])
                {
                    count++;
                    if (count == 5)
                    {
                        endIndex = i + 1;
                        break;
                    }
                }

                else
                    count = 1;
            }
            System.out.println(endIndex);

            for(int j = endIndex - 4; j <= endIndex; j++)
            {
                straightCards.add(hand.get(j));
            }

            if(flush(straightCards))
                return true;
            else
                return false;
        }

        else
            return false;

        /*
        if (straight(hand)) {
            List<Card> newHand = new ArrayList<>();
            ;
            int sortedCards[] = sort(hand);
            for (int i = 0; i < hand.size() - 5; i++)
            {
                for (int j = i; j < i + 4; j++) {
                    if (sortedCards[j] == (sortedCards[j] + 1))
                    {
                        newHand.add(hand.get(j));
                    }
                }
            }

            if (flush(newHand))
                return true;
            else
                return false;
        }
        else
            return false;

         */
    }

    public boolean royalFlush(List<Card> hand)
    {
        if (straight(hand))
        {
            List<Card> newHand = new ArrayList<>();

            int sortedCards[] = sort(hand);
            for (int i = 0; i < hand.size() - 5; i++)
            {
                for (int j = i; j < i + 4; j++)
                {
                    if (sortedCards[j] == (sortedCards[j] + 1))
                    {
                        newHand.add(hand.get(j));
                    }
                }
            }

            if (flush(newHand))
            {
                String value1 = newHand.get(0).getNumber();
                String value2 = newHand.get(1).getNumber();
                String value3 = newHand.get(2).getNumber();
                String value4 = newHand.get(3).getNumber();
                String value5 = newHand.get(4).getNumber();
                if (value1.equals("10") && value2.equals("J") && value3.equals("Q") && value4.equals("K") && value5.equals("A"))
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }

    public int handValue(List<Card> hand)
    {
        int value = 0;
        if(royalFlush(hand))
            value = 10;
        if(straightFlush(hand))
            value = 9;
        if(fourOfaKind(hand))
            value = 8;
        if(fullHouse(hand))
            value = 7;
        if(flush(hand))
            value = 6;
        if(straight(hand))
            value = 5;
        if(threeOfaKind(hand))
            value = 4;
        if(twoPair(hand))
            value = 3;
        if(onePair(hand))
            value = 2;

        return value;
    }

    public void printHand(List<Card> hand)
    {
        for (int i = 0; i < hand.size(); i++)
        {
            System.out.print(hand.get(i).getNumber() + hand.get(i).getSuit() + " ");
        }
        System.out.println();
    }
}