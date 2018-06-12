<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 07.06.18
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        img {
            display: block;
            margin-left: auto;
            margin-right: auto;
            position: fixed;
        }
    </style>
</head>
<body>

<img src="images/PersonNotFound.png" alt="Wrong course number" style="width:50%;">


<c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
    <c:redirect url="index.jsp"/>
</c:if>
</body>
</html>
