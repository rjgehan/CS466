<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="/login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Username..">

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password">

        <input type="submit" value="Login">
    </form>

    <!-- Create Account button linking to createAccount.jsp -->
    <a href="createAccount.jsp">
        <button type="button">Create Account</button>
    </a>

</div>
</body>
</html>
