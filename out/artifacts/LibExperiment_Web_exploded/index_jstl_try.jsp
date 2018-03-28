<%--
  Created by IntelliJ IDEA.
  controllers.User: biba
  Date: 28.02.18
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>jstl page</title>
</head>
<body>

    <c:out value="${'jstl tag!'}"/>
    <c:set var="income" scope="session" value="${4000*4}"/>
    <p>before deleting value : <c:out value="${income}"/></p>
    <c:remove var="income"/>
    <p>after deleting value  <c:out value="${income}"/></p>



    <c:catch var ="catchtheException">
        <% int x = 2/0;%>
    </c:catch>

    <c:if test = "${catchtheException != null}">
        <p>типът на exception is : ${catchtheException} <br />
            има exception: ${catchtheException.message}</p>
    </c:if>


    <!--<h3> My name is ${name}</h3>--!>
</body>
</html>
