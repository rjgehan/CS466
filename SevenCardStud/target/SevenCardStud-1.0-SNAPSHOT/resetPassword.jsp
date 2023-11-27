<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="org.mindrot.jbcrypt.BCrypt" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>

<html>
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <style>
        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            max-width: 400px;
            margin: 0 auto;
        }
        form {
            padding-left: 20px;
            padding-right: 20px;
        }
        body {
            padding-top: 150px;
        }
    </style>
    <title>Reset Password</title>
</head>
<body>
<a href="home.jsp" class="btn-custom">Home</a> <br/>

<div>
    <%
        String message = null;
        UserDAO userDao = new UserDAO();

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String providedSecurityAnswer = request.getParameter("securityAnswer");
            String newPassword = request.getParameter("newPassword");

            User user = userDao.findUserByLogin(username);

            if (user != null && BCrypt.checkpw(providedSecurityAnswer, user.getSecurityAnswer())) {
                String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                userDao.resetPassword(username, hashedNewPassword);
                message = "Password reset successfully!";
            } else {
                message = (user == null) ? "Username not found." : "Incorrect security answer.";
            }
        }
    %>

    <!-- Display message -->
    <% if (message != null) { %>
    <p style="color: <%=(message.equals("Password reset successfully!") ? "green" : "red")%>;"><%= message %></p>
    <% } %>

    <form method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter your username..">

        <label for="securityAnswer">Security Answer</label>
        <input type="text" id="securityAnswer" name="securityAnswer" placeholder="Enter your security answer..">

        <label for="newPassword">New Password</label>
        <input type="password" id="newPassword" name="newPassword" placeholder="Enter new password..">

        <input type="submit" value="Reset Password">
    </form>

    <a href="index.jsp">
        <button type="button">Go to Login</button>
    </a>

</div>
</body>
</html>
