<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Locations</title>
</head>
<body>
    <h2>Locations</h2>
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>code</th>
                <th>name</th>
                <th>type</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${locations}" var="location">
            <tr>
                <td>${location.id}</td>
                <td>${location.code}</td>
                <td>${location.name}</td>
                <td>${location.type}</td>
                <td><a href="deleteLocation?id=${location.id}">delete</a></td>
                <td><a href="showUpdate?id=${location.id}">edit</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="showCreate">Add New Location</a>
</body>
</html>