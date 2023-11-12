<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="styles.jsp"></jsp:include>
  <title>7 Card Stud</title>
</head>
<body>

<%
  // Check if user is not logged in
  User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
  if (loggedInUser == null) {
    // User is not logged in; redirecting to index.jsp
    response.sendRedirect("index.jsp");
    return;  // Terminate the current JSP processing
  }
%>
<div class="header">
  <h1><i class="bi bi-suit-club"></i><i class="bi bi-suit-diamond-fill"></i>7 Card Stud<i class="bi bi-heart-fill"></i><i class="bi bi-suit-spade"></i></h1>
</div>
<a href="#" class="btn-custom" id="profileButton">Profile</a>

<!-- Hidden modal dialog for the profile -->
<div id="profileModal" class="modal">
  <div class="modal-content">
    <span class="close" id="closeProfileModal">&times;</span>
    <h2><%= loggedInUser.getUsername() %></h2>
    <br>
    <p>Wins: <span id="profileWins"><%= loggedInUser.getWins() %></span></p>
    <p>Total Amount: $<span id="profileTotal"><%= loggedInUser.getBalance() %></span></p>
    <br>
  </div>
</div>

<div class="text-center">
  <!-- Add a class to the "Welcome" heading -->
  <h1 class="text"><%= "Welcome" %></h1>
  <a href="newGame.jsp" class="btn-custom">New Game</a> <br/>
  <a href="bank.jsp" class="btn-custom">Bank</a> <br/>
  <a href="index.jsp" class="btn-custom">Account</a> <br/>
  <a href="leaderboard.jsp" class="btn-custom">Leaderboard</a> <br/>
  <a href="profilePicture.jsp" class="btn-custom">Edit Profile</a> <br/>


</div>
<script>
  // Get the modal and button elements
  const profileModal = document.getElementById("profileModal");
  const profileButton = document.getElementById("profileButton");
  const closeProfileModal = document.getElementById("closeProfileModal");

  // When the "Profile" button is clicked, show the modal
  profileButton.onclick = function() {
    profileModal.style.display = "block";
  }

  // When the "Close" button in the modal is clicked, hide the modal
  closeProfileModal.onclick = function() {
    profileModal.style.display = "none";
  }

  // When the user clicks anywhere outside the modal, close it
  window.onclick = function(event) {
    if (event.target === profileModal) {
      profileModal.style.display = "none";
    }
  }
</script>

</body>
</html>