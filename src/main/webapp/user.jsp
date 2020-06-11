<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <b>Login: </b> <c:out value="${sessionScope.user.email}" /><br>
    <b>Name: </b> <c:out value="${sessionScope.user.name}" /><br>
    <a href="/logout">Logout</a>
</body>
</html>
