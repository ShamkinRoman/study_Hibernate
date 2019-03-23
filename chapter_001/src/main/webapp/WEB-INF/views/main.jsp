<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 22.03.2019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Магазин машин.</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h2>Вы на главной странице.</h2>
    <p>Войдите или зарегистрируйтесь.</p>
    <form action="/action_page.php">
        <div class="form-group">
            <label for="usr">Name:</label>
            <input type="text"  id="usr" name="username">
<br>
            <label for="pwd">Password:</label>
            <input type="password"  id="pwd" name="password">
        </div>
        <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="customRadio" name="example" value="customEx" checked="checked">
            <label class="custom-control-label" for="customRadio">Войти</label>
        </div>
        <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" class="custom-control-input" id="customRadio2" name="example" value="customEx">
            <label class="custom-control-label" for="customRadio2">Зарегестрироваться</label>
        </div>
        <button type="submit" class="btn btn-primary">Отправить</button>
    </form>
</div>

<div id="addCars">
    <img src="${pageContext.request.contextPath}/001.jpg"  class="rounded-circle" alt="Cinque Terre" width="304" height="236">
    <p> "${pageContext.request.contextPath}/001.jpg"</p>
</div>

</body>
</html>
