<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <style>
        tr {
            height: 70px;
        }

        td {
            line-height: 70px;
        }

        .file_id {
            margin-top: 28px;
        }
    </style>

</head>
<body>
<div class="container">
    <table class="table table-hover table-striped">
        <h1 style="margin: 40px 0; text-align: center">Danh sách sản phẩm</h1>
        <a type="button" class="btn btn-success" data-bs-toggle="modal"
           data-bs-target="#addProductModal">Thêm mới</a>
        <a class="btn btn-danger btn-delete" style="margin-left: 15px" data-bs-toggle="modal"
           data-bs-target="#deleteProductModal">Xóa</a>
        <thead>
        <tr>
            <th scope="col">
                <div class="form-check">
                    <input style="margin-top: 5px" class="form-check-input" type="checkbox"
                           id="checkAll">
                </div>
            </th>
            <th scope="col">STT</th>
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
                    <td>
                        <div class="form-check">
                            <input class="form-check-input file_id" value="${productItem.id}" type="checkbox">
                        </div>
                    </td>
                    <td class="id">${index.count}</td>
                    <td class="nameProduct">${productItem.nameProduct}</td>
                    <td class="priceProduct">${productItem.priceProduct}</td>
                    <td class="descriptionProduct">${productItem.descriptionProduct}</td>
                    <td class="manufacturer">${productItem.manufacturer}</td>
                    <td class="imgProduct">
                        <img src="/static/img/${productItem.imgProduct}" class="img-thumbnail" width="60" height="60">
                    </td>
                    <td>
                        <a class="btn btn-danger btn-delete" data-bs-toggle="modal"
                           data-id="${productItem.id}" data-bs-target="#deleteProductModal">Xóa</a>
                        <a type="button" data-bs-toggle="modal" data-bs-target="#addProductModal"
                           class="btn btn-warning btn-edit">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty products}">
            <tr>
                <td colspan="8"><p style="text-align: center; color: red">Không có dữ liệu</p></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<!-- Create Modal HTML -->
<div id="addProductModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/product?action=create" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới sản phẩm</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID</label>
                        <input type="number" class="form-control idProduct" name="idProduct" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input type="text" class="form-control nameProduct" name="nameProduct" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Giá sản phẩm</label>
                        <input type="number" class="form-control priceProduct" name="priceProduct" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea class="form-control descriptionProduct" name="descriptionProduct" value=""
                                  required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Nhà sản xuất</label>
                        <input type="text" class="form-control manufacturer" name="manufacturer" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input type="file" class="form-control imgProduct" name="imgProduct" value="" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-primary" value="Xác nhận">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Delete Modal HTML -->
<div id="deleteProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Xóa sản phẩm</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Bạn có muốn xóa sản phầm?</p>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                <a type="button" class="btn btn-danger btn-confirm-delete" href="">Có</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.js"></script>
<script type="text/javascript" src="../product/list.js"></script>
</body>
</html>