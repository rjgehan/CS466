<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<style>
    :root {
        --primary-start: #241773;
        --primary-end: #724B98;
    }
    body {
        background: linear-gradient(to bottom, var(--primary-start), var(--primary-end));
        margin: 0;
        background-repeat: no-repeat;
        background-attachment: fixed;
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
</style>