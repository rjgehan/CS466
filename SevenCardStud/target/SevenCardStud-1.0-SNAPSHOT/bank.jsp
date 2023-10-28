<!DOCTYPE html>
<html>
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <title>Database Data</title>
    <style>
        /* Center the button horizontally */
        #getDataButton {
            display: block;
            margin: 0 auto;
        }

        /* Make the counter larger */
        #counter {
            text-align: center;
            font-size: 72px;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <button id="getDataButton">Get Data</button>
</div>
<div id="dataContainer"></div>
<div id="counter">Balance: <span id="count">0</span></div>

<script>
    let countValue = 0;

    document.getElementById("getDataButton").addEventListener("click", () => {
        alert("Button clicked!");

        countValue += 50;
        document.getElementById('count').innerText = countValue;

        if (countValue > 0) {
            document.getElementById("getDataButton").style.display = "none";
        }

    });
</script>
</body>
</html>
