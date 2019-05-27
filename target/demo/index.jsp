<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Strona Główna</title>
</head>
<body>
    <h2>Tss Project</h2>
    <a href="admin">Panel administracyjny</a><br/>
    <a href="chartSocket">Wykres WebSocket</a><br/>
    <br/>
    <c:if test="${not empty sessionScope.user}">
        <a href="logout">Wyloguj</a>
    </c:if>
</body>
</html>
