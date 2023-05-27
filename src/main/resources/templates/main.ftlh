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
            <div id="search-tasks" style="display: none">
                <button value="all" onclick="searchByName(event)">All</button>
                <button value="created" onclick="searchByName(event)">Created</button>
                <button value="done" onclick="searchByName(event)">Done</button>
                <button value="failed" onclick="searchByName(event)">Failed</button>
                <button value="progress" onclick="searchByName(event)">Progress</button>
            </div>
        </div>
        <div id="content">
            <div id="pages">
                <button onclick="prevPage(event)">0</button>
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
                <div class="row" id="list-change" style="display: none">
                    <div class="content-tasks" id="list-buttons">

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
                <a href="/register">

                </a>
            </div>
            <div id="login-button" style="display: block">
                <a href="/login">
                    <button type="button">Login</button>
                </a>
            </div>
            <div id="create-task" style="display: none">
                <a href="manager">
                    <button>Create Task</button>
                </a>
            </div>
        </div>
    </div>
</div>
<script src="../script.js"></script>
</body>
</html>