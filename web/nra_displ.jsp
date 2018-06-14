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
</head>
<body>
<c:forEach var="asd" items="${requestScope.allnra}">
    <c:out value="${'Book Name:'} ${asd.getBook_name()} ${'|||Student Name:'} ${asd.getStudent_name()} ${'|||Return Date:'}${asd.getReturn_date()} ${'|||Is it returned:'} ${asd.isIs_return()} ${'|||Days left:'} ${activity.getGetDaysLeft()}"/><br />
</c:forEach>


<c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
    <c:redirect url="index.jsp"/>
</c:if>
</body>
</html>
