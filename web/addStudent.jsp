<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 03.06.18
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form action="StudentController" method="POST" enctype="multipart/form-data">

    <label for="StudentName" class="redstar"> ****Имена на ученик:</label><br>
    <input type="text" name="StudentName" maxlength="255" required="required"> <br>
    <label for="StudentCourseNumb" class="redstar" > ****Курсов номер:</label><br>
    <input type="text" name="StudentCourseNumb" maxlength="5" required="required"> <br>
    <label for="StudentEmail" class="redstar">****E-mail:</label><br>
    <input type="text" name="StudentEmail"  maxlength="255" required="required"><br>
    <%--<label for="StudentReadBooks">прочетени книги:</label><br>
    <input type="number" name="StudentReadBooks"><br>
    <label for="StudentCurrentBook">Текуща книга:</label><br>
    <input type="text" name="StudentCurrentBook" maxlength="255"><br>--%>
    <input type="file" name="file" id="ImageFile"/><br>


    <br> <input type="submit" value="Потвърди">

    <c:if test="${sessionScope.role != 1 && sessionScope.role != 3}">
        <c:redirect url="librarian_main.jsp"/>
    </c:if>


</body>
</html>
