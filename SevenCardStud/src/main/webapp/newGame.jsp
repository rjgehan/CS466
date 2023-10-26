<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
Created by IntelliJ IDEA.
User: Juliana
Date: 10/25/2023
Time: 12:26 PM
To change this template use File | Settings | File Templates.
--%>
<%
    class Card
    {
        private final String suit;
        private final String number;


        public Card(String suit, String number)
        {
            this.suit = suit;
            this.number = number;
        }


        public String getSuit() {
            return suit;
        }


        public String getNumber() {
            return number;
        }
    }


    class Hand
    {
        private final List<Card> cards;


        public Hand() {
            cards = new ArrayList<>();
        }


        public void addCard(Card card) {
            cards.add(card);
        }


        public List<Card> getCards() {
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
    Hand hand1 = new Hand();
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
    Hand hand2 = new Hand();
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
    Hand hand3 = new Hand();
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
    Hand hand4 = new Hand();
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
    Hand hand5 = new Hand();
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
    Hand hand6 = new Hand();
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
        <p>Bot 1: David</p>
    </div>
</div>


<!-- Will display cards from hand 2 -->
<!-- Will display bot 2 to go with hand 2 to the left of it, this is hard coded right now but will be edited to the amount of users that join our game -->
<div class="hand2" id="hand2">
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p>Bot 2: Kelly</p>
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
        <p>Bot 3: Juliana</p>
    </div>
</div>


<!-- Will display cards from hand 4 -->
<!-- Will display bot 4 to go with hand 4 to the left of it, this is hard coded right now but will be edited to the amount of users that join our game -->
<div class="hand4" id="hand4">
    <div class="bot">
        <img src="<%= contextPath %>/images/PNG/Cards/UserIcon.png" alt="UserIcon">
        <p>Bot 4: Peter</p>
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
        <p>Bot 5: Ryan</p>
    </div>
</div>


<!-- Will display hand 6 cards -->
<div class="hand6" id="hand6">
    <%
        for (Card card : hand6.getCards())
        {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<head>
    <jsp:include page="styles.jsp"></jsp:include>


    <style>
        .hand-container
        {
            position: absolute;
            top: 0;
            left: 5px;
            width: 100%;
            display: flex;
            justify-content: center;
        }


        .hand1, .hand2
        {
            /* Displays hand 1 and hand 2 horizontally */
            display: flex;
            align-items: center;
        }

        .hand1
         {
            /* Changes margins to the left of hand 1 as well as padding on the top */
            margin-left: 30px;
            margin-top: 10px;
         }


        .hand1 img, .hand2 img
        {
            /* Changes card size for hand 1 and hand 2 */
            width: 65px;
            height: auto;
            /* Creates spacing between each individual card */
            margin-right: 5px;
        }


        .hand2
        {
            /* Changes spacing to left of hand 2 */
            margin-left: 875px;
        }
    </style>


    <style>
        .hand-container
        {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .hand3, .hand4
        {
            /* Cards displayed horizontally and in center */
            display: flex;
            align-items: center;
        }

        .hand3
        {
            /* Changes the margin to left of hand 3 */
            margin-left: 30px;
        }


        .hand3 img, .hand4 img
        {
            /* Changes hand 3 and hand 4 card size */
            width: 65px;
            height: auto;
            /* Change spacing between individual cards*/
            margin-right: 5px;
        }


        .hand4
        {
            /* Change spacing to the left of hand 4 */
            margin-left: 875px;
        }
    </style>


    <style>
        .hand-container
        {
            position: absolute;
            top: 0;
            left: 5px;
            width: 100%;
            display: flex;
            justify-content: center;
        }


        .hand5, .hand6
        {
            /* Display hands horizontally */
            display: flex;
            align-items: center;
        }


        .hand5 img
        {
            /* Card size */
            width: 65px;
            height: auto;
            /* Add spacing between each individual cards */
            margin-right: 5px;
        }

        .hand6 img
        {
            /* Card size, hand6 will always be the "user" hand, so it will always appear larger on the screen */
            width: 100px;
            height: auto;
            /* Creates space between individual cards */
            margin-right: 5px;
        }
        .hand5
        {
            /* Changes margin to left of hand 5 */
            margin-left: 30px;
        }


        .hand6
        {
            /* Changes spacing on top of hand 6 */
            margin-top: 75px;
            /* Changes spacing to left of hand 6 */
            margin-left: 450px;
            /* Changes spacing on bottom, padding */
            margin-bottom: 10px;
        }
    </style>




    <style>
        .bot-container {
            display: flex;
            justify-content: center;
            align-items: center;
        }


        .bot {
            /* Changing the margins of the bots */
            text-align: center;
            margin: 10px;
        }


        .bot img {
            /* Changing the size of the bot icon */
            width: 50px;
            height: auto;
        }


        .bot p {
            margin: 5px;
            /* Changing font size for user names that will be generated*/
            font-size: 10px;
        }
    </style>
</head>





