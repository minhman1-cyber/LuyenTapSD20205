<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Do Tuong Minh
  Date: 8/4/2025
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Tim kiem
<form action="/hocsinh/searching">
    Tuoi: <input type="number" name="tuoiSearch">
    <button>Search</button>
</form>
<h1>Them hoc sinh</h1>
<form action="/hocsinh/them" method="post">
    Ten: <input type="text" name="ten"> <br>
    Tuoi: <input type="number" name="tuoi"> <br>
    Tinh trang hoc: <input type="radio" name="tth" value="1"> <label>Dang hoc</label>
    <input type="radio" name="tth" value="0"> <label>Nghi hoc</label> <br>
    Truong hoc:
    <select name="thL">
        <c:forEach items="${thList}" var="th">
            <option value="${th.id}">${th.ten_truong}</option>
        </c:forEach>
    </select>
    <button type="submit">Submit</button>
</form>

<table>
    <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Tinh trang hoc</th>
            <th>Truong Hoc</th>
            <th>Hanh Dong</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${hsList}" var="hs" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${hs.id}</td>
                <td>${hs.ten_hoc_sinh}</td>
                <td>${hs.tuoi}</td>
                <td>${hs.dang_hoc ? "dang hoc" : "nghi hoc"}</td>
                <td>${hs.truong_hoc.ten_truong}</td>
                <td>
                    <c:if test="${isAdmin}">
                        <a href="/hocsinh/viewSua?id=${hs.id}" ${isAdmin? "" : ""} >Sua</a>
                    </c:if>
                    <c:if test="${isAdmin}">
                        <a href="/hocsinh/xoa?id=${hs.id}">Xoa</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
    <a href="/hocsinh/phanTrang?page=${page - 1}">Prev</a>
    <a href="/hocsinh/phanTrang?page=${page + 1}">Next</a>
</table>

</body>
</html>
