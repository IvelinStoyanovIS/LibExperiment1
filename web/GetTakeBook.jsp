<%--
  Created by IntelliJ IDEA.
  User: biba
  Date: 07.06.18
  Time: 07:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form name="f1" action="TakeGetBook" method="POST" id="f1">
<table>
    <tr>
        <td class="f1_label">Баркод :</td><td><input type="text" name="barcode" value="" maxlength="10"/>
        <td class="f2_label">Дата на връщане :</td><td><input type="date" name="date" value="" />
    </td>
    </tr>
    <tr>
        <td>
            <input type="submit" name="login" value="Потвърди" style="font-size:18px; " />
        </td>
    </tr>
</table>
</form>
</body>
</html>
