<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<div>
    <h2>Update User</h2>
    <form action="/editUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        Name: <input type="text" name="name" value="${user.name}" required><br>
        Email: <input type="email" name="email" value="${user.email}" required><br>
        <input type="submit" value="Update">
    </form>
    <a href="/">Back</a>
</div>
</body>
</html>
