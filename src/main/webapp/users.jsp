<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<head>
    <title>JMEP</title>
</head>
<body>
    <div>
        <h2>Add User</h2>
        <form method="post">
            Name: <input type="text" name="name" placeholder="Name" required><br>
            Email: <input type="email" name="email" placeholder="Email" required><br>
            <input type="submit" value="ADD">
        </form>
    </div>

    <div>
        <h2>Users</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${users != null}">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.name}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td><a href="editUser?id=${user.id}">Edit</a></td>
                        <td>
                            <form action="/deleteUser" method="post">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</body>
</html>