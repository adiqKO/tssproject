<%--
  Created by IntelliJ IDEA.
  User: Daily
  Date: 22.05.2019
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zaloguj się</title>
</head>
<body>
<h1>Zaloguj się</h1>
<form action="j_security_check" method="post">
    Login: <input type="text" name="j_username">
    <br>
    Password: <input type="password" name="j_password">
    <input type="submit" value="Zaloguj">
</form>
</body>
</html>
