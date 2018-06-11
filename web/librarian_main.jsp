<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 10.06.18
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jnfkrtjgt</title>
</head>
<body>
<form method="post" action="MainRedirectingLibrerian">
    <p>Wellcome to the librarian Panel</p>
    <td><input type="submit" name="logout_lib" value="Log out" /></td>
    <br>
    <td><input type="submit" name="addbook_lib" value="Add Book" /></td>
    <br>
    <td><input type="submit" name="serchbook_lib" value="Search Book" /></td>
    <br>
    <td><input type="submit" name="searchstudent_lib" value="Search Student" /></td>
    <br>
    <td><input type="submit" name="showNRA_lib" value="Show All !Return Books" /></td>
    <br>

</form>
    <c:if test="${ sessionScope.role !=3 }">
        <c:redirect url="index.jsp"/>
    </c:if>

</body>
</html>
