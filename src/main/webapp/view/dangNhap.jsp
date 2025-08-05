<%--
  Created by IntelliJ IDEA.
  User: Do Tuong Minh
  Date: 8/5/2025
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/hocsinh/dang-nhap" method="post">
        Username: <input type="text" name="username"> <br>
        Password: <input type="password" name="password"> <br>
        <button type="submit">Dang nhap</button>
        <div>${xacThuc ? "" : "thong tin xac thuc sai"}</div>

    </form>
</body>
</html>
