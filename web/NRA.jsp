<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 7.6.2018 г.
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h3> ${book_name}</h3>
        <h3> ${student_name}</h3>
        <h3> ${return_date}</h3>
        <h3> ${is_return}</h3>

        <c:if test="${sessionScope.username == null}">
            <c:redirect url="index.jsp"/>
        </c:if>
    </form>
</div>
</body>
</html>
