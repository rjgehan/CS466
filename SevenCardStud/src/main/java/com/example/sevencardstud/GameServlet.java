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
        // Check if the 'hands' object already exists in the session
        if (request.getSession().getAttribute("hands") == null) {
            Hand hands = new Hand(); // Create a new 'hands' object
            hands.initializeHands();
            request.getSession().setAttribute("hands", hands); // Store it in the session
        }

        // Forward to the JSP page
        request.getRequestDispatcher("/WEB-INF/deal-cards.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("playTurn".equals(action)) {
            playTurn(request, response);
        }
    }

    private void playTurn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve necessary data from the session or request
        // Implement the playTurn logic in your Game class
        Game game = (Game) getServletContext().getAttribute("game"); // Assuming game is stored in the application context

        // Call the playTurn method in your Game class
        game.playTurn();

        // Optionally, you can send a response back to the client
        response.getWriter().write("Turn played successfully");

        //Check
        int turn = game.getGameHand().turn;
        request.setAttribute("turn", turn);

        request.getRequestDispatcher("/WEB-INF/your-jsp-page.jsp").forward(request, response);
    }
}
