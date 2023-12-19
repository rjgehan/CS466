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

        .betting-header {
            font-weight: bold;
        }

        .description-indent {
            padding-left: 40px; /* Adjust this value to change the indentation size */
        }

        .bet-options {
            list-style-type: none;
            padding-left: 20px;
        }
        .rule-steps {
            margin-left: 20px;
        }

        .betting-rules {
            margin-left: 20px
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
<a href="home.jsp" class="btn-custom">Home <i class="bi bi-house-door-fill"></i></a> <br/>

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

        <div class="betting">
            <p class="betting-header">Betting:</p>
            <div class="betting-rules">
                <p>All players will pay the ante amount of 1 automatically upon starting the game.</p>

                <p>Round 1:<br>
                    <span class="description-indent">
                First Better
                <ul class="bet-options">
                    <li>     - Can either check (bet nothing), call (bet 2), raise (bet 4), or fold</li>
                </ul>
            </span>
                    <span class="description-indent">
                Following Betters
                <ul class="bet-options">
                    <br><li>     - Can either check (only if current bet amount is 0), call (match previous bet), raise (increase current bet by 2), or fold</li>
                    <li>     - Bet continues until everyone either folds or matches highest bet.</li>
                </ul>
            </span>
                </p>

                <p>Round 2:<br>
                    <span class="description-indent">
                First Better
                <ul class="bet-options">
                    <li>     - Can either check (bet nothing), call (bet 2), raise (bet 4), or fold</li>
                </ul>
            </span>
                    <span class="description-indent">
                Following Betters
                <ul class="bet-options">
                    <br><li>     - Can either check (only if current bet amount is 0), call (match previous bet), raise (increase current bet by 2), or fold</li>
                    <li>     - Bet continues until everyone either folds or matches highest bet.</li>
                </ul>
            </span>
                </p>

                <p>Round 3:<br>
                    <span class="description-indent">
                First Better
                <ul class="bet-options">
                    <li>     - Can either check (bet nothing), call (bet 4), raise (bet 8), or fold</li>
                </ul>
            </span>
                    <span class="description-indent">
                Following Betters
                <ul class="bet-options">
                   <br><li>     - Can either check (only if current bet amount is 0), call (match previous bet), raise (increase current bet by 4), or fold</li>
                    <li>     - Bet continues until everyone either folds or matches highest bet.</li>
                </ul>
            </span>
                </p>

                <p>Round 4:<br>
                    <span class="description-indent">
                First Better
                <ul class="bet-options">
                    <li>     - Can either check (bet nothing), call (bet 4), raise (bet 8), or fold</li>
                </ul>
            </span>
                    <span class="description-indent">
                Following Betters
                <ul class="bet-options">
                    <br><li>     - Can either check (only if current bet amount is 0), call (match previous bet), raise (increase current bet by 4), or fold</li>
                    <li>     - Bet continues until everyone either folds or matches highest bet.</li>
                </ul>
            </span>
                </p>

                <p>Round 5:<br>
                    <span class="description-indent">
                First Better
                <ul class="bet-options">
                    <li>     - Can either check (bet nothing), call (bet 4), raise (bet 8), or fold</li>
                </ul>
            </span>
                    <span class="description-indent">
                Following Betters
                <ul class="bet-options">
                    <br><li>     - Can either check (only if current bet amount is 0), call (match previous bet), raise (increase current bet by 4), or fold</li>
                    <li>     - Bet continues until everyone either folds or matches highest bet.</li>
                </ul>
            </span>
                </p>
            </div>
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
