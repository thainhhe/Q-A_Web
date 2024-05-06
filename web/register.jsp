<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Đăng ký</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 400px;
            margin: 100px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        form {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Đăng ký</h1>
        <form action="register" method="post">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" required><br>

            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Đăng ký">
            <c:if test="${errorMessage != null}">
                <p style="color: red"> ${errorMessage}</p>
            </c:if>
        </form>
    </div>
</body>
</html>
