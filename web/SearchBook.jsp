<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 10.5.2018 г.
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="bg">
<head>
    <title>SearchBook</title>
    <link href="css/SearchBook.css" rel="stylesheet">
</head>
<body>
<div id="login_form">
    <form name="f1" action="SearchBookController" method="POST" id="f1"><br>
        <div class="table">
            <label class="f1_label">Баркод :</label><br>
            <input name="barcode"
                   oninput="maxLengthCheck(this)"
                   type = "number"
                   maxlength ="10"
                   minlength="10"
                   min = "1"/>
            <script>
                function maxLengthCheck(object){
                    if (object.value.length > object.maxLength)
                        object.value = object.value.slice(0, object.maxLength)
                }
            </script>
            <input type="submit" name="login" value="Потвърди" style="font-size:18px; " />
        </div>


        <c:if test="${sessionScope.role !=1 && sessionScope.role !=3}">
            <c:redirect url="index.jsp"/>
        </c:if>
    </form>
</div>
</body>
</html>
