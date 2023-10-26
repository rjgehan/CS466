<!DOCTYPE html>
<html>
<head>
    <title>Database Data</title>
</head>
<body>
<button id="getDataButton">Get Data</button>
<div id="dataContainer"></div>

<script>
    document.getElementById("getDataButton").addEventListener("click", () => {
        alert("Button clicked!");

        fetch('/retrieveData')
            .then(response => {
                console.log("Response Status Code:", response.status);

                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Request failed with status: " + response.status);
                }
            })
            .then(data => {
                // Handle the response data, e.g., display it on the page
                document.getElementById('dataContainer').innerText = JSON.stringify(data, null, 2);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
</script>
</body>
</html>
