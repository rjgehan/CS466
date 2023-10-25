<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.*,java.io.*" %>

<html>
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <style>
        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            max-width: 400px;  /* Or any other value that you see fit */
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
        String errorMessage = null;  // This will store any error messages

        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (username != null && password1 != null && password2 != null) {
            if (password1.equals(password2)) {
                // Passwords match. Make the API call.
                try {
                    URL url = new URL("http://your-api-endpoint.com/addUser");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    OutputStream os = conn.getOutputStream();
                    os.write(("username=" + username + "&password=" + password1).getBytes());
                    os.flush();
                    os.close();

                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        response.sendRedirect("successPage.jsp");
                    } else {
                        errorMessage = "Error adding user. Please try again.";
                    }
                } catch (Exception e) {
                    errorMessage = "An error occurred. Please try again.";
                }
            } else {
                errorMessage = "Passwords do not match. Please try again.";
            }
        }
    %>

    <!-- Display error message if any -->
    <% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
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

    <!-- Create Account button linking to createAccount.jsp -->
    <a href="index.jsp">
        <button type="button">Already have an account?</button>
    </a>

</div>
</body>
</html>
