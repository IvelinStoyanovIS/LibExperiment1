<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivelin Stoyanov
  Date: 14.2.2018 Рі.
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/wrongLogin.css" rel="stylesheet">
    <title>Wrong Login</title>
</head>
<body>
<form method="post" action="login.jsp">
    <form method="post" action="LoginController1">

        <label>Username</label><br>
        <input type="text" name="userName" value=""/><br>
        <label>Password</label><br>
        <input type="password" name="password" value=""/><br>
        <input type="submit" name="submit" value="Login" />
        <input type="reset" name="reset" value="Reset" /><br>
        <label>Wrong username or password</label>



        <%--<c:if test="${sessionScope.username != null}">
            <c:redirect url="login.jsp"/>
        </c:if>--%>

        <c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
            <c:redirect url="index.jsp"/>
        </c:if>

    </center>
</form>
</body>
</html>>