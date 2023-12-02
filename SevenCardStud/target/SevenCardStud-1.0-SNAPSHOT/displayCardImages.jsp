<!DOCTYPE html>
<html>
<head>
    <title>Poker Hands</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-image: url('images/PNG/otherBackground.png');
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            position: fixed;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            background-color: rgba(255, 255, 255, 0.9);
            padding: 10px 20px;
            border-radius: 5px;
            z-index: 1;
            color: black;
        }

        .scroll-box {
            width: 30%;
            height: 60vh;
            overflow-y: auto;
            border-radius: 10px;
            padding: 20px;
            margin-top: 125px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            color: white;
        }

        .content {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 10px;
            max-height: calc(100% - 40px);
            overflow-y: auto;
            width: 100%;
        }

        .hand {
            text-align: center;
        }

        .hand p {
            margin-bottom: 5px;
        }

        .content img {
            width: 50px;
            height: auto;
            border: 1px solid #333;
            border-radius: 5px;
            margin-left: 5px;
        }
    </style>
</head>
<body>
<h1>Winning Poker Hands</h1>

<div class="scroll-box">
    <div class="content">
        <div>
            <p>Royal Flush</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades10.png" alt="Royal Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesJ.png" alt="Royal Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesQ.png" alt="Royal Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesK.png" alt="Royal Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesA.png" alt="Royal Flush">
        </div>

        <div class="hand straight-flush">
            <p>Straight Flush</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts2.png" alt="Straight Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts3.png" alt="Straight Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts4.png" alt="Straight Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts5.png" alt="Straight Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts6.png" alt="Straight Flush">
        </div>

        <div class="hand four-of-a-kind">
            <p>Four of a Kind</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardClubs2.png" alt="Four of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades2.png" alt="Four of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds2.png" alt="Four of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts2.png" alt="Four of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesK.png" alt="Four of a Kind">
        </div>

        <div class="hand full-house">
            <p>Full House</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds5.png" alt="Full House">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardClubs5.png" alt="Full House">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts5.png" alt="Full House">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHeartsQ.png" alt="Full House">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesQ.png" alt="Full House">
        </div>

        <div class="hand flush">
            <p>Flush</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades2.png" alt="Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades3.png" alt="Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades7.png" alt="Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades5.png" alt="Flush">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesJ.png" alt="Flush">
        </div>

        <div class="hand straight">
            <p>Straight</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades2.png" alt="Straight">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts3.png" alt="Straight">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds4.png" alt="Straight">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades5.png" alt="Straight">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardClubs6.png" alt="Straight">

        </div>

        <div class="hand three-of-a-kind">
            <p>Three of a Kind</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades7.png" alt="Three of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts7.png" alt="Three of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds7.png" alt="Three of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHeartsJ.png" alt="Three of a Kind">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades2.png" alt="Three of a Kind">
        </div>

        <div class="hand two-pair">
            <p>Two Pair</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesK.png" alt="Two Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHeartsK.png" alt="Two Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts4.png" alt="Two Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds4.png" alt="Two Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesQ.png" alt="Two Pair">
        </div>

        <div class="hand one-pair">
            <p>One Pair</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades10.png" alt="One Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardHearts10.png" alt="One Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesQ.png" alt="One Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds2.png" alt="One Pair">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades4.png" alt="One Pair">
        </div>

        <div class="hand high-card">
            <p>High Card</p>
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardClubs4.png" alt="High Card">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardClubs10.png" alt="High Card">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardDiamonds3.png" alt="High Card">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpades2.png" alt="High Card">
            <img src="${pageContext.request.contextPath}/images/PNG/Cards/cardSpadesK.png" alt="High Card">
        </div>
    </div>
</div>
</body>
</html>


