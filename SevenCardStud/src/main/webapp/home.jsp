<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="styles.jsp"></jsp:include>
  <title>7 Card Stud</title>
  <style>
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .header {
      text-align: center;
      margin-bottom: 20px;
    }

    .header h1 {
      font-size: 36px;
      margin: 0;
      color: #fff;
    }

    .header i {
      font-size: 40px;
      vertical-align: middle;
      color: #fff;
    }

    #profileButton {
      background-color: #fff;
      color: #000;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
      margin: 10px;
      text-decoration: none;
      position: absolute;
      top: 10px;
      left: 10px;
    }

    #content {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      text-align: center;
    }

    .btn-custom {
      display: inline-block;
      padding: 15px 30px;
      font-size: 18px;
      background-color: #fff;
      color: #000;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
      margin: 10px;
      text-decoration: none;
    }

    .btn-custom:hover {
      background-color: #ddd;
    }

    .modal {
      display: none;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      overflow: auto;
      background-color: rgb(0,0,0);
      background-color: rgba(0,0,0,0.4);
      padding-top: 60px;
    }

    .modal-content {
      background-color: #fefefe;
      margin: 5% auto;
      padding: 20px;
      border: 1px solid #888;
      width: 80%;
      border-radius: 10px;
    }

    .close {
      color: #aaa;
      float: right;
      font-size: 28px;
      font-weight: bold;
    }

    .close:hover,
    .close:focus {
      color: black;
      text-decoration: none;
      cursor: pointer;
    }
  </style>
</head>
<body>

<%
  // Check if the user is not logged in
  User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
  if (loggedInUser == null) {
    // The user is not logged in; redirecting to index.jsp
    response.sendRedirect("index.jsp");
    return;  // Terminate the current JSP processing
  }
%>

<a href="#" class="btn-custom" id="profileButton">Profile</a>

<div id="content">
  <div class="header">
    <h1><i class="bi bi-suit-club" style="color: #fff;"></i><i class="bi bi-suit-diamond-fill" style="color: #fff;"></i><span style="color: #fff;">7 Card Stud</span><i class="bi bi-heart-fill" style="color: #fff;"></i><i class="bi bi-suit-spade" style="color: #fff;"></i></h1>
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
</div>

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
