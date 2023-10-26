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
