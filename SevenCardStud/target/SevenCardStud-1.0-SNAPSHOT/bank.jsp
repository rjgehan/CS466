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
        header {
            width: 100%;
            display: flex;
            justify-content: flex-start; /* Aligns items to the left */
            padding: 10px; /* Adjust as needed */

        }

        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-image: url('images/PNG/bankback.png'); /* Path to your image */

        }

        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
            margin-bottom: 20px;
        }

        .btn-custom {
            /*display: inline-block;*/
            padding: 10px 20px;
            font-size: 16px;
            background-color: white;
            color: black;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-custom:hover {
            background-color: rgb(128, 128, 128);
        }

        #counter {
            /*text-align: center;*/
            font-size: 36px;
            margin-bottom: 20px;
            background-color: #6b5b95;
            color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            animation: pulse 1.5s infinite;
        }

        .bank-button {
            /*display: inline-block;*/
            margin: 10px;
            padding: 15px 30px;
            font-size: 18px;
            background-color: white;
            color: #212529;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .bank-button:hover {
            background-color: white;
        }

        /* Add background color for buttons */
        .button-container {
            /*background-color: #6b5b95;*/
            /*padding: 40px;*/
            /*border-radius: 15px;*/
            /*box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);*/
            /*display: flex;*/
            /*flex-direction: column;*/
            /*align-items: center;*/
            /*justify-content: center;*/
        }

        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.1);
            }
            100% {
                transform: scale(1);
            }
        }
        
        .home {
            padding-top: 320px;
        }
    </style>

</head>

<body>

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

<div id="counter">Balance: $<%= loggedInUser.getBalance() %></div>

<!-- Use the button-container class for a background behind the buttons -->
<div class="button-container">
    <form method="post">
        <% if (loggedInUser.getBalance().equals(0.0)) { %>
        <button type="submit" name="action" value="addFifty" class="bank-button">Add +$50 to Balance</button>
        <% } %>
        <button type="submit" name="action" value="resetBalance" class="bank-button">Reset Balance</button>
    </form>
</div>
<div class="home">
    <a href="home.jsp" class="btn-custom">Home <i class="bi bi-house-door-fill"></i></a> <br/>
</div>
</body>
</html>
