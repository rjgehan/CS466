package com.example.sevencardstud;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "newGameServlet", value = "/new-game-servlet")
public class NewGameServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // Check if deck already exists in session
        Deck deck = (Deck) session.getAttribute ("deck");
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

        // A dd a shuffle button
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

class Card {
    private final String suit;
    private final String number;

    public Card(String suit, String number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public String getNumber() {
        return number;
    }
}

class Deck {
    private List<Card> cardsDeck;

    public Deck() {
        cardsDeck = new ArrayList<>();
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String rank : ranks) {
                this.cardsDeck.add(new Card(suit, rank));
            }
        }
        this.shuffleDeck();
    }

    public List<Card> getCards() {
        return cardsDeck;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardsDeck);
    }

    public Card drawCard() {
        if (cardsDeck.isEmpty()) {
            return null;
        }
        Card card = this.cardsDeck.get(cardsDeck.size() - 1);
        this.cardsDeck.remove(cardsDeck.size() - 1);
        return card;
    }
}