<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="start" method="post">
    <label>Введите имя: </label>
    <input type="text" name="name" placeholder="Name" required>
    <input type="hidden" name="title" value="BEGINNING">
    <input type="submit">
</form>
<br/>
<a href="start">Start</a>
</body>
</html>