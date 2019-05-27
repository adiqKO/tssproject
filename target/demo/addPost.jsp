<%--
  Created by IntelliJ IDEA.
  User: Daily
  Date: 25.05.2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie postu</title>
</head>
<body>
<a href="admin">Panel administracyjny</a>
<form method="post" action="add">
    <h2 >Dodaj post</h2>
    <input name="inputTitle" type="text" placeholder="Tytuł"
           required autofocus /><br/>
    <textarea name="inputContent" rows="5" name="inputUsername"
               placeholder="Treść" required autofocus></textarea><br/>
    <input type="submit"
           value="Dodaj!" />
</form>
</body>
</html>
