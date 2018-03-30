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
    <p>loooooogggedddd</p>
    <tr>username="<%=request.getSession().getAttribute("username")%>"</tr>
    <br>
    <tr>password="<%=request.getSession().getAttribute("password")%>"</tr>

    <c:if test="${sessionScope.firstname != null}">
        <p>heeeeeeellllllooooo</p>
    </c:if>




<%--<%= request.getParameter("person1.firstName") %>--%>
</body>
</html>
