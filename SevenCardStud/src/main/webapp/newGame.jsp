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

    Card card1 = new Card("Spades", "2");
    Card card2 = new Card("Spades", "3");
    Card card3 = new Card("Spades", "4");
    Card card4 = new Card("Spades", "5");
    Card card5 = new Card("Spades", "6");
    Card card6 = new Card("Spades", "7");
    Card card7 = new Card("Hearts", "3");
    Hand hand1 = new Hand();
    hand1.addCard(card1);
    hand1.addCard(card2);
    hand1.addCard(card3);
    hand1.addCard(card4);
    hand1.addCard(card5);
    hand1.addCard(card6);
    hand1.addCard(card7);

    String contextPath = request.getContextPath();
%>
<img src="images/PNG/Cards/cardBack_blue1.png">

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


