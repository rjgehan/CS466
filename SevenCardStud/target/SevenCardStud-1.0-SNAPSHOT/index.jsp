<%-- home page --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <style>
        :root {
            --primary-start: #241773;
            --primary-end: #724B98;
        }
        body {
            background: linear-gradient(to bottom, var(--primary-start), var(--primary-end));
            margin: 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .header {
            background-color: #29134B;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .btn-custom {
            background-color: white;
            color: var(--primary-start);
            border: 2px solid var(--primary-start);
            padding: 10px 20px;
            text-align: center;
            display: inline-block;
            text-decoration: none;
            margin: 10px;
            border-radius: 5px;
        }
        /* Set text color for the "Welcome" heading to white */
        .welcome-heading {
            color: white;
        }
    </style>
    <title>7 Card Stud</title>
</head>
<body>
<div class="header">
    <h1><i class="bi bi-suit-club"></i><i class="bi bi-suit-diamond-fill"></i>7 Card Stud<i class="bi bi-heart-fill"></i><i class="bi bi-suit-spade"></i></h1>
</div>
<div class="text-center">
    <!-- Add a class to the "Welcome" heading -->
    <h1 class="welcome-heading"><%= "Welcome" %></h1>
    <a href="new-game-servlet" class="btn-custom">New Game</a> <br/>
    <a href="bank.jsp" class="btn-custom">Bank</a> <br/>
    <a href="account.jsp" class="btn-custom">Account</a> <br/>

</div>
</body>
</html>
