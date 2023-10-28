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
<a href="#" class="btn-custom" id="profileButton">Profile</a>

<!-- Hidden modal dialog for the profile -->
<div id="profileModal" class="modal">
  <div class="modal-content">
    <span class="close" id="closeProfileModal">&times;</span>
    <h2>Profile</h2>
    <br>
    <p>Wins: <span id="profileWins">0</span></p>
    <p>Losses: <span id="profileLosses">0</span></p>
    <p>Total Amount: $<span id="profileTotal">0</span></p>
    <br>
  </div>
</div>

<div class="text-center">
  <h1 class="text"><%= "Welcome" %></h1>
  <a href="new-game-servlet" class="btn-custom">New Game</a> <br/>
  <a href="bank.jsp" class="btn-custom">Bank</a> <br/>
  <a href="index.jsp" class="btn-custom">Account</a> <br/>
  <a href="newGame.jsp" class="btn-custom">newGame</a> <br/>

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