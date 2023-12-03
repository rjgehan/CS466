<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<%@ page import="com.example.sevencardstud.Hand" %>
<%@ page import="com.example.sevencardstud.Card" %>
<%@ page import="com.example.sevencardstud.Game" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>

<%
    User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
    if (loggedInUser == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    List<String> playerNames = (List<String>) application.getAttribute("playerNames");
    if (playerNames == null) {
        playerNames = new ArrayList<>();
        application.setAttribute("playerNames", playerNames);
    }

    if (!playerNames.contains(loggedInUser.getUsername())) {
        playerNames.add(loggedInUser.getUsername());
    }

    // Assign names to variables
    String name1 = playerNames.size() > 0 ? playerNames.get(0) : "DefaultName";
    String name2 = playerNames.size() > 1 ? playerNames.get(1) : "Bot: Mike";
    String name3 = playerNames.size() > 2 ? playerNames.get(2) : "Bot: Tim";
    String name4 = playerNames.size() > 3 ? playerNames.get(3) : "Bot: Len";
    String name5 = playerNames.size() > 4 ? playerNames.get(4) : "Bot: John";
    String name6 = playerNames.size() > 5 ? playerNames.get(5) : "Bot: Sean";




    Game game = (Game) application.getAttribute("game");

    if (game == null) {
        game = new Game();
        application.setAttribute("game", game);
    }

    game = (Game) application.getAttribute("game");

    if (loggedInUser != null && game.isNewPlayer(loggedInUser.getUsername())) {
        game.addPlayer(loggedInUser.getUsername());
        application.setAttribute("game", game);
    }


    Hand hands = game.hands;



    List<List<Card>> cardHands = new ArrayList<>();
    cardHands.add(Hand.hand1);
    cardHands.add(Hand.hand2);
    cardHands.add(Hand.hand3);
    cardHands.add(Hand.hand4);
    cardHands.add(Hand.hand5);
    cardHands.add(Hand.hand6);
    cardHands.add(Hand.hand1);
    cardHands.add(Hand.hand2);
    cardHands.add(Hand.hand3);
    cardHands.add(Hand.hand4);
    cardHands.add(Hand.hand5);
    cardHands.add(Hand.hand6);

    List<String> botNames = new ArrayList<>();
    botNames.add(name1);
    botNames.add(name2);
    botNames.add(name3);
    botNames.add(name4);
    botNames.add(name5);
    botNames.add(name6);
    botNames.add(name1);
    botNames.add(name2);
    botNames.add(name3);
    botNames.add(name4);
    botNames.add(name5);
    botNames.add(name6);

    int myIndex = 0;
    while (!botNames.get(myIndex).equals(loggedInUser.getUsername()))
    {
        myIndex++;
    }

    String contextPath = request.getContextPath();

    int firstToPlay;
    if ("startGame".equals(request.getParameter("action"))) {
        List<List<Card>> tmpArray = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            tmpArray.add(cardHands.get(i));
        }
        firstToPlay = game.findPlayerWithSmallestCard(tmpArray);
        response.sendRedirect("newGame.jsp");
    }

<<<<<<< HEAD
=======
    if ("addCards".equals(request.getParameter("action"))) {
        if (Hand.hand1.size() != 7) {
            hands.newRound();
            session.setAttribute("hands", hands);
        }
        response.sendRedirect("newGame.jsp");
    }

