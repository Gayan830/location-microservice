<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Location</title>
</head>
<body>
<form action="saveLoc" method="post">
    <pre>
    Id: <input type="text" name="id"/>
    Code: <input type="text" name="code"/>
    Name: <input type="text" name="name"/>
    Type: Urban<input type="radio" name="type" value="urban"/>
          Rural<input type="radio" name="type" value="rular"/>
    <input type="submit" value="save"/>
    </pre>
</form>
    ${msg}
<a href="displayLocations">View all</a>
</body>
</html>
