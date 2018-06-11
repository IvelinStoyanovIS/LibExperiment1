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
    <title>Title</title>
</head>
<body>
<p>WRONG COURSE NUMBER</p>


<c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
    <c:redirect url="index.jsp"/>
</c:if>

</body>
</html>
