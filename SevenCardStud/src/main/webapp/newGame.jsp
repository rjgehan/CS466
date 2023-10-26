<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
 Created by IntelliJ IDEA.
 User: Juliana
 Date: 10/25/2023
 Time: 12:26 PM
 To change this template use File | Settings | File Templates.
--%>
<%
    class Card {
        private final String suit;
        private final String number;

        public Card(String suit, String number) {
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

    class Hand {
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

<!--Display cards from the first hand-->
<div class="hand1" id="hand1">

    <%
        for (Card card : hand1.getCards()) {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<!-- Display the cards from the second hand -->
<div class="hand2" id="hand2">
    <%
        for (Card card : hand2.getCards()) {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<!-- Display the cards from the third hand -->
<div class="hand3" id="hand3">
    <%
        for (Card card : hand3.getCards()) {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<!-- Display the cards from the fourth hand -->
<div class="hand4" id="hand4">
    <%
        for (Card card : hand4.getCards()) {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<!-- Display the cards from the fifth hand -->
<div class="hand5" id="hand5">
    <%
        for (Card card : hand5.getCards()) {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<!-- Display the cards from the sixth hand -->
<div class="hand6" id="hand6">
    <%
        for (Card card : hand6.getCards()) {
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
        .hand-container {
            position: absolute;
            top: 0; /*Position card at top of page*/
            left: 0;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .hand1, .hand2 {
            display: flex; /* Display cards horizontally */
            align-items: center; /* Center */
        }

        .hand1 img, .hand2 img {
            width: 65px; /* Make cards particular size */
            height: auto;
            margin-right: 5px; /* Add spacing */
        }

        .hand2 {
            margin-left: 950px; /* Add spacing to the left */
        }
    </style>

    <style>
        .hand-container {
            position: absolute;
            top: 0; /* Position card at top of page */
            left: 0;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .hand3, .hand4 {
            display: flex; /* Display cards horizontally */
            align-items: center; /* Center */
        }

        .hand3 img, .hand4 img {
            width: 65px; /* Make cards particular size */
            height: auto;
            margin-right: 5px; /* Add spacing */
        }

        .hand4 {
            margin-left: 950px; /* Add spacing to the left */
        }
    </style>

    <style>
        .hand-container {
            position: absolute;
            top: 0; /* Position card at top of page */
            left: 0;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .hand5, .hand6 {
            display: flex; /* Display horizontally */
            align-items: center; /* Center */
        }

        .hand5 img, .hand6 img {
            width: 65px; /*  */
            height: auto;
            margin-right: 5px; /* Add some spacing between cards */
        }

        .hand6 {
            margin-left: 500px; /* Add some spacing to the left of hand2 */
        }
    </style>

</head>


