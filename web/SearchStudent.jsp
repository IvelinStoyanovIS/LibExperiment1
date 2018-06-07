<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 31.5.2018 г.
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student</title>
</head>
<body>
<div id="login_form">
    <form name="f1" action="SearchStudent" method="POST" id="f1">
        <table>
            <tr>
                <td class="f1_label">Курсов номер :</td><td>
                <input type="text" name="courseNumb" value="" maxlength="10"/>
            </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="login" value="Потвърди" style="font-size:18px; " />
                </td>
            </tr>
        </table>
        <c:if test="${sessionScope.username == null}">
            <c:redirect url="index.jsp"/>
        </c:if>
    </form>
</div>
</body>
</html>
