<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 14.5.2018 г.
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="bg">
<head>



    <title>Students</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">


    <!-- Font -->

    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700%7CAllura" rel="stylesheet">

    <!-- Stylesheets -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">


</head>
<body>


<section class="intro-section">
    <div class="container">

        <div class="intro">
            <div class="row">

                <div class="col-sm-8 col-md-4 col-lg-3">
                    <div class="profile-img margin-b-30">
                        <img src="${path}" alt="NO Image"></div>
                </div><!-- col-sm-8 -->

                <div class="col-sm-10 col-md-5 col-lg-6">
                    <div class="padd">
                        <h2><b>${studentname}</b></h2>
                        <h4 class="font-yellow">Брой прочетени книги: ${readbooks}</h4> </div>
                    <ul class="information margin-tb-30">
                        <li><b class="font-yellow">Курсов номер</b> : ${coursenumb}</li>
                        <li><b class="font-yellow">E-mail</b> : ${email}</li>
                        <li><b class="font-yellow">Текущо взета книга</b> : ${currentbook}</li>
                    </ul>
                </div><!-- col-sm-8 -->

                <div class="col-sm-10 col-md-3 col-lg-3">
                    <a class="downlad-btn" href="GetTakeBook.jsp">Вземи/Върни книга</a>
                </div><!-- col-lg-2 -->

            </div>
            </div>
        </div>
    </div>

            </div><!-- row -->

        </div><!-- intro -->
    </div><!-- container -->
</section><!-- intro-section -->


</body>
</html>

