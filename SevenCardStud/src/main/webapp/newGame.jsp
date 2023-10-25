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

    String contextPath = request.getContextPath();
%>

<div class="hand" id="hand1">
    <!-- Display the cards from hand1 -->
    <%
        for (Card card : hand1.getCards()) {
            String imageName = "card" + card.getSuit() + card.getNumber() + ".png";
    %>
    <img src="<%= contextPath %>/images/PNG/Cards/<%= imageName %>" alt="<%= card.getNumber() %> of <%= card.getSuit() %>">
    <%
        }
    %>
</div>

<div class="hand" id="hand2">
    <!-- Display the cards from hand2 -->
    <%
        for (Card card : hand2.getCards()) {
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
        .card {
            width: 75px;
            height:120px;
            display: inline-block;
            background-size: cover;
            margin-right: 10px;
        }
    </style>
</head>


