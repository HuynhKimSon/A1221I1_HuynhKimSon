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
        <h1 style="margin: 40px 0; text-align: center">Danh sách sản phẩm</h1>
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Giá sản phẩm</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Nhà sản xuất</th>
            <th scope="col">Hình ảnh</th>
            <th scope="col">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty products}">
            <c:forEach items="${products}" var="productItem" varStatus="index">
                <tr>
                    <td style="font-weight: bold">${index.count}</td>
                    <td>${productItem.id}</td>
                    <td>${productItem.nameProduct}</td>
                    <td>${productItem.priceProduct}</td>
                    <td>${productItem.descriptionProduct}</td>
                    <td>${productItem.manufacturer}</td>
                    <td>
                        <img src="${imgProduct.img}" class="img-thumbnail" width="60" height="60">
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty products}">
            <tr>
                <td colspan="5"><p style="text-align: center; color: red">Không có dữ liệu</p></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

</body>
</html>