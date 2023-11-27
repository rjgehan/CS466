<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<%@ page import="org.mindrot.jbcrypt.BCrypt" %>

<html>
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <style>
        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            max-width: 400px;
            margin: 50px auto;
        }
        form {
            padding-left: 20px;
            padding-right: 20px;
        }
        body {
            padding-top: 150px;
        }
    </style>

    <title>Login</title>
</head>
<body>
<%
    User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
%>

<% if (loggedInUser != null) { %>
<a href="home.jsp" class="btn-custom">Home</a> <br/>
<% } %>

<div>
    <%
        // Check for logout action
        if ("logout".equals(request.getParameter("action"))) {
            request.getSession().invalidate();
            loggedInUser = null; // Set it to null after invalidating the session
        }

        String errorMessage = null;
        UserDAO userDao = new UserDAO(); // Instantiate the UserDAO

        if (loggedInUser == null && "POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == null || username.trim().isEmpty()) {
                errorMessage = "Username cannot be empty.";
            } else {
                User user = userDao.findUserByLogin(username);
                if (user == null) {
                    errorMessage = "User not found.";
                } else if (!BCrypt.checkpw(password, user.getPassword())) {
                    errorMessage = "Incorrect password.";
                } else {
                    // User is authenticated; save user in session
                    request.getSession().setAttribute("loggedInUser", user);
                    response.sendRedirect("home.jsp");
                    return;  // Terminate the current JSP processing
                }
            }
        }
    %>

    <% if (loggedInUser != null) { %>
    <p>You are logged in as: ${loggedInUser.username}.</p>
    <form method='post'>
        <input type='hidden' name='action' value='logout'>
        <input type='submit' value='Logout'>
    </form>
    <% } else { %>
    <!-- Display error/success message -->
    <% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
    <% } %>

    <form method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Username..">

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password">

        <input type="submit" value="Login">
    </form>

    <a href="createAccount.jsp">
        <button type="button">Create Account</button>
    </a>

    <a href="resetPassword.jsp">
        <button type="button">Reset Password</button>
    </a>
    <% } %>


</div>
</body>
</html>