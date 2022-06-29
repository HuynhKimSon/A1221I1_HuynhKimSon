<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
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

        .form-check {
            padding-left: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 style="margin: 40px 0; text-align: center">Danh sách sản phẩm</h1>
    <div class="row" style="height: 40px">
        <div class="col-6">
            <a type="button" class="btn btn-success" data-bs-toggle="modal"
               data-bs-target="#createModal">Thêm mới</a>
            <a class="btn btn-danger btn-delete" style="margin-left: 15px" data-bs-toggle="modal"
               data-bs-target="#deleteModal">Xóa</a>
        </div>
        <div class="col-6" style="line-height: 40px">
            <form action="" method="post" id="form-search" class="d-flex" style="margin-bottom: 0">
                <div class="col-4">
                    <select class="form-select" id="select-sort" aria-label="Default select example"
                            style="width: 200px">
                        <option value="name" selected>Tên sản phẩm</option>
                        <option value="price">Giá</option>
                        <option value="quantity">Số lượng</option>
                        <option value="category">Danh mục</option>
                    </select>
                </div>
                <div class="col-8 d-inline-flex">
                    <input class="form-control me-3" id="input-search" type="search" placeholder="Search"
                           aria-label="Search" autofocus>
                    <button class="btn btn-primary btn-submit-search" href="" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">
                <div class="form-check">
                    <input style="margin-top: 5px" class="form-check-input" type="checkbox"
                           id="checkAll">
                </div>
            </th>
            <th scope="col">No.</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Giá</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Màu</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Danh mục</th>
            <th scope="col">Hành động</th>

        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty listProduct}">
            <c:forEach items="${listProduct}" var="item" varStatus="index">
                <tr>
                    <td>
                        <div class="form-check">
                            <input class="form-check-input file_id" value="${item.id}" type="checkbox">
                        </div>
                    </td>
                    <td>${index.count}</td>
                    <td class="name">${item.name}</td>
                    <td class="price">${item.price}</td>
                    <td class="quantity">${item.quantity}</td>
                    <td class="color">${item.color}</td>
                    <td class="description">${item.description}</td>
                    <td class="category">${item.category}</td>
                    <td>
                        <a class="btn btn-danger btn-delete" data-bs-toggle="modal"
                           data-id="${item.id}" data-bs-target="#deleteModal">Xóa</a>
                        <a type="button" data-bs-toggle="modal" data-bs-target="#createModal"
                           data-id="${item.id}" class="btn btn-warning btn-edit">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty listProduct}">
            <tr>
                <td colspan="9"><p style="text-align: center; color: red">Không có dữ liệu</p></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<!-- Create Modal HTML -->
<div id="createModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form id="form-create" action="/product?action=create" method="post">
                <input type="hidden" class="id" name="id" value="0">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới sản phẩm</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"
                            onclick="this.form.reset()"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-8 form-group mb-2">
                            <label>Tên sản phẩm</label>
                            <input type="text" class="form-control mt-2 name" name="name" value=""
                                   required>
                        </div>
                        <div class="col-4">
                            <div class="form-group mb-2">
                                <label>Danh mục</label>
                                <select class="form-select mt-2 category" aria-label="Default select example"
                                        name="category" id="dropdown-category">
                                    <option value="1" selected>APPLE</option>
                                    <option value="2">SAMSUNG</option>
                                    <option value="3">SONY</option>
                                    <option value="4">HTC</option>
                                    <option value="5">LG</option>
                                    <option value="6">ASUS</option>
                                    <option value="7">LENOVO</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-4">
                            <div class="form-group mb-2">
                                <label>Số lượng</label>
                                <input type="text" class="form-control mt-2 quantity" name="quantity" value=""
                                       required>
                            </div>
                        </div>

                        <div class="col-4">
                            <div class="form-group mb-2">
                                <label>Màu sắc</label>
                                <input type="text" class="form-control mt-2 color" name="color" value=""
                                       required>
                            </div>
                        </div>

                        <div class="col-4">
                            <div class="form-group mb-2">
                                <label>Giá</label>
                                <input type="number" class="form-control mt-2 price" name="price" value=""
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mb-2">
                        <label>Mô tả</label>
                        <textarea type="text" class="form-control mt-2 description" name="description" value=""
                                  style="height: 150px"
                                  required></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default btn-cancel" data-bs-dismiss="modal" value="Hủy"
                           onclick="this.form.reset()">
                    <input type="submit" class="btn btn-primary btn-confirm-create" value="Xác nhận">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Xóa người dùng</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Bạn có muốn xóa người dùng?</p>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                <a type="button" class="btn btn-danger btn-confirm-delete" href="">Có</a>
            </div>
        </div>
    </div>
</div>

<%--View toast notification --%>
<div class="container mt-3">
    <div class="toast-container mt-3">
        <div id="bt" class="toast" style="position: absolute; top: 5%; left:70%; border-radius: 20px">
            <div class="toast-body bg-primary text-light text-center" style="border-radius: 20px">
                Thêm mới thành công!
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.js"></script>
<script type="text/javascript" src="/product/list.js"></script>

<c:if test="${not empty create}">
    <script>
        new bootstrap.Toast($('#bt'), {delay: 1200}).show();
    </script>
</c:if>
<c:if test="${not empty key && not empty value}">
    <script>
        $(`#select-sort option[value='${key}']`).prop('selected', true);
        $('#input-search').val(${value});
    </script>
</c:if>
</body>
</html>
