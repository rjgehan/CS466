<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<style>
    :root {
        --primary-start: #241773;
        --primary-end: #724B98;
    }
    body {
        background-image: url('images/PNG/otherBackground.png'); /* Path to your image */
        background-size: cover; /* Cover the entire page */
        background-position: center center; /* Center the image on the page */
        background-repeat: no-repeat; /* Do not repeat the image */
        background-attachment: fixed; /* Optional: Fix the background image during scroll */
    }
    .header {
        background-color: #29134B;
        color: white;
        padding: 20px;
        text-align: center;
    }
    .btn-custom {
        background-color: white;
        color: var(--primary-start);
        border: 2px solid var(--primary-start);
        padding: 10px 20px;
        text-align: center;
        display: inline-block;
        text-decoration: none;
        margin: 10px;
        border-radius: 5px;
    }
    .text {
        color: white;
    }
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=password], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=email], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    .modal {
         display: none;
         position: fixed;
         z-index: 1;
         left: 0;
         top: 0;
         width: 100%;
         height: 100%;
         overflow: auto;
         background-color: rgba(0, 0, 0, 0.4);
     }

    .modal-content {
        background-color: #f4f4f4;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 30%;
        height: 30%;
        text-align: center;
    }

    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover {
        color: black;
    }
</style>