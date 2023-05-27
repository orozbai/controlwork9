<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="../main.css">
    <title>worklog</title>
</head>
<body>
<div class="container">
    <div>
        <div class="content-container">
            <div class="row">
                <p>Date Time</p>
                <div class="content-tasks" id="created">

                </div>
            </div>
            <div class="row">
                <p>Time</p>
                <div class="content-tasks" id="time">

                </div>
            </div>
            <div class="row">
                <p>Description</p>
                <div class="content-tasks" id="description">

                </div>
            </div>
        </div>
    </div>
    <div id="worklog">
        <form method="post">
            <label for="worklog-time">Time</label>
            <input type="text" maxlength="6" minlength="1" placeholder="time" id="worklog-time">
            <label for="worklog-description">Description</label>
            <input type="text" maxlength="50" minlength="1" placeholder="description" id="worklog-description">
            <meta name="csrf-token" content="${_csrf.token}"/>
            <button type="submit" id="worklog-button">Add</button>
        </form>
    </div>
</div>
<script src="../workLog.js"></script>
</body>
</html>