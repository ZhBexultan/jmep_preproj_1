<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <h2>Login</h2>
    <form action="/login" method="post">
        Login: <input type="text" name="login" placeholder="Login" required><br>
        Password: <input type="password" name="password" placeholder="Password" required><br>
        <input type="submit" value="Login"><br>
    </form>
    <a href="/">Back to Main</a>
</div>
</body>
</html>
