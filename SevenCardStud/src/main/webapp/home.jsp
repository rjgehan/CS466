<%-- home page --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="styles.jsp"></jsp:include>
  <title>7 Card Stud</title>
</head>
<body>
<div class="header">
  <h1><i class="bi bi-suit-club"></i><i class="bi bi-suit-diamond-fill"></i>7 Card Stud<i class="bi bi-heart-fill"></i><i class="bi bi-suit-spade"></i></h1>
</div>
<div class="text-center">
  <!-- Add a class to the "Welcome" heading -->
  <h1 class="text"><%= "Welcome" %></h1>
  <a href="new-game-servlet" class="btn-custom">New Game</a> <br/>
  <a href="bank.jsp" class="btn-custom">Bank</a> <br/>
  <a href="index.jsp" class="btn-custom">Account</a> <br/>
  <a href="newGame.jsp" class="btn-custom">newGame</a> <br/>

</div>
</body>
</html>