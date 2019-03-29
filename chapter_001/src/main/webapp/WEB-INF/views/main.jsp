<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 22.03.2019
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>--%>
<html>
<head>
    <title>Магазин машин.</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
    function printCar() {
        var xhr = new XMLHttpRequest();
        // var check = document.getElementById("check_show_all").checked;
        // var all_task = "no";
        // if (check) {
        //     all_task = "all";
        // }
        xhr.open("GET", "./getitems", false);
        xhr.send();
        var response = xhr.responseText;
        var tasks = JSON.parse(response);
        alert (tasks)

    }
    </script>
</head>
<body>
<div>
    <h2><c:out value="${sessionScope.get('user')}"></c:out> Вы на главной странице.</h2>
</div>
<button type="button" class="btn btn-primary" onclick="location.href='./add'">Подать заявку на продажу</button>
<br>
<br>
Список объявлений!
<table>
    <thead>
    <tr>
        <th>№ объявления</th>
        <th>Картинка</th>
        <th>Характеристики</th>
        <th>продана/не продана</th>
    </tr>
    </thead>
    <thead id="finishCar">

    </thead>
</table>


<img alt="logo" src="./hello"/>

<br>
<br>
<input type="button" onclick="printCar()" value="Wagh">
</body>
</html>
