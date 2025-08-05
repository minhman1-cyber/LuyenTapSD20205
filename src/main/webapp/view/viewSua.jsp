<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Do Tuong Minh
  Date: 8/5/2025
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Sua hoc sinh</h1>
<form action="/hocsinh/sua?id=${hs.id}" method="post">

  Ten: <input type="text" name="ten" value="${hs.ten_hoc_sinh}"> <br>
  Tuoi: <input type="number" name="tuoi" value="${hs.tuoi}"> <br>
  Tinh trang hoc: <input type="radio" name="tth" value="1" ${hs.dang_hoc ? "checked" : ""} > <label>Dang hoc</label>
  <input type="radio" name="tth" value="0" ${hs.dang_hoc ? "" : "checked"}> <label>Nghi hoc</label> <br>
  Truong hoc:
  <select name="thL">
    <c:forEach items="${thList}" var="th">
      <option value="${th.id}" ${hs.truong_hoc.id == th.id ? "selected" : ""} >${th.ten_truong}</option>
    </c:forEach>
  </select>
  <button type="submit">Submit</button>
</form>
</body>
</html>
