<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="../main.css">
    <title>Main</title>
</head>
<body>
<div class="container">
    <div id="main">
        <div id="left-column">

        </div>
        <div id="content">
            <div id="pages">
                <button onclick="nextPage('page-0',event)">0</button>
            </div>
            <div class="content-container">
                <div class="row">
                    <div class="content-tasks" id="name">
                        <p>Name</p>
                    </div>
                </div>
                <div class="row">
                    <div class="content-tasks" id="status">
                        <p>Status</p>
                    </div>
                </div>
                <div class="row">
                    <div class="content-tasks" id="developer">
                        <p>Developer</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="right-column">
            <p id="username" style="display:block;"></p>
            <div id="logout-button" style="display: none">
                <a href="/logout">
                    <button>Logout</button>
                </a>
            </div>
            <div id="login-button" style="display: block">
                <a href="/login">
                    <button type="button">Login</button>
                </a>
            </div>
        </div>
    </div>
</div>
<script src="../script.js"></script>
</body>
</html>