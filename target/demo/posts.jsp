<%--
  Created by IntelliJ IDEA.
  User: Daily
  Date: 25.05.2019
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Posty</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<a href="admin">Panel administracyjny</a>
<a href="add">Dodaj post</a>
<table>
    <tr>
        <th>Tytuł</th>
        <th>Treść</th>
        <th></th>
    </tr>
<c:if test="${not empty requestScope.posts}">
    <c:forEach var="post" items="${requestScope.posts}">
            <tr>
                <td><c:out value="${post.title}" /></td>
                <td><c:out value="${post.content}" /></td>
                <td>
                    <form action="edit">
                        <input name="inputId" type="hidden" value="${post.id}" />
                        <input type="submit" value="Edytuj" />
                    </form>
                    <form action="posts/delete/${post.id}">
                        <input type="submit" value="Usuń" />
                    </form>
                </td>
            </tr>

    </c:forEach>
</c:if>
</table>
</body>
</html>
