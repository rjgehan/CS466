<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="styles.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Picture Picker</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .image-picker {
            text-align: center;
        }

        #selected-images {
            margin-top: 20px;
        }

        img {
            max-width: 100px;
            margin-right: 10px;
        }

        .image-button {
            margin: 5px;
            padding: 10px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .image-button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<div class="image-picker">
    <h2>Choose Your Profile Picture</h2>
    <div id="selected-images"></div>


    <div>
        <button class="image-button" onclick="selectImage('image1.png')">Image 1</button>
        <button class="image-button" onclick="selectImage('image2.png')">Image 2</button>
        <button class="image-button" onclick="selectImage('image3.png')">Image 3</button>
        <button class="image-button" onclick="selectImage('image4.png')">Image 4</button>
        <button class="image-button" onclick="selectImage('image5.png')">Image 5</button>
        <button class="image-button" onclick="selectImage('image6.png')">Image 6</button>
        <button class="image-button" onclick="selectImage('image7.png')">Image 7</button>
        <button class="image-button" onclick="selectImage('image8.png')">Image 8</button>
        <button class="image-button" onclick="selectImage('image9.png')">Image 9</button>
        <button class="image-button" onclick="selectImage('image10.png')">Image 10</button>
        <button class="image-button" onclick="selectImage('image11.png')">Image 11</button>
        <button class="image-button" onclick="selectImage('image12.png')">Image 12</button>
        <button class="image-button" onclick="selectImage('image13.png')">Image 13</button>
        <button class="image-button" onclick="selectImage('image14.png')">Image 14</button>
        <button class="image-button" onclick="selectImage('image15.png')">Image 15</button>
    </div>


    <div id="confirmation"></div>
</div>

<script>

    var selectedImage = null;


    function selectImage(image) {
        selectedImage = '/images/PNG/Roster Images/' + image;

        var confirmationDiv = document.getElementById('confirmation');
        confirmationDiv.innerHTML = 'Selected Profile Picture: <img src="' + selectedImage + '" alt="Selected Image">';
    }
</script>

</body>
</html>
