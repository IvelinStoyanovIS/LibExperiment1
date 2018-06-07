<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 9.5.2018 г.
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show Book Page</title>
</head>
<body>
<h3> Book id is ${bookid}</h3>
<h3> Book name is ${bookname}</h3>
<h3> Book author is ${bookauthor}</h3>
<h3> Book genre is ${bookgenre}</h3>
<h3> Book publisher is ${bookpublisher}</h3>
<h3> Book description: ${bookdescription}</h3>
<h3> Book date is ${bookdate}</h3>
<h3> Book image: ${bookimage}</h3>

<img src="${path}">


<c:if test="${sessionScope.username == null}">
    <c:redirect url="index.jsp"/>
</c:if>

</body>
</html>
