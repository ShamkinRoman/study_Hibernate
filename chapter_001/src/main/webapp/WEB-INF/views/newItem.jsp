<%--
  Created by IntelliJ IDEA.
  User: Up
  Date: 23.03.2019
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Новая машина на продажу</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
        function sendBody() {
            var bodyCar = isCheck("bodyCar").value;
            var engine = isCheck("engine").value;
            var transmission = isCheck("transmission").value;
            var resp = {"bodyCar": bodyCar, "engine": engine, "transmission":transmission};
            var xhr = new XMLHttpRequest();
            var respToJson = JSON.stringify(resp);
            xhr.open("POST", "./add", false);
            xhr.send(respToJson);
        }

        function isCheck(name) {
            return document.querySelector('input[name="' + name + '"]:checked');
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Заполните заявку <c:out value="${sessionScope.get('user')}"></c:out></h2>
    <table class="table table-borderless">
        <thead>
        <tr>
            <th>Кузов</th>
            <th>Двигатель</th>
            <th>Трансмиссия</th>
            <th>Название машины</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="bodyCar" checked="checked" value="sedan">Седан
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="bodyCar" value="hatchback">Хэчбэк
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="bodyCar" value="estate">Универсал
                    </label>
                </div>
            </td>
            <td>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="engine" checked="checked" value="gasoline">Бензин
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="engine" value="diesel">Дизель
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="engine" value="hybrid">Гибрид
                    </label>
                </div>
            </td>
            <td>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="transmission" checked="checked" value="auto">Автоматическая
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="transmission" value="mechanical">Механическая
                    </label>
                </div>
            </td>
            <td>
                <c:if test="${requestScope.get('resultLoadFile').equals('success')!=true}">
                    <form method="POST" enctype="multipart/form-data" action="upload">
                        File to upload: <input type="file" name="upfile"><br/>
                        Notes about the file: <input type="text" name="note"><br/>
                        <br/>
                        <input type="submit" value="Press"> to upload the file!
                    </form>
                </c:if>
                <c:if test="${(requestScope.get('resultLoadFile').equals('success'))}">
                    Файл успешно загружен <br>
                    <label id="labelPath"> <c:out value="${requestScope.get('filePath')}"></c:out> </label>

                </c:if>
            </td>
        </tr>
        </tbody>
    </table>
    <button type="button" class="btn btn-info" onclick="location.href='./add'">Отправить</button>
</div>

<input type="button" onclick="sendBody()">


</body>
</html>
