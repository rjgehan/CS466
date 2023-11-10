<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>
<%@ page import="com.example.sevencardstud.Card" %>
<%@ page import="com.example.sevencardstud.Hand" %>

<%
    User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
    if (loggedInUser == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    Hand hands = (Hand) session.getAttribute("hands");
    if (hands == null) {
        hands = new Hand();
        session.setAttribute("hands", hands);
    }

    List<List<Card>> cardHands = new ArrayList<>();
    cardHands.add(Hand.hand1);
    cardHands.add(Hand.hand2);
    cardHands.add(Hand.hand3);
    cardHands.add(Hand.hand4);
    cardHands.add(Hand.hand5);

    List<String> botNames = new ArrayList<>();
    botNames.add("Joe");
    botNames.add("Mike");
    botNames.add("Tim");
    botNames.add("Len");
    botNames.add("John");

    String contextPath = request.getContextPath();

    if ("addCards".equals(request.getParameter("action"))) {
        if (Hand.hand1.size() != 7) {
            hands.newRound();
            session.setAttribute("hands", hands);
        }
    }

    Boolean showCards = (Boolean) session.getAttribute("showCards");
    if (showCards == null) {
        showCards = false;
    }

    if ("toggleShowCards".equals(request.getParameter("action"))) {
        showCards = !showCards;
        session.setAttribute("showCards", showCards);
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
    }


%>


<script>
    var currentTurn = 1; // Initialize the current turn to 1

    function nextTurn() {
        // Change the current turn to the next player's turn
        if (currentTurn < 6) {
            currentTurn++;
        } else {
            currentTurn = 1; // Wrap around to player 1
        }

        // Call a function to update the display based on the current turn
        updateDisplay();
    }

    function updateDisplay() {
        // Remove highlighting from all hands
        var allHands = document.querySelectorAll(".hand-container");
        allHands.forEach(function(hand) {
            hand.classList.remove("highlighted");
        });

        // Highlight the current player's hand
        var currentHand = document.getElementById("hand" + currentTurn);
        currentHand.classList.add("highlighted");

        // Update the display to show whose turn it is
        var botText = document.querySelectorAll(".bot p");
        botText.forEach(function(p) {
            p.style.fontWeight = "normal";
        });

        var currentPlayerBot = document.querySelector(".hand" + currentTurn + " .bot p");
        currentPlayerBot.style.fontWeight = "bold";
    }
</script>

<%
    int i = 1; // Start the counter at 1 for hand1, hand2, etc.
    for (List<Card> curr : cardHands) {
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
<div class="bot">
    <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
</div>

<div class="hand6" id="hand6">
    <%
        int j = 1;
        String imageName;
        for (Card card : Hand.hand6)
        {
            if (showCards || (j != 1 && j != 2 && j != 7)) {
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

<div style="text-align: center;">
    <form method="post">
        <button type="submit" name="action" value="addCards" class="add-cards-button">Add Cards</button>
    </form>
    <form method="post">
        <button type="submit" name="action" value="toggleShowCards" class="show-button">Show Cards</button>
    </form>
    <form method="post">
        <button type="submit" name="action" value="resetHands" class="show-button">reset hands</button>
    </form>
</div>

</body>


<head>
    <jsp:include page="styles.jsp"></jsp:include>


    <style>
        body {
            background-image: url('images/PNG/Background.png'); /* Path to your image */
            background-size: cover; /* Cover the entire page */
            background-position: center center; /* Center the image on the page */
            background-repeat: no-repeat; /* Do not repeat the image */
            background-attachment: fixed; /* Optional: Fix the background image during scroll */
        }
        /* Overall layout */
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
            color: white;
            justify-content: center;
            margin-left: 48%;
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




