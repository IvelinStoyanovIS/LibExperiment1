<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="fname" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 27.03.18
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Logged in</title>

</head>
<body>
<form method="post" action="LogoutController">
    <p>loooooogggedddd</p>
<tr>username="<%=request.getSession().getAttribute("username")%>"</tr>
<br>
<tr>password="<%=request.getSession().getAttribute("password")%>"</tr>
<br>
<td><input type="submit" name="logout" value="Log out" /></td>
<br>

<c:if test="${sessionScope.username == null}">
<c:redirect url="index.jsp"/>
</c:if>



</form>
</body>
</html>
