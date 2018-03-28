<%--@elvariable id="fname" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 27.03.18
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged in</title>
    <p>loooooogggedddd</p>
</head>
<body>
    <h3> My name is ${fname}</h3>
    <%= request.getParameter("fname") %>
    <% String id = request.getParameter("person1.firstName"); %>
    <h3> My name is "<%=id%>"</h3>

</form>

<%--<%= request.getParameter("person1.firstName") %>--%>
</body>
</html>
