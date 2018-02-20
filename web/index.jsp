<%--
  Created by IntelliJ IDEA.
  User: Ivelin Stoyanov
  Date: 14.2.2018 г.
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h1>Примерна форма, hello servlets and controllers!</h1>

    <form action = "LoginController.java" method = "POST">
        Име:<br>
        <input type="text" name="firstname" value="Tom"><br>
        Фамилия:<br>
        <input type="text" name="lastname" value="Stoyanov"><br>
        <input type="submit" value="Submit">
    </form>


</body>
</html>
