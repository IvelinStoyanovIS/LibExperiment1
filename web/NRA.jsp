<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 7.6.2018 г.
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.Activity"%>
<html>
<head>
    <title>NRA</title>
</head>
<body>
<div id="login_form">
    <form name="f1" action="AllNonReturnBooksController" method="POST" id="f1">
        <table>
                <td>
                    <input type="submit" name="login" value="Потвърди" style="font-size:18px; " />

                </td>
            </tr>
        </table>

        <c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
            <c:redirect url="index.jsp"/>
        </c:if>
    </form>
</div>
</body>
</html>
