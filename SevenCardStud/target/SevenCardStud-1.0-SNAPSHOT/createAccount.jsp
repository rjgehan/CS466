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
    <title>Account</title>
</head>
<body>
<a href="home.jsp" class="btn-custom">Home</a> <br/>
<div>
    <%
        String errorMessage = null;
        UserDAO userDao = new UserDAO();

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String securityAnswer = request.getParameter("securityAnswer");

            if (username == null || username.trim().isEmpty()) {
                errorMessage = "Username cannot be empty.";
            } else if (!password1.equals(password2)) {
                errorMessage = "Passwords do not match.";
            } else if (securityAnswer == null || securityAnswer.trim().isEmpty()) {
                errorMessage = "Security answer cannot be empty.";
            } else {
                User existingUser = userDao.findUserByLogin(username);
                if (existingUser != null) {
                    errorMessage = "Username already exists.";
                } else {
                    String hashedPassword = BCrypt.hashpw(password1, BCrypt.gensalt());
                    String hashedReset = BCrypt.hashpw(securityAnswer, BCrypt.gensalt());

                    User newUser = new User();
                    newUser.setUsername(username);
                    newUser.setPassword(hashedPassword);
                    newUser.setSecurityAnswer(hashedReset);

                    userDao.create(newUser);
                    response.sendRedirect("home.jsp");
                    return;
                }
            }
        }
    %>

    <% if (errorMessage != null) { %>
    <p style="color: <%= (errorMessage.equals("Account created successfully!") ? "green" : "red") %>;"><%= errorMessage %></p>
    <% } %>

    <form method="post">
        <label for="username">Create Username</label>
        <input type="text" id="username" name="username" placeholder="Create Username..">

        <label for="password1">Password</label>
        <input type="password" id="password1" name="password1" placeholder="Password">

        <label for="password2">Re-Enter Password</label>
        <input type="password" id="password2" name="password2" placeholder="Re-Enter Password">

        <label for="securityQuestion">Select a Security Question:</label>
        <select id="securityQuestion" name="securityQuestion">
            <option value="firstPet">Name of your first pet</option>
            <option value="birthCity">City where you were born</option>
            <option value="firstCar">Mother's maiden name</option>
            <option value="childhoodHero">Street that you grew up on</option>
        </select>

        <label for="securityAnswer">Your Answer</label>
        <input type="text" id="securityAnswer" name="securityAnswer" placeholder="Your answer">

        <input type="submit" value="Create">
    </form>

    <a href="index.jsp">
        <button type="button">Already have an account?</button>
    </a>
</div>
</body>
</html>