<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<%@ page import="com.example.sevencardstud.Hand" %>
<%@ page import="com.example.sevencardstud.Card" %>
<%@ page import="com.example.sevencardstud.Game" %>
<%--
Created by IntelliJ IDEA.
User: Juliana
Date: 10/25/2023
Time: 12:26 PM
To change this template use File | Settings | File Templates.
--%>
<%
    // User initialization
    User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
    if (loggedInUser == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    // Game initialization
    Game game = (Game) session.getAttribute("game");
    if (game == null) {
        game = new Game();
        session.setAttribute("game", game);
    }

    // Bot initialization
    List<String> botNames = new ArrayList<>();
    botNames.add("Joe");
    botNames.add("Mike");
    botNames.add("Tim");
    botNames.add("Len");
    botNames.add("John");

    // Context initialization
    String contextPath = request.getContextPath();

    // Controls

    // TEST: ADD CARDS
    if ("addCards".equals(request.getParameter("action"))) {
        if (game.hands.getHand1().size() != 7) {
            game.playRound();
            session.setAttribute("game", game);
        }
    }

    // FOLD
    if ("fold".equals(request.getParameter("action"))) {
        if (game.hands.getHand1().size() != 7) {
            game.playRound();
            session.setAttribute("game", game);
        }
    }

    // SHOW CARDS
    Boolean showCards = (Boolean) session.getAttribute("showCards");
    if (showCards == null) {
        showCards = false;
    }
    if ("toggleShowCards".equals(request.getParameter("action"))) {
        showCards = !showCards;
        session.setAttribute("showCards", showCards);
    }

    // RESET GAME
    if ("resetHands".equals(request.getParameter("action"))) {
        game = new Game();
        session.setAttribute("game", game);
    }

    // RAISE
    if ("raise".equals(request.getParameter("action"))) {
        //raise functionality
    }

%>


<script>
    function foldButtonClicked() {
        // Hide the button after clicking
        document.getElementById("action-bar").style.display = "none";
    }


    function bet() {
        var betAmount = document.getElementById("betAmount").value;
        // Validate the bet amount (add validation logic if needed)

        // Update the displayed current bet
        document.getElementById("currentBetDisplay").innerText = "Current Bet: " + betAmount;

        // Do something with the bet amount, you can send it to the server or process it here
        console.log("Bet placed: " + betAmount);
        // Update the current bet in the session or game object
        //updateCurrentBet(betAmount);
    }


    function openBetPopup() {
        document.getElementById("betPopup").style.display = "block";
        populateImageGrid(); // Function to populate the image grid
    }

    function closeBetPopup() {
        document.getElementById("betPopup").style.display = "none";
    }

    function populateImageGrid() {
        const imagePaths = [
            "<%= contextPath %>/images/PNG/Chips/chipBlackWhite.png",
            "<%= contextPath %>/images/PNG/Chips/chipBlueWhite.png",
            "<%= contextPath %>/images/PNG/Chips/chipGreenWhite.png",
            "<%= contextPath %>/images/PNG/Chips/chipRedWhite.png",
            "<%= contextPath %>/images/PNG/Chips/chipWhiteBlue.png",
            "<%= contextPath %>/images/PNG/Chips/chipBlue.png",
            "<%= contextPath %>/images/PNG/Chips/chipGreen.png",
        ];

        const amounts = ["$2", "$4", "$10", "$20", "$30", "$40", "$50"];

        const imageGrid = document.querySelector(".image-grid");
        imageGrid.innerHTML = ""; // Clear previous content

        imagePaths.forEach((path, index) => {
            const container = document.createElement("div");
            container.classList.add("grid-item");

            const img = document.createElement("img");
            img.src = path;
            img.onclick = function() {
                // Call a function to handle chip click
                addChipToContainer(amounts[index]);
            };
            container.appendChild(img);

            const text = document.createElement("p");
            text.innerText = amounts[index];
            container.appendChild(text);

            imageGrid.appendChild(container);
        });
    }

    function addChipToContainer(chipAmount) {
        const chipContainer = document.getElementById("chipContainer");

        // Create a new chip element
        const chip = document.createElement("div");
        chip.classList.add("chip");
        chip.innerText = chipAmount;

        // Add the chip to the container
        chipContainer.appendChild(chip);

        // Trigger the form submission
        document.getElementById("addCardsForm").submit();
    }

    function betButtonClicked() {
        openBetPopup();
    }

    // Function to create and append flying text element
    function createFlyingText() {
        var flyingText = document.createElement("div");
        flyingText.className = "flying-text";
        flyingText.style.fontSize = "72px";
        flyingText.innerText = "SHOWDOWN!";

        document.body.appendChild(flyingText);

        // Set up animation
        var startPosition = window.innerWidth;
        flyingText.style.transform = "translateX(" + startPosition + "px)";

        var animationDuration = 8000; // 8 seconds
        flyingText.animate(
            [{ transform: "translateX(" + startPosition + "px)" }, { transform: "translateX(-100%)" }],
            {
                duration: animationDuration,
                easing: "linear",
                fill: "forwards"
            }
        );

        // Remove the flying text element after the animation
        setTimeout(function () {
            document.body.removeChild(flyingText);
        }, animationDuration);
    }


    // Check if the triggerFlyingText attribute is set
    var triggerFlyingText = <%= request.getAttribute("triggerFlyingText") %>;

    // Call createFlyingText() if the condition is met
    if (triggerFlyingText) {
        createFlyingText();
    }
</script>





<body>
<%
    int i = 1; // Start the counter at 1 for hand1, hand2, etc.
    for (List<Card> curr : game.gameHands) {
        int j = 1;

%>
<div class="hand<%= i %>" id="hand<%= i %>">
    <%
        for (Card card : curr) {
            String imageName;
            if (showCards || (j != 1 && j != 2 && j != 7)) {
                imageName = "card" + card.getSuit() + card.getNumber() + ".png";
            } else {
                imageName = "cardBack_blue2.png";
            }
            j++;
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
    <!-- Will display bot info to go with the current hand, the bot number will be incremented just like the hand number -->
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p class="text">Bot <%= i %>: <%= botNames.get(i - 1) %> </p> <!-- Replace 'Name' with dynamic bot names if necessary -->
    </div>
</div>
<%
        i++; // Increment the counter for the next hand
    }
%>



<!-- Will display hand 6 cards -->
<div class="user">
    <!-- Get logged in user username -->
    <h2><%= loggedInUser.getUsername() %></h2>
</div>



<!-- Will display bot 6 to go with hand 6 to the right of it, this is hard coded right now but will be edited to the amount of users that join our game -->
<div class="pfp">
    <%
    String image = loggedInUser.getSelectedImage();
    if (image == null) {
        image = contextPath + "/images/PNG/Roster Images/image1.png";
    }
    %>
    <img src="<%= image %>" alt="<%= image %>">
</div>

<div class="hand6" id="hand6">
    <%
        int j = 1;
        String imageName;
        for (Card card : Hand.hand6)
        {
            if (showCards || (j != 1 && j != 2)) {
                imageName = "card" + card.getSuit() + card.getNumber() + ".png";
            } else {
                imageName = "cardBack_blue2.png";
            }
            j++;    %>
    <img class="card-image" src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<div id="betPopup" class="bet-popup">
    <div class="bet-popup-content">
        <span class="close" onclick="closeBetPopup()">&times;</span>
        <div class="image-grid">
        </div>
    </div>
</div>

<!-- Container for chips -->
<div id="chipContainer" class="chip-container"></div>
<div class="current-bet" id="currentBetDisplay">
    <p>Current Bet: <%= game.getCurrentBet() %></p>
</div>

<form method="post">
    <button type="submit" name="action" value="resetHands" class="show-button">New Game</button>
</form>

<div class="action-buttons" id="action-bar">
    <form method="post" id="addCardsForm">
        <button type="submit" name="action" value="addCards" class="add-cards-button" id="addcardsbutton">Fold</button>
    </form>
    <form method="post">
        <button type="submit" name="action" value="toggleShowCards" class="show-button">Show Cards</button>
    </form>
    <!--<button id="testbtn" onclick="createFlyingText()">test</button>-->
    <button type="button" onclick="openBetPopup()" class="bet-button">Place Bet</button>
    <button type="button" class="raise-button">Raise</button>
</div>
<% if (loggedInUser != null) { %>
<a href="home.jsp" class="btn-custom">Home</a> <br/>
<a href="displayCardImages.jsp" class="btn-custom">Winning Hands</a> <br/>
<% } %>



</body>


<head>
    <jsp:include page="styles.jsp"></jsp:include>


    <style>
        /* Ovrall layout */
        body {
            background-image: url('images/PNG/background2.0.png'); /* Path to your image */
            background-size: cover; /* Cover the entire page */
            background-position: center center; /* Center the image on the page */
            background-repeat: no-repeat; /* Do not repeat the image */
            background-attachment: fixed; /* Optional: Fix the background image during scroll */
        }
        .hand-container {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            display: flex;
            justify-content: center;
        }


        /* Place hand 1 */
        .hand1 {
            display: flex;
            align-items: center;
        }


        /* Create margin to place hand 1 */
        .hand1 {
            margin-left: 2%;
        }


        /* Set image size for cards and size between cards for hand 1 */
        .hand1 img {
            width: 65px;
            height: auto;
            margin-right: 5px;
        }


        /* Place hand 2 */
        .hand2 {
            display: flex;
            align-items: center;
        }


        /* Create margin to place hand 2 */
        .hand2 {
            margin-left: 65%;
        }


        /* Set image size for cards and size between cards for hand 2 */
        .hand2 img {
            width: 65px;
            height: auto;
            margin-right: 5px;
        }


        /* Place hand 3 */
        .hand3 {
            display:flex;
            align-items: center;
        }


        /* Create margin to place hand 3 */
        .hand3 {
            margin-left: 2%;
        }


        /* Set image size for cards and size between cards for hand 3 */
        .hand3 img {
            width: 65px;
            height: auto;
            margin-right: 5px;
        }


        /* Place hand 4 */
        .hand4 {
            display: flex;
            align-items: center;
        }


        /* Create margin to place hand 4 */
        .hand4 {
            margin-left: 65%;
        }


        /* Set image size for cards and size between cards for hand 4 */
        .hand4 img {
            width: 65px;
            height: auto;
            margin-right: 5px;
        }


        /* Place hand 5 */
        .hand5 {
            display: flex;
            align-items: center;
        }


        /* Create margin to place hand 5 */
        .hand5 {
            margin-left: 2%;
        }


        /* Set image size for cards and size between cards for hand 5 */
        .hand5 img {
            width: 65px;
            height: auto;
            margin-right: 5px;
        }


        /* Place hand 6*/
        .hand6 {
            display: flex;
            align-items: center;
        }


        /* Create margin on top of hand6 to put more emphasis on the user hand */
        .hand6 {
            margin-top: 5%;
        }


        /* Create margin to place hand 6 */
        .hand6 {
            margin-left: 30%
        }


        /* Set image size for cards and size between cards for hand 6 */
        .hand6 img {
            width: 100px;
            height: auto;
            margin-right: 5px;
        }


        /* Style for user name */
        .user{
            align-items: center;
            color: white;
            justify-content: center;
            margin-left: 48%;
        }

        .pfp {
            text-align: center;
            margin: 10px;
        }


        /* Size of bot image */
        .pfp img {
            width: 50px;
            height: auto;
        }

    </style>

    <style>
        .action-buttons {
            text-align: center;
            margin-top: 20px;
            padding: 20px;
            background-color: purple;
            border-radius: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .action-buttons button,
        .action-buttons input[type="number"],
        .action-buttons .bet-button {
            margin: 5px;
        }

        .action-buttons button,
        .action-buttons .bet-button {
            background-color: #8a2be2; /* Purple */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .action-buttons input[type="number"] {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #8a2be2; /* Purple */
        }

        .action-buttons input[type="number"]:focus {
            outline: none;
            border-color: #6a1fcb; /* Darker purple on focus */
        }

        .action-buttons .bet-button {
            background-color: #8a2be2; /* Purple */
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
        }

        .bet-popup {
            display: none;
            position: fixed;
            top: 20%;
            left: 20%;
            border: 1px solid #8a2be2;
            background-color: #ffffff;
            z-index: 9;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.4);
            border-radius: 5px;
        }

        .bet-popup-content {
            padding: 20px;
        }

        .bet-popup-content .close {
            color: #8a2be2;
            float: right;
            font-size: 30px;
            font-weight: bold;
            cursor: pointer;
        }

        .bet-popup-content .close:hover {
            color: #6a1fcb;
        }

        .image-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 10px;
        }

        .image-grid img {
            width: 100px;
            height: auto;
            transition: transform 0.3s;
        }

        .image-grid img:hover {
            transform: scale(1.1);
        }
        .image-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 10px;
        }

        .grid-item {
            position: relative;
        }

        .grid-item p {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 16px;
            font-weight: bold;
        }

        /* Style for the chip container */
        .chip-container {
            position: fixed;
            bottom: 10px;
            right: 10px;
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }

        /* Style for individual chips */
        .chip {
            background-color: #8a2be2; /* Purple */
            color: white;
            padding: 5px 10px;
            margin-bottom: 5px;
            border-radius: 5px;
            cursor: pointer;
        }

    </style>

    <style>
        /* Add a hover effect for the card images */
        .card-image:hover {
            border: 2px solid yellow;
            box-shadow: 0 0 5px yellow;
        }
    </style>

    <style>
        /* Animation for flying text */
        @keyframes flyingTextAnimation {
            0% {
                transform: translateX(-100%);
                opacity: 0;
            }
            30% {
                transform: translateX(0);
                opacity: 1;
            }
            70% {
                transform: translateX(0);
                opacity: 1;
            }
            100% {
                transform: translateX(100%);
                opacity: 0;
            }
        }

        .flying-text {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: red;
            font-size: 24px;
            white-space: nowrap;
            animation: flyingTextAnimation 3s ease-in-out;
        }
    </style>

    <style>
        /* Bot layout */
        .bot-container {
            display: flex;
            justify-content: center;
            align-items: center;
        }


        .bot {
            text-align: center;
            margin: 10px;
        }


        /* Size of bot image */
        .bot img {
            width: 50px;
            height: auto;
        }


        /* Bot names */
        .bot p {
            margin: 5px;
            font-size: 10px;
        }
    </style>


    <style>
        @media screen and (max-width: 768px) {
            /* Allows for containers to be put vertically */
            .hand-container {
                flex-wrap: wrap;
            }


            /* creates a margin on all hands */
            .hand1, .hand2, .hand3, .hand4, .hand5, .hand6 {
                margin: 10px;
            }

            /* Creates a larger margin for hand 2 (making it look pretty!) */
            .hand2 {
                margin-left: 10px;
            }
        }
    </style>
</head>





