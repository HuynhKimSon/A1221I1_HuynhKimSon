<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">


</head>
<body>
<div class="container">
    <table class="table">
        <h1 style="margin: 40px 0; text-align: center">Danh sách khách hàng</h1>
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="item" varStatus="theCount">
            <tr>
                <td>${theCount.count}</td>
                <td>${item.name}</td>
                <td>${item.dateOfBirth}</td>
                <td>${item.address}</td>
                <td>
                    <img src=" ${item.img}">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>