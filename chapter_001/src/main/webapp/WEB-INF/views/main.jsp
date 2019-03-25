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

</head>
<body>
<div>
    <h2><c:out value="${sessionScope.get('user')}"></c:out> Вы на главной странице.</h2>
</div>
<button type="button" class="btn btn-primary" onclick="location.href='./add'">Подать заявку на продажу </button>
<br>
Ddf

<div id="addCars">
    <img src="${pageContext.request.contextPath}/001.jpg"  class="rounded-circle" alt="Cinque Terre" width="304" height="236">
    <p> "${pageContext.request.contextPath}/001.jpg"</p>
</div>
<img src="img/001.JPG">
<%--<img alt="logo" src="<html:rewrite page='/resources/001.jpg'/>" width="100%" height="20%"/>--%>
<img alt="logo" src="./hello" />

</body>
</html>
