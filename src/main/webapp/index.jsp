<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="js/hocSinh.js"></script>
</head>
<body>
    <form>
        Username: <input type="text" name="username" id="username"> <br>
        Password: <input type="password" name="password" id="password"> <br>
        <button type="button" onclick="checkLogin()">Dang nhap</button>
    </form>
</body>
</html>