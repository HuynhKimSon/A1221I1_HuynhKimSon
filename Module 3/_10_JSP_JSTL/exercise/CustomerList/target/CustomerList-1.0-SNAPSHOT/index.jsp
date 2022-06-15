<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <style>
        tr {
            height: 70px;
        }

        td {
            line-height: 70px;
        }
    </style>

</head>
<body>
<div class="container">
    <table class="table table-hover table-striped">
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
        <c:if test="${not empty customers}">
            <c:forEach items="${customers}" var="cus" varStatus="index">
                <tr>
                    <td style="font-weight: bold">${index.count}</td>
                    <td>${cus.name}</td>
                    <td>${cus.dateOfBirth}</td>
                    <td>${cus.address}</td>
                    <td>
                        <img src="${cus.img}" class="img-thumbnail" width="60" height="60">
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty customers}">
            <tr>
                <td colspan="5"><p style="text-align: center; color: red">Không có dữ liệu</p></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

</body>
</html>