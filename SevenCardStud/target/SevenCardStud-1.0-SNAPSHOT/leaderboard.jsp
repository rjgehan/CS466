<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<%@ page import="java.util.Collections" %>

<%
    UserDAO userDAO = new UserDAO();
    List<Object[]> usernameAndWinsList = userDAO.findAllUsernamesAndWins();

    // create the list of usernames and their wins
    List<User> leaderboard = new ArrayList<>();
    for (Object[] userData : usernameAndWinsList) {
        User user = new User();
        user.setUsername((String) userData[0]);
        user.setWins((int) userData[1]);
        leaderboard.add(user);
    }

    // sort based on the largest amount of wins to least amount of wins
    leaderboard.sort((user1, user2) -> Integer.compare(user2.getWins(), user1.getWins()));
%>

<div class="leaderboard">
    <h3>Leaderboard (Sorted Most Wins to Least Wins):</h3>
    <ol>
        <%
            for (User user : leaderboard) {
        %>
        <li><%= user.getUsername() %> - Wins: <%= user.getWins() %></li>
        <%
            }
        %>
    </ol>
</div>
