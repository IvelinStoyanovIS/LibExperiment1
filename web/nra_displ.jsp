<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 14.06.18
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Activity"%>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>

<table style="width:70% ">
    <tr>
        <th>Име на книгата </th>
        <th>Име на ученик </th>
        <th>Дата за връщане </th>
        <th>Оставащи дни</th>
        <th>Върната ли е книгата </th>
    </tr>
<c:forEach var="asd" items="${requestScope.allnra}">
    <tr>
        <td>${asd.getBook_name()}</td>
        <td>${asd.getStudent_name()}</td>
        <td>${asd.getReturn_date()}</td>
        <td>${asd.getLeftDays()}</td>
        <c:if test = "${asd.isIs_return() == false}">
            <td><c:out value = "${'Не'}"/></td>
        </c:if>

    </tr>
    </c:forEach>


<c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
    <c:redirect url="index.jsp"/>
</c:if>
</body>
</html>
