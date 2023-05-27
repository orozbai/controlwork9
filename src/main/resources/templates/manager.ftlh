<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="../main.css">
    <title>Manager</title>
</head>
<body>
<div class="container">
    <div id="content">
        <p>Create task</p>
        <div id="create-task">
            <form method="post">
                <meta name="csrf-token" content="${_csrf.token}"/>
                <label for="create-select"></label>
                <select id="create-select">
                </select>
                <label>
                    <input name="name" id="select-input-name" maxlength="20" minlength="1" type="text"
                           placeholder="Name">
                </label>
                <button id="submit-create" type="submit">Save</button>
            </form>
        </div>
    </div>
</div>
<script src="../manager.js"></script>
</body>
</html>