<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 03.06.18
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="bg">
<head>
    <title>Add Stuent</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/AddStudent.css">
</head>
<body>
<form action="StudentController" method="POST" enctype="multipart/form-data">

    <label for="StudentName" class="redstar"> Имена на ученик:<font color="red">*</font></label><br>
    <input type="text" name="StudentName" maxlength="255" required="required"> <br>
    <label for="StudentCourseNumb" class="redstar" > Курсов номер:<font color="red">*</font></label><br>
    <input type="number" name="StudentCourseNumb" maxlength="255" required="required"> <br>
    <label for="StudentEmail" class="redstar">E-mail:<font color="red">*</font></label><br>
    <input type="text" name="StudentEmail"  maxlength="255" required="required"><br>
    <label>Снимка:</label>
    <input type="file" name="file" id="ImageFile"/><br>

    <br> <input type="submit" value="Потвърди">

</form>


    <c:if test="${sessionScope.role != 1 }">
        <c:redirect url="librarian_main.jsp"/>
    </c:if>


</body>
</html>
