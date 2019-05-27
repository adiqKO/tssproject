<%--
  Created by IntelliJ IDEA.
  User: Daily
  Date: 26.05.2019
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja postu</title>
</head>
<body>
<a href="admin">Panel administracyjny</a>
<form method="post" action="edit">
    <h2 >Edytuj post</h2>
    <input name="inputId" type="hidden" value="${requestScope.post.id}" />
    <input name="inputTitle" type="text" placeholder="Tytuł" value="${requestScope.post.title}"
           required autofocus /><br/>
    <textarea name="inputContent" rows="5" name="inputUsername"
              placeholder="Treść" required autofocus>${requestScope.post.content}</textarea><br/>
    <input type="submit"
           value="Edytuj" />
</form>
</body>
</html>