>>>>>>> origin/main
    if ("fold".equals(request.getParameter("action"))) {
        hands.newTurn();
        application.setAttribute("hands", hands);
        response.sendRedirect("newGame.jsp");
    }

    Boolean showCards = (Boolean) session.getAttribute("showCards");
    if (showCards == null) {
        showCards = false;
    }

    if ("toggleShowCards".equals(request.getParameter("action"))) {
        showCards = !showCards;
        session.setAttribute("showCards", showCards);
        response.sendRedirect("newGame.jsp");
    }

    if ("resetHands".equals(request.getParameter("action"))) {
        hands = new Hand();
        session.setAttribute("hands", hands);
        cardHands.clear();
        cardHands.add(Hand.hand1);
        cardHands.add(Hand.hand2);
        cardHands.add(Hand.hand3);
        cardHands.add(Hand.hand4);
        cardHands.add(Hand.hand5);
        response.sendRedirect("newGame.jsp");
    }

    // RAISE
    if ("raiseBet".equals(request.getParameter("action"))) {
        if (hands.getHand1().size() != 7) {
            game.updateCurrentBet(2);
            hands.newRound();
            session.setAttribute("game", game);
        }
    }

    if ("bet2".equals(request.getParameter("action"))) {
        if (hands.getHand1().size() != 7) {
            game.updateCurrentBet(2);
            hands.newRound();
            session.setAttribute("game", game);
        }
    }

    if ("bet4".equals(request.getParameter("action"))) {
        if (hands.getHand1().size() != 7) {
            game.updateCurrentBet(4);
            hands.newRound();
            session.setAttribute("game", game);
        }
    }

    if ("bet10".equals(request.getParameter("action"))) {
        if (hands.getHand1().size() != 7) {
            game.updateCurrentBet(10);
            hands.newRound();
            session.setAttribute("game", game);
        }
    }

    if ("bet20".equals(request.getParameter("action"))) {
        if (hands.getHand1().size() != 7) {
            game.updateCurrentBet(20);
            hands.newRound();
            session.setAttribute("game", game);
        }
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

        // Remove existing chips before adding a new one
        chipContainer.innerHTML = "";

        // Create a new chip element
        const chip = document.createElement("div");
        chip.classList.add("chip");
        chip.innerText = chipAmount;

        // Add the chip to the container
        chipContainer.appendChild(chip);
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

    function onButtonClick() {
        sessionStorage.setItem("buttonClicked", "true");
    }

    function refreshPage() {
        if (!sessionStorage.getItem("buttonClicked")) {
            setTimeout(function() {
                location.reload();
            }, 3000);
        } else {
            // Reset the flag for future refreshes
            sessionStorage.removeItem("buttonClicked");
        }
    }

    function preloadImages() {
        const imagePaths = [
            "<%= contextPath %>/images/PNG/Cards/UserIcon.png",
            // Add paths of other images that need to be preloaded
        ];

        imagePaths.forEach(path => {
            const img = new Image();
            img.src = path;
        });
    }

    window.onload = function() {
        preloadImages();
        refreshPage();
    };

    function onButtonClick() {
        sessionStorage.setItem("buttonClicked", "true");
    }

    function refreshPage() {
        // if (!sessionStorage.getItem("buttonClicked")) {
        //     setTimeout(function() {
        //         location.reload();
        //     }, 3000);
        // } else {
        //     // Reset the flag for future refreshes
        //     sessionStorage.removeItem("buttonClicked");
        // }

        setTimeout(function() {
                    location.reload();
                }, 3000);
        <%

        %>
    }

    function preloadImages() {
        const imagePaths = [
            "<%= contextPath %>/images/PNG/Cards/UserIcon.png",
            // Add paths of other images that need to be preloaded
        ];

        imagePaths.forEach(path => {
            const img = new Image();
            img.src = path;
        });
    }

    window.onload = function() {
        preloadImages();
        refreshPage();
    };

</script>


<body onload="refreshPage()">
<%
    if ("Bot:".equals(botNames.get(hands.turn).split(" ")[0])) {
        hands.newTurn();
        application.setAttribute("hands", hands);
    }

    int index = 0;
    List<Card> currHand = Hand.hand6;
    while (!playerNames.get(index).equals(loggedInUser.getUsername())) {
        index++;
    }
    if (index == 1) {
        currHand = Hand.hand1;
    } else if (index == 2) {
        currHand = Hand.hand2;
    } else if (index == 3) {
        currHand = Hand.hand3;
    } else if (index == 4) {
        currHand = Hand.hand4;
    } else if (index == 5) {
        currHand = Hand.hand5;
    } else if (index == 6) {
        currHand = Hand.hand6;
    }
    int i = 1; // Start the counter at 1 for hand1, hand2, etc.
    for (int y = 0; y!=5; y++) {
        List<Card> curr = cardHands.get(myIndex + y);

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
        <%
            //            String name = "test";
//            if(loggedInUser.getUsername().equals(botNames.get(i - 1))) {
//                name = playerNames.get(i);
//            } else {
//                name = botNames.get(i - 1);
//            }
        %>
        <p class="text"><%= botNames.get(i + myIndex) %> </p> <!-- Replace 'Name' with dynamic bot names if necessary -->
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

        for (Card card : currHand)
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


<form method="post">
    <button type="submit" name="action" value="resetHands" class="show-button" onclick="onButtonClick()">New Game</button>
</form>

<form method="post">
    <button type="submit" name="action" value="startGame" class="start-game-button" onclick="onButtonClick()">Start Game</button>
    <%
        game = (Game) application.getAttribute("game");

    %>
    <%=loggedInUser.getUsername()%>
    <%=botNames.get(game.hands.turn)%>
    <%=game.hands.turn%>
    <%=application.getAttribute("currTurn")%>
    <%=game.numPlayers%>

</form>
<%
    if (loggedInUser.getUsername().equals(botNames.get(hands.turn))) {
%>
<div class="action-buttons" id="action-bar">
    <form method="post"> <!-- FOLD BUTTON -->
        <button type="submit" name="action" value="fold" class="fold-button" onclick="onButtonClick()">Fold</button>
    </form>
    <!-- <form method="post">  SHOW HANDS (Test)
        <button type="submit" name="action" value="toggleShowCards" class="show-button" onclick="onButtonClick()">Show Cards</button>
    </form> -->
    <button type="button" class="bet-button">Place Bet</button>
    <form method="post">
        <button type="submit" name="action" value="raiseBet" class="raise-button">Raise</button>
    </form>
    <div class="betChips">
        <form method="post" class="bet-two">
            <button type="submit" name="action" value="bet2">
                <img src="${pageContext.request.contextPath}/images/PNG/Chips/chipBlackWhite.png" alt="$2">
            </button>
        </form>
        <form method="post" class="bet-four">
            <button type="submit" name="action" value="bet4">
                <img src="${pageContext.request.contextPath}/images/PNG/Chips/chipGreenWhite.png" alt="$4">
            </button>
        </form>
        <form method="post" class="bet-ten">
            <button type="submit" name="action" value="bet10">
                <img src="${pageContext.request.contextPath}/images/PNG/Chips/chipRedWhite.png" alt="$10">
            </button>
        </form>
        <form method="post" class="bet-twenty">
            <button type="submit" name="action" value="bet20">
                <img src="${pageContext.request.contextPath}/images/PNG/Chips/chipBlueWhite.png" alt="$20">
            </button>
        </form>
    </div>

</div>
<%
    } else {
        //if (currTurn)
    }
%>


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
        .action-buttons .bet-button{
            background-color: #8a2be2; /* Purple */
            color: white;
            margin: 5px;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }


        .action-buttons input[type="number"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #8a2be2; /* Purple */
        }

        .action-buttons input[type="number"]:focus {
            outline: none;
            border-color: #6a1fcb; /* Darker purple on focus */
        }

        .action-buttons .bet-button {
            background-color: #007bff; /* Purple */
            color: white;
            border: none;
            padding: 15px 50px;
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

        .betChips {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 10px; /* Add margin for spacing */
        }

        .betChips form {
            margin: 5px; /* Adjust margin for spacing between buttons */
        }

        .betChips button {
            background: transparent;
            border: none;
            padding: 10px; /* Adjust the padding for the button size */
            cursor: pointer;
            position: relative;
        }

        .betChips button:hover::after {
            position: absolute;
            top: -20px; /* Adjust the position of the label */
            left: 50%;
            transform: translateX(-50%);
            background: rgba(255, 255, 90, 0.8); /* Background color of the label */
            padding: 5px;
            border-radius: 5px;
            font-size: 12px;
            white-space: nowrap;
            pointer-events: none; /* Allow interaction with the button, not the label */
        }

        .betChips .bet-two button:hover::after {
            content: "$2"; /* Display label when hovered over for the first chip */
        }

        .betChips .bet-four button:hover::after {
            content: "$4"; /* Display label when hovered over for the second chip */
        }

        .betChips .bet-ten button:hover::after {
            content: "$10"; /* Display label when hovered over for the second chip */
        }

        .betChips .bet-twenty button:hover::after {
            content: "$20"; /* Display label when hovered over for the second chip */
        }

        .betChips img {
            width: 50px; /* Adjust the size of the chip image */
            height: auto;
            transition: transform 0.3s, filter 0.3s; /* Add transition for the glow effect */
        }

        .betChips img:hover {
            transform: scale(1.1); /* Add a scale effect on hover */
            filter: brightness(1.5); /* Adjust brightness on hover for a glowing effect */
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

    </style>

    <style>
        /* Add a hover effect for the card images */
        .card-image:hover {
            border: 2px solid yellow;
            box-shadow: 0 0 5px yellow;
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






