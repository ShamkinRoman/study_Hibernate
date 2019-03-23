<%--
  Created by IntelliJ IDEA.
  User: Up
  Date: 23.03.2019
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новая машина на продажу</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Заполните заявку</h2>
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
            <td><div class="form-check">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="bodyCar">Седан
                </label>
            </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="bodyCar">Хэчбэк
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="bodyCar">Универсал
                    </label>
                </div>
            </td>
            <td><div class="form-check">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="engine">Бензин
                </label>
            </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="engine">Дизель
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="engine">Гибрид
                    </label>
                </div></td>
            <td><div class="form-check">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="transmission">Автоматическая
                </label>
            </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="transmission">Механическая
                    </label>
                </div></td>
            <td> <input type="text" name="mark" ></td>
        </tr>
        </tbody>
    </table>
    <button type="button" class="btn btn-info" onclick="location.href='./add'">Отправить</button>
</div>
</body>
</html>
