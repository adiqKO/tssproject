<%--
  Created by IntelliJ IDEA.
  User: Daily
  Date: 22.05.2019
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Panel administracyjny</title>
</head>
<body>
    <h1>Witaj ${sessionScope.user.user_name}</h1>
    <h3>Panel administracyjny</h3>
    <a href="posts">Posty</a><br/>
    <a href="webapi/myresource">Posty JSON</a><br/>
    <a href="chartSocket">Wykres WebSocket</a><br/>
    <a href="chartRest">Wykres Rest</a><br/>
    <br/>
    <a href="logout">Wyloguj</a>
</body>
</html>