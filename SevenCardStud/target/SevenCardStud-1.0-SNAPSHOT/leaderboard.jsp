<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>

<%
    // Check if user is not logged in
    User user = (User) request.getSession().getAttribute("loggedInUser");
    if (user == null) {
        // User is not logged in; redirect to index.jsp
        response.sendRedirect("index.jsp");
        return; // Terminate the current JSP processing
    }

    //Assuming that "getWins()" returns the number of wins for the user
    int wins = user.getWins();
%>

<div class="user">
    <!-- Display the number of wins -->
    <h2>Number of Wins: <%= user.getWins() %></h2>
</div>
