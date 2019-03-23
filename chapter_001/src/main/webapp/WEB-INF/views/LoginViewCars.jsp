<%--
  Created by IntelliJ IDEA.
  User: Up
  Date: 16.01.2019
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>LoginViewCarsJSP</title>
</head>
<body>
Войдите или зарегистрируйтесь<br>
<c:if test="${error != ''}">
    <div style="color: red">
        <c:out value="${error}"/>
    </div>
</c:if>

<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    <div class="form-group">
        <label for="usr">Login:</label>
        <input type="text" id="usr" name="login">
        <br>
        <label for="pwd">Password:</label>
        <input type="password" id="pwd" name="password">
    </div>
    <div class="custom-control custom-radio custom-control-inline">
        <input type="radio" class="custom-control-input" id="customRadio" name="enter" value="enter"
               checked="checked">
        <label class="custom-control-label" for="customRadio">Войти</label>
    </div>
    <div class="custom-control custom-radio custom-control-inline">
        <input type="radio" class="custom-control-input" id="customRadio2" name="enter" value="registration">
        <label class="custom-control-label" for="customRadio2">Зарегестрироваться</label>
    </div>
    <button type="submit" class="btn btn-primary">Отправить</button>
</form>
</body>
</html>
