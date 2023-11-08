<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page import="com.example.sevencardstud.model.entity.User" %>


<%--
Created by IntelliJ IDEA.
User: Juliana
Date: 10/25/2023
Time: 12:26 PM
To change this template use File | Settings | File Templates.
--%>
<%
    // Card class to give access to my card information
    class Card
    {
        // Create suit and number variables to be used
        private final String suit;
        private final String number;


        public Card(String suit, String number)
        {
            this.suit = suit;
            this.number = number;
        }


        public String getSuit()
        {
            return suit;
        }


        public String getNumber()
        {
            return number;
        }
    }




    // Hand class to create player's hand
    class Hand
    {
        private final List<Card> cards;


        public Hand()
        {
            cards = new ArrayList<>();
        }


        public void addCard(Card card)
        {
            cards.add(card);
        }


        public List<Card> getCards()
        {
            return cards;
        }
    }


    //Creating first hand of cards
    Card card1 = new Card("Back_", "blue1");
    Card card2 = new Card("Back_", "blue1");
    Card card3 = new Card("Diamonds", "J");
    Card card4 = new Card("Spades", "5");
    Card card5 = new Card("Spades", "2");
    Card card6 = new Card("Hearts", "A");
    Card card7 = new Card("Back_", "blue1");
    //Create hand 1
    Hand hand1 = new Hand();
    // Add Cards
    hand1.addCard(card1);
    hand1.addCard(card2);
    hand1.addCard(card3);
    hand1.addCard(card4);
    hand1.addCard(card5);
    hand1.addCard(card6);
    hand1.addCard(card7);








    //Creating second hand of cards
    Card card8 = new Card("Back_", "blue1");
    Card card9 = new Card("Back_", "blue1");
    Card card10 = new Card("Clubs", "Q");
    Card card11 = new Card("Diamonds", "2");
    Card card12 = new Card("Spades", "10");
    Card card13 = new Card("Clubs", "4");
    Card card14 = new Card("Back_", "blue1");
    //Create hand 2
    Hand hand2 = new Hand();
    // Add Cards
    hand2.addCard(card8);
    hand2.addCard(card9);
    hand2.addCard(card10);
    hand2.addCard(card11);
    hand2.addCard(card12);
    hand2.addCard(card13);
    hand2.addCard(card14);




    //Creating third hand of cards
    Card card15 = new Card("Back_", "blue1");
    Card card16 = new Card("Back_", "blue1");
    Card card17 = new Card("Hearts", "2");
    Card card18 = new Card("Hearts", "J");
    Card card19 = new Card("Diamonds", "10");
    Card card20 = new Card("Spades", "2");
    Card card21 = new Card("Back_", "blue1");
    //Create hand 3
    Hand hand3 = new Hand();
    // Add cards
    hand3.addCard(card15);
    hand3.addCard(card16);
    hand3.addCard(card17);
    hand3.addCard(card18);
    hand3.addCard(card19);
    hand3.addCard(card20);
    hand3.addCard(card21);








    //Creating a fourth hand of cards
    Card card22 = new Card("Back_", "blue1");
    Card card23 = new Card("Back_", "blue1");
    Card card24 = new Card("Spades", "9");
    Card card25 = new Card("Diamonds", "5");
    Card card26 = new Card("Diamonds", "Q");
    Card card27 = new Card("Spades", "K");
    Card card28 = new Card("Back_", "blue1");
    //Create hand 4
    Hand hand4 = new Hand();
    //Add cards
    hand4.addCard(card22);
    hand4.addCard(card23);
    hand4.addCard(card24);
    hand4.addCard(card25);
    hand4.addCard(card26);
    hand4.addCard(card27);
    hand4.addCard(card28);








    //Creating a fifth hand of cards
    Card card29 = new Card("Back_", "blue1");
    Card card30 = new Card("Back_", "blue1");
    Card card31 = new Card("Spades", "6");
    Card card32 = new Card("Clubs", "3");
    Card card33 = new Card("Clubs", "K");
    Card card34 = new Card("Hearts", "7");
    Card card35 = new Card("Back_", "blue1");
    //Create hand 5
    Hand hand5 = new Hand();
    //Add cards
    hand5.addCard(card29);
    hand5.addCard(card30);
    hand5.addCard(card31);
    hand5.addCard(card32);
    hand5.addCard(card33);
    hand5.addCard(card34);
    hand5.addCard(card35);








    //Creating a sixth hand of cards
    Card card36 = new Card("Back_", "blue1");
    Card card37 = new Card("Back_", "blue1");
    Card card38 = new Card("Hearts", "J");
    Card card39 = new Card("Spades", "Q");
    Card card40 = new Card("Diamonds", "4");
    Card card41 = new Card("Hearts", "K");
    Card card42 = new Card("Back_", "blue1");
    //Create hand 6
    Hand hand6 = new Hand();
    //Add cards
    hand6.addCard(card36);
    hand6.addCard(card37);
    hand6.addCard(card38);
    hand6.addCard(card39);
    hand6.addCard(card40);
    hand6.addCard(card41);
    hand6.addCard(card42);




    //Creating path
    String contextPath = request.getContextPath();
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




<!-- Will display cards from hand 1 -->
<div class="hand1" id="hand1">
    <%
        for (Card card : hand1.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
    <!-- Will display bot 1 to go with hand 1 to the right of it, this is hard coded right now but will be edited to the amount of users that join our game -->
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p class="text">Bot 1: David</p>
    </div>
</div>




<!-- Will display cards from hand 2 -->
<!-- Will display bot 2 to go with hand 2 to the left of it, this is hard coded right now but will be edited to the amount of users that join our game -->
<div class="hand2" id="hand2">
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p class="text">Bot 2: Kelly</p>
    </div>
    <%
        for (Card card : hand2.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>




<!-- Will display cards from hand 3 -->
<div class="hand3" id="hand3">
    <%
        for (Card card : hand3.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
    <!-- Will display bot 3 to go with hand 3 to the right of it, this is hard coded right now but will be edited to the amount of users that join our game -->
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p class="text">Bot 3: Juliana</p>
    </div>
</div>




<!-- Will display cards from hand 4 -->
<!-- Will display bot 4 to go with hand 4 to the left of it, this is hard coded right now but will be edited to the amount of users that join our game -->
<div class="hand4" id="hand4">
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p class="text">Bot 4: Peter</p>
    </div>
    <%
        for (Card card : hand4.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>




<!-- Will display the cards from hand 5 -->
<div class="hand5" id="hand5">
    <%
        for (Card card : hand5.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
    <!-- Will display bot 5 to go with hand 5 to the right of it, this is hard coded right now but will be edited to the amount of users that join our game -->
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p class="text">Bot 5: Ryan</p>
    </div>
</div>
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


<div class="user">
    <!-- Get logged in user username -->
    <h2><%= loggedInUser.getUsername() %></h2>
</div>


<!-- Will display bot 6 to go with hand 6 to the right of it, this is hard coded right now but will be edited to the amount of users that join our game -->
<div class="bot">
    <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
</div>


<!-- Will display hand 6 cards -->
<div class="hand6" id="hand6">
    <%
        for (Card card : hand6.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img class="card-image" src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>
</body>


<head>
    <jsp:include page="styles.jsp"></jsp:include>


    <style>
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
            align-items: center;
            color: white;
            justify-content: center;
            margin-left: 50%;
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




