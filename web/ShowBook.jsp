<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 9.5.2018 г.
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Show Book Page</title>
    <link href="css/ShowBook.css" rel="stylesheet">
</head>
<body>
<div class="divOutside">
    <div class="divInside">
        <br>
        <h3> Book id is ${bookid}</h3>
        <h3> Book name is ${bookname}</h3>
        <h3> Book author is ${bookauthor}</h3>
        <h3> Book genre is ${bookgenre}</h3>
        <h3> Book publisher is ${bookpublisher}</h3>
        <h3> Book description: ${bookdescription}</h3>
        <h3> Book date is ${bookdate}</h3>
        <h3> Book image: ${bookimage}</h3>
        <h3> Book path image: ${path}</h3>
    </div>
    <div class="pic">
        <img src="${path}" alt="noPic" width="100" height="100">
    </div>
</div>

<c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
    <c:redirect url="index.jsp"/>
</c:if>

</body>
</html>
