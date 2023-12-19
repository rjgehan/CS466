<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>

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

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leaderboard</title>
    <style>
        body {
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background: linear-gradient(to right, #6b5b95, #4b6cb7);
        }

        .container {
            text-align: center;
            position: relative; /* New container for positioning the home button */
            max-width: 400px; /* Adjust as needed */
        }

        .btn-home {
            position: absolute;
            top: 20px;
            left: 20px;
            padding: 10px 20px;
            text-decoration: none;
            color: black;
            background-color: white;
            border: none;
            border-radius: 5px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            transition: background-color 0.3s;
        }
        .btn-home:hover {
            background-color: grey;
        }

        .leaderboard {
            color: white;
            text-align: center;
            padding: 35px;
            border: 3px solid #fff;
            border-radius: 15px;
            background-color: rgba(107, 91, 149, 0.8);
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2), 0 4px 6px rgba(0, 0, 0, 0.3);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            animation: fadeInUp 1s ease-in-out;
            max-width: 50%;
            margin: auto;
        }

        .leaderboard h3 {
            font-size: 28px;
            margin-bottom: 30px;
            letter-spacing: 2px;
        }

        .leaderboard ol {
            padding: 0;
            list-style: none;
        }

        .leaderboard li {
            margin-bottom: 20px;
            padding: 15px;
            border-bottom: 2px solid #fff;
            background: linear-gradient(rgba(107, 91, 149, 0.2), rgba(107, 91, 149, 0.1));
            box-shadow: 0 4px 8px rgba(255, 255, 255, 0.1);
            transition: background-color 0.3s, transform 0.3s;
        }

        .leaderboard li:last-child {
            border-bottom: none;
        }

        .leaderboard li:hover {
            background: linear-gradient(rgba(107, 91, 149, 0.4), rgba(107, 91, 149, 0.3));
            transform: scale(1.02);
        }

        .leaderboard li strong {
            font-weight: bold;
            color: #FFD700; /* Set a gold color for the wins */
        }

        @keyframes fadeInUp {
            0% {
                opacity: 0;
                transform: translateY(20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
    <jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <a href="home.jsp" class="btn-home">Home <i class="bi bi-house-door-fill"></i></a>

    <div class="leaderboard">
        <h3>Leaderboard (Sorted Most Wins to Least Wins):</h3>
        <ol>
            <%
                for (User user : leaderboard) {
            %>
            <li><strong><%= user.getUsername() %></strong> - Wins: <%= user.getWins() %></li>
            <%
                }
            %>
        </ol>
    </div>
</div>

</body>
</html>
