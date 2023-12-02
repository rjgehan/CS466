package com.example.sevencardstud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dealCards")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if the 'game' object already exists in the session
        if (request.getSession().getAttribute("game") == null) {
            Game game = new Game(); // Create a new 'game' object
            game.hands.initializeHands();
            request.getSession().setAttribute("game", game); // Store it in the session
        }

        // Check the condition in the Hand class and set the attribute
        Game game = (Game) request.getSession().getAttribute("game");
        int currentRound = game.hands.round;

        if (currentRound == 5) {
            request.setAttribute("triggerFlyingText", true);
        }

        // Forward to the JSP page
        request.getRequestDispatcher("../../../webapp/newGame.jsp").forward(request, response);
    }
}
