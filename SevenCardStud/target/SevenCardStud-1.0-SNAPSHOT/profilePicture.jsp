<%@ page import="com.example.sevencardstud.model.entity.User" %>
<%@ page import="com.example.sevencardstud.dao.UserDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <%
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");
        if (loggedInUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String updateImage = request.getParameter("updateImage");
        String selectedImage = request.getParameter("selectedImage");

        if ("true".equals(updateImage) && selectedImage != null && !selectedImage.isEmpty()) {
            UserDAO userDAO = new UserDAO();
            userDAO.setSelectedImage(loggedInUser.getUsername(), selectedImage);
            loggedInUser.setSelectedImage(selectedImage);
            request.getSession().setAttribute("loggedInUser", loggedInUser);
        }
    %>

    <a href="home.jsp" class="btn-custom">Home</a> <br/>
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
            height: 85vh;
            margin: 0;
            padding-right: 200px;
            padding-left: 200px;
            background-image: url('images/PNG/profile.png'); /* Path to your image */
            background-size: cover; /* Cover the entire page */
            background-position: center center; /* Center the image on the page */
            background-repeat: no-repeat; /* Do not repeat the image */
            background-attachment: fixed; /* Optional: Fix the background image during scroll */
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
            background-color: #729;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }


        h2, #confirmation {
            color: white;
        }


        .image-button:hover {
            background-color: #7295;
        }
    </style>
</head>
<body>


<div class="image-picker">
    <h2>Choose Your Profile Picture</h2>
    <div id="selected-images"></div>


    <!-- Display buttons for images 1-15 -->
    <button class="image-button" name="action" onclick="selectImage('image1.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image1.png" alt="Image 1">
        <div class="image-label">Nelson Agholor</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image2.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image2.png" alt="Image 2">
        <div class="image-label">Mark Andrews</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image3.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image3.png" alt="Image 3">
        <div class="image-label">Jalyn Armour-Davis</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image4.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image4.png" alt="Image 4">
        <div class="image-label">Malaesala Aumavae-Laulu</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image5.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image5.png" alt="Image 5">
        <div class="image-label">Rashod Bateman</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image6.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image6.png" alt="Image 6">
        <div class="image-label">Odell Beckham Jr.</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image7.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image7.png" alt="Image 7">
        <div class="image-label">Ben Cleveland</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image8.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image8.png" alt="Image 8">
        <div class="image-label">Jadeveon Clowney</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image9.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image9.png" alt="Image 9">
        <div class="image-label">Ronald Darby</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image10.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image10.png" alt="Image 10">
        <div class="image-label">Devin Duvernay</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image11.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image11.png" alt="Image 11">
        <div class="image-label">Gus Edwards</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image12.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image12.png" alt="Image 12">
        <div class="image-label">Daniel Faalele</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image13.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image13.png" alt="Image 13">
        <div class="image-label">Zay Flowers</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image14.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image14.png" alt="Image 14">
        <div class="image-label">Kyle Hamilton</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image15.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image15.png" alt="Image 15">
        <div class="image-label">Malik Harrison</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image16.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image16.png" alt="Image 16">
        <div class="image-label">Justice Hill</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image17.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image17.png" alt="Image 17">
        <div class="image-label">Marlon Humphrey</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image18.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image18.png" alt="Image 18">
        <div class="image-label">Tyler Huntley</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image19.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image19.png" alt="Image 19">
        <div class="image-label">Lamar Jackson</div>
    </button>


    <button class="image-button" name="action" onclick="selectImage('image20.png')">
        <img src="<%= request.getContextPath() %>/images/PNG/Roster Images/image20.png" alt="Image 20">
        <div class="image-label">Josh Johnson</div>
    </button>

    <div id="confirmation"></div>
</div>

<script>

    var selectedImage = null;

    function selectImage(image) {
        selectedImage = '<%= request.getContextPath() %>/images/PNG/Roster Images/' + image;

        var confirmationDiv = document.getElementById('confirmation');
        confirmationDiv.innerHTML = 'Selected Profile Picture: <img src="' + selectedImage + '" alt="Selected Image">';

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '<%= request.getRequestURI() %>', true);
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.send('updateImage=true&selectedImage=' + encodeURIComponent(selectedImage));
    }

</script>
</body>
</html>
