<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <title>Bank</title>
    <style>
        /* Center the button horizontally */
        .bank-button {
            display: block;
            margin: 10px auto;
        }

        /* Make the counter larger */
        #counter {
            text-align: center;
            font-size: 24px;
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

<div id="counter" class="text">Balance: <%= loggedInUser.getBalance() %></div>

<div style="text-align: center;">
    <form method="post">
        <% if (loggedInUser.getBalance().equals(0.0)) { %>
        <button type="submit" name="action" value="addFifty" class="bank-button">Add +50 to Balance</button>
        <% } %>
        <button type="submit" name="action" value="resetBalance" class="bank-button">Remove Balance</button>
    </form>
</div>
</body>
</html>
