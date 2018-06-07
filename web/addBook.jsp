<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivelin Stoyanov
  Date: 24.4.2018 г.
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="bg">
<head>
    <link rel="stylesheet" type="text/css" href="css/addBook.css">

    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700%7CAllura" rel="stylesheet">


    <script>
        function validate(evt) {
            var theEvent = evt || window.event;
            var key = theEvent.keyCode || theEvent.which;
            key = String.fromCharCode( key );
            var regex = /[0-9]+|[\b]/;
            if( !regex.test(key) ) {
                theEvent.returnValue = false;
                if(theEvent.preventDefault) theEvent.preventDefault();
            }
        }
    </script>




    <title>Въвеждане на книга</title>
    <meta charset="UTF-8">
</head>

<body>
<form action="BookController" method="POST" enctype="multipart/form-data">
    <div class="form">

        <label for="BookBarcode">Баркод на книгата:<font color="red">*</font><br>
            <input type="text" name="BookBarcode" maxlength="10" onkeypress='validate(event)' required="required"> <br>
            <label for="BookName" class="redstar" > Име на книгата:<font color="red">*</font></label><br>
            <input type="text" name="BookName" maxlength="255" required="required"> <br>
            <label for="BookAutor">Автор:<font color="red">*</font></label><br>
            <input type="text" name="BookAutor"  maxlength="255" required="required"><br>
            <label for="BookGenre">Жанр:</label><br>
            <input type="text" name="BookGenre" maxlength="255"><br>
            <label for="BookPublisher">Издателство:</label><br>
            <input type="text" name="BookPublisher" maxlength="255"><br>
            <label for="BookDescription">Описание:</label><br>
            <textarea name="BookDescription"></textarea><br>
            <label for="BookDate">Година на издаване:</label><br>
            <input type="text" name="BookDate"><br>
            <label for="BookImage">Снимка:</label><br>
            <input type="file" name="file" id="ImageFile"/><br>

            <br> <input type="submit" value="Потвърди">
        </label>
    </div>
    <c:if test="${sessionScope.username == null}">
        <c:redirect url="index.jsp"/>
    </c:if>
</form>

</body>

</html>