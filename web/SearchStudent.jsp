<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 31.5.2018 г.
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
!DOCTYPE html>
<html>
<head>
    <title>Search Student</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/SearchStuent.css">
</head>
<body>
<div id="login_form">
    <form name="f1" action="SearchStudent" method="POST" id="f1">
        <label class="f1_label">Курсов номер :</label>
        <input type="text" name="courseNumb" value="" maxlength="10"/>
        <input type="submit" name="login" value="Потвърди"/>

        <c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
            <c:redirect url="index.jsp"/>
        </c:if>
    </form>
</div>
</body>
</html>
