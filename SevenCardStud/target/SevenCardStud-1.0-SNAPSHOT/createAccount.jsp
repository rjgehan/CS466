<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
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
    </style>
    <title>account</title>
</head>
<body>
<a href="home.jsp" class="btn-custom">Home</a> <br/>
<div>
    <%
        String errorMessage = null;
        UserDAO userDao = new UserDAO(); // Instantiate the UserDAO

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");

            if (username == null || username.trim().isEmpty()) {
                errorMessage = "Username cannot be empty.";
            } else if (!password1.equals(password2)) {
                errorMessage = "Passwords do not match.";
            } else {
                User existingUser = userDao.findUserByLogin(username);
                if (existingUser != null) {
                    errorMessage = "Username already exists.";
                } else {
                    // Create and save the new user
                    User newUser = new User();
                    newUser.setUsername(username);
                    newUser.setPassword(password1);
                    userDao.create(newUser);
                    errorMessage = "Account created successfully!";
                }
            }
        }
    %>

    <!-- Display error/success message -->
    <% if (errorMessage != null) { %>
    <p style="color: <%=(errorMessage.equals("Account created successfully!") ? "green" : "red")%>;"><%= errorMessage %></p>
    <% } %>

    <form method="post">
        <label for="username">Create Username</label>
        <input type="text" id="username" name="username" placeholder="Create Username..">

        <label for="password1">Password</label>
        <input type="password" id="password1" name="password1" placeholder="Password">

        <label for="password2">Re-Enter Password</label>
        <input type="password" id="password2" name="password2" placeholder="Re-Enter Password">

        <input type="submit" value="Create">
    </form>

    <a href="index.jsp">
        <button type="button">Already have an account?</button>
    </a>

</div>
</body>
</html>
