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

</head>
<body>
<form method="post" action="MainRedirecting">
    <p>Wellcome to the Admin Panel</p>
    <td><input type="submit" name="logout" value="Log out" /></td>
    <br>
    <td><input type="submit" name="addbook" value="Add Book" /></td>
    <br>
    <td><input type="submit" name="serchbook" value="Search Book" /></td>
    <br>
    <td><input type="submit" name="searchstudent" value="Search Student" /></td>
    <br>
    <td><input type="submit" name="addstudent" value="Add Student" /></td>
    <br>
    <td><input type="submit" name="showNRA" value="Show All !Return Books" /></td>
    <br>
    <td><input type="submit" name="takebooks" value="Вземи/Върни книга" /></td>
    <br>

<c:if test="${sessionScope.username == null}">
<c:redirect url="index.jsp"/>
</c:if>



</form>
</body>
</html>
