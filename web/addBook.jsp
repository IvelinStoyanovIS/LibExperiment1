<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivelin Stoyanov
  Date: 24.4.2018 г.
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="bg">
<head>
    <title>Book</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../CSS/Book.css">
</head>

<body>
<form action="BookController" method="POST" enctype="multipart/form-data">
    <legend>Въвеждане на книга</legend>
    <div class="form">
        Задължителните полета са със <font color="red">*</font><br><br>

        <label for="Barcode" class="redstar">Баркод:</label><br>
        <input name="Barcode"
               oninput="maxLengthCheck(this)"
               type = "number"
               maxlength ="10"
               min = "1"/>
        <script>
            function maxLengthCheck(object)
            {
                if (object.value.length > object.maxLength)
                    object.value = object.value.slice(0, object.maxLength)
            }
        </script><br><br>

        <input type="submit" value="Потвърди"><br><br>
        <label for="BookBarcode" class="redstar"> Баркод на книгата:</label><br>
        <input type="text" name="BookBarcode" required> <br>
        <label for="BookName" class="redstar"> Име на книгата:</label><br>
        <input type="text" name="BookName" required> <br>
        <label for="BookAutor" class="redstar">Автор:</label><br>
        <input type="text" name="BookAutor" required><br>
        <label for="BookGenre">Жанр:</label><br>
        <input type="text" name="BookGenre"><br>
        <label for="BookPublisher">Издателство:</label><br>
        <input type="text" name="BookPublisher"><br>

        <label for="BookDescription">Описание:</label><br>
        <textarea name="BookDescription"></textarea><br>
        <label for="BookDate">Година на издаване:</label><br>
        <input type="text" name="BookDate"><br>
        <label for="BookImage">Снимка:</label><br>
        <input type="text" name="BookImage"><br>
        <input type="file" name="file" id="ImageFile" />

        <br> <input type="submit" value="Потвърди">
    </div>
    <c:if test="${sessionScope.username == null}">
        <c:redirect url="index.jsp"/>
    </c:if>
</form>

</body>

</html>
