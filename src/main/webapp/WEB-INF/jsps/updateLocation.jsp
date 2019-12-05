<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Location</title>
</head>
<body>
<form action="updateLoc" method="post">
    <pre>
    Id: <input value="${location.id}" type="text" name="id" readonly/>
    Code: <input value="${location.code}" type="text" name="code"/>
    Name: <input value="${location.name}" type="text" name="name"/>
    Type: Urban<input type="radio" name="type" value="urban" ${location.type == 'urban'?'checked':''}/>
          Rural<input type="radio" name="type" value="rular" ${location.type == 'rular'?'checked':''}/>
    <input type="submit" value="save"/>
    </pre>
</form>
</body>
</html>
