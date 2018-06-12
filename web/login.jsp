<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="fname" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 27.03.18
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Logged in</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>
<p>logged in</p>
<div class="form">
    <form method="post" action="MainRedirecting">
        <div class=log-out><input type="submit" name="logout" value="Log out" /></div><br>
        <h3>Book</h3>
        <input type="submit" name="addbook" value="Add Book" />
        <br>
        <td><input type="submit" name="serchbook" value="Search Book" /></td>
        <br>
    </form>
    <form method="post" action="MainRedirecting">
        <h3>Student</h3>
        <input type="submit" name="searchstudent" value="Search Student" />
        <input type="submit" name="addstudent" value="Add Student" />
        <input type="submit" name="showNRA" value="Show All !Returned Books">


    </form>


<c:if test="${ sessionScope.role !=1}">
    <c:redirect url="index.jsp"/>
</c:if>
</body>
</html>
