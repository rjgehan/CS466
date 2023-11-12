<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank</title>
    <jsp:include page="styles.jsp"></jsp:include>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        a {
            text-decoration: none;
            color: #333;
            font-size: 18px;
            margin-bottom: 20px;
        }

        .btn-custom {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-custom:hover {
            background-color: #45a049;
        }

        #counter {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
            background-color: #fff;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .bank-button {
            display: inline-block;
            margin: 10px;
            padding: 15px 30px;
            font-size: 18px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .bank-button:hover {
            background-color: #2980b9;
        }

        /* Add background color for buttons */
        .button-container {
            background-color: #ecf0f1;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<a href="home.jsp" class="btn-custom">Home</a> <br/>

<%
    User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
    if (loggedInUser == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    UserDAO userDAO = new UserDAO();

    if ("addFifty".equals(request.getParameter("action"))) {
        userDAO.addFiftyToBalance(loggedInUser.getUsername());
        loggedInUser = userDAO.findUserByLogin(loggedInUser.getUsername());
        request.getSession().setAttribute("loggedInUser", loggedInUser);

    } else if ("resetBalance".equals(request.getParameter("action"))) {
        userDAO.setBalanceToZero(loggedInUser.getUsername());
        loggedInUser = userDAO.findUserByLogin(loggedInUser.getUsername());
        request.getSession().setAttribute("loggedInUser", loggedInUser);
    }
%>

<div id="counter">Balance: <%= loggedInUser.getBalance() %></div>

<!-- Use the button-container class for a background behind the buttons -->
<div class="button-container">
    <form method="post">
        <% if (loggedInUser.getBalance().equals(0.0)) { %>
        <button type="submit" name="action" value="addFifty" class="bank-button">Add +50 to Balance</button>
        <% } %>
        <button type="submit" name="action" value="resetBalance" class="bank-button">Remove Balance</button>
    </form>
</div>
</body>
</html>
