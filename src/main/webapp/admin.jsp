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
    <title>Admin</title>
</head>
<body>
    <b>Login: </b> <c:out value="${sessionScope.user.email}" /><br>
    <b>Name: </b> <c:out value="${sessionScope.user.name}" /><br>
    <a href="/logout">Logout</a>
    <div>
        <h2>Add User</h2>
        <form method="post">
            Name: <input type="text" name="name" placeholder="Name" required><br>
            Email: <input type="email" name="email" placeholder="Email" required><br>
            Password: <input type="password" name="password" placeholder="Password" required><br>
            Role: <select name="role">
                    <option value="admin">Admin</option>
                    <option value="user">User</option>
        </select>
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
                    <th>Role</th>
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
                        <td><c:out value="${user.role}" /></td>
                        <td><a href="editUser?id=${user.id}">Edit</a></td>
                        <td>
                            <form action="/admin/deleteUser" method="post">
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