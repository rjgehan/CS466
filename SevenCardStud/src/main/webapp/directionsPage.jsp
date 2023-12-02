<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seven Card Stud Rules</title>
    <jsp:include page="styles.jsp"></jsp:include>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 50px;
            background-image: url('images/PNG/profile.png'); /* Path to your image */
            background-size: cover; /* Cover the entire page */
            background-position: center center; /* Center the image on the page */
            background-repeat: no-repeat; /* Do not repeat the image */
            background-attachment: fixed; /* Fixed background */
        }

        /* Box to hold the text */
        .text-box {
            width: 60%;
            max-width: 2500px;
            height: 600px; /* Set the height of the text box */
            overflow-y: auto; /* Enable vertical scrolling */
            margin: 100px auto;
            /* Adjust the top/bottom margin for positioning */
            background-color: rgba(255, 255, 255, 0.8); /* Background color with opacity */
            padding-top: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Adding a shadow effect */
        }

        h1 {
            text-align: center;
            color: #333; /* Adjust the color of the header text */
        }

        .rules {
            margin-bottom: 20px;
        }

        .rule-header {
            font-weight: bold;
        }

        .rule-steps {
            margin-left: 20px;
        }

        .card-indent {
            padding-left: 20px;
        }

        .description-indent {
            padding-left: 40px; /* Adjust this value to change the indentation size */
        }
    </style>
</head>

<body>
<a href="home.jsp" class="btn-custom">Home</a> <br/>

<div class="text-box">
    <h1>How to Play Seven Card Stud</h1>

    <div class="rules">
        <div class="rule">
            <p class="rule-header">Setting Up:</p>
            <p class="rule-steps">
                1. Ante Up: Each player antes a small amount into the pot before the game begins.<br>
                2. Deal Cards: Every player is dealt two cards face down (hole cards) and one card face up (door card).
            </p>
        </div>

        <div class="rule">
            <p class="rule-header">Betting Rounds:</p>
            <p class="rule-steps">
                1. Third Street: The player with the lowest-ranking face-up card initiates the betting with the "bring-in" bet (half the lower betting limit). Play moves clockwise, with options to call, raise, or fold.<br>
                2. Fourth Street: Each player gets another face-up card. The player with the highest-ranking face-up cards starts the betting. Betting limit increases.<br>
                3. Fifth Street: Players receive another face-up card. Betting continues.<br>
                4. Sixth Street: Another face-up card is dealt to each player, followed by more betting.<br>
                5. Seventh Street (or the River): Each player receives a final card face down. The last round of betting occurs.
            </p>
        </div>

        <!-- Add more rule sections for Showdown, Hand Rankings, and Tips -->

        <div class="rule">
            <p class="rule-header">Showdown:</p>
            <p class="rule-steps">
                The Showdown: Remaining players reveal their hole cards. The best 5-card poker hand wins the pot.
            </p>
        </div>

        <div class="rule">
            <p class="rule-header">Hand Rankings (Highest to Lowest):</p>

            <p class="card-indent">
                Royal Flush<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards containing the cards '10' 'J' 'Q' 'K' 'A' all the same suit.
            </p>

            <p class="card-indent">
                Straight Flush<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards of sequential rank, all the same suit.
            </p>


            <p class="card-indent">
                Four of a Kind<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards that contains four cards of the same rank.
            </p>


            <p class="card-indent">
                Full House<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards that contains three cards of the same rank and the other two are a pair of the same rank.
            </p>


            <p class="card-indent">
                Flush<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards, all the same suit.
            </p>

            <p class="card-indent">
                Straight<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards in sequential rank.
            </p>


            <p class="card-indent">
                Three of a Kind<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards that contain three of the same rank.
            </p>


            <p class="card-indent">
                Two pair<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards that contains two pairs of the same rank.
            </p>

            <p class="card-indent">
                One Pair<br>
            </p>
            <p>
            <p class="description-indent">
                - A hand of five cards that contains one pair of the same rank.
            </p>


            <p class="card-indent">
                High Card<br>
            </p>
            <p>
                <p class="description-indent">
            - A hand that contains no matching cards, the highest card in the hand.
            </p>


        </div>


        <div class="rule">
            <p class="rule-header">Tips:</p>
            <p class="rule-steps">
                1. Watch Cards: Pay attention to the door cards and what's been folded to calculate the odds and potential hands.<br>
                2. Manage Betting: Keep track of the bets and be mindful of the pot odds.<br>
            </p>
        </div>
    </div>
</div>
</body>
</html>
