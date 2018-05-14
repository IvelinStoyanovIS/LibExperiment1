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
    <title>JSP Example</title>
</head>
<body bgcolor="silver">
<%-- <form method="post" action="login.jsp"> --%>
<form method="post" action="LoginController1">
    <center>
        <table border="0" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Page</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Username</td>
                <td><label>
                    <input type="text" name="userName" value=""/>
                </label></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><label>
                    <input type="password" name="password" value=""/>
                </label></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Login" /></td>
                <td><input type="reset" name="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">New User <a href="register.jsp">Register Here</a></td>
            </tr>
            </tbody>
        </table>




        <c:if test="${sessionScope.username != null}">
            <c:redirect url="login.jsp"/>
        </c:if>

    </center>
</form>
</body>
</html>>