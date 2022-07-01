<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Quản Lý Khu Nghỉ Dưỡng Furama</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
    <style>
        <%@include file="/static/index.css" %>
    </style>
    <script>
        <%@include file="/static/index.js" %>
    </script>
</head>
<body>
<!--header-->
<div class="container-fluid">
    <div class="row">
        <div class="col-12 mt-4" id="col-navbar-menu">
            <nav class="navbar navbar-expand-lg navbar-light" id="nav-navbar-menu">
                <div class="collapse navbar-collapse justify-content-center w-auto">
                    <img src="https://us-ws.gr-cdn.com/images/global/logo_ua.svg"
                         alt="Marketing Software by GetResponse" width="140" height="20">
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav justify-content-between w-50" id="ul-navbar-dropdown">
                        <li class="nav-item">
                            <a class="nav-link" href="/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee">Employee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/service">Service</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer">Customer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contract">Contract</a>
                        </li>
                    </ul>
                    <button type="button" id="btn-sign">SIGN UP FREE</button>
                </div>
            </nav>
        </div>
    </div>
</div>
<!--main-->
<div class="container-fluid" style="padding: 0 50px; font-size: 15px">
    <h1 style="margin: 40px 0; text-align: center">QUẢN LÝ THÔNG TIN KHÁCH HÀNG</h1>
    <div class="row" style="height: 40px;">
        <div class="col-2">
            <a type="button" class="btn btn-success" data-bs-toggle="modal"
               data-bs-target="#createModal">Thêm mới</a>
            <a class="btn btn-danger btn_delete" style="margin-left: 15px" data-bs-toggle="modal"
               data-bs-target="#deleteModal">Xóa</a>
        </div>
        <div class="col-10" style="line-height: 40px">
            <form action="" method="post" id="form_search" class="d-flex" style="margin-bottom: 0">
                <div class="col-7 d-inline-flex" style="padding-right: 80px">
                    <div class="input-group" style="width: 200px">
                        <label>Ngày sinh:</label>
                    </div>
                    <div class="input-group" style="margin-right: 20px">
                        <span class="input-group-text">Bắt đầu:</span>
                        <input type="date" aria-label="First name" class="form-control" name="customer_birthday_start"
                               id="customer_birthday_start">
                    </div>
                    <div class="input-group" style="margin-right: 20px">
                        <span class="input-group-text">Kết thúc:</span>
                        <input type="date" aria-label="First name" class="form-control" name="customer_birthday_end"
                               id="customer_birthday_end">
                    </div>

                </div>
                <div class="col-5 d-inline-flex">
                    <select class="form-select" id="select_sort" aria-label="Default select example"
                            style="width: 200px; margin-right: 20px">
                        <option value="customer_name" selected>Tên Khách hàng</option>
                        <option value="customer_id_card">CMND</option>
                        <option value="customer_phone">Số điện thoại</option>
                        <option value="customer_type">Loại khách</option>
                    </select>
                    <input class="form-control me-3" id="input_search" type="search" placeholder="Search"
                           aria-label="Search" autofocus>
                    <button class="btn btn-primary btn_submit_search" href="" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
<%--Table--%>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col" style="width: 50px">
                <div class="form-check">
                    <input style="margin-top: 5px" class="form-check-input" type="checkbox"
                           id="checkAll">
                </div>
            </th>
            <th scope="col" style="width: 50px">#</th>
            <th scope="col" style="width: 170px">Tên</th>
            <th scope="col" style="width: 100px">Ngày sinh</th>
            <th scope="col" style="width: 100px">Giới tính</th>
            <th scope="col" style="width: 120px">CMND</th>
            <th scope="col" style="width: 120px">Số điện thoại</th>
            <th scope="col" style="width: 200px">Email</th>
            <th scope="col" style="width: 100px">Loại khách</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col" style="width: 130px">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty list}">
            <c:forEach items="${list}" var="item" varStatus="index">
                <tr>
                    <td>
                        <div class="form-check">
                            <input class="form-check-input file_id" value="${item.customerId}" type="checkbox">
                        </div>
                    </td>
                    <td>${index.count}</td>
                    <td class="customer_name">${item.customerName}</td>
                    <td class="customer_birthday">${item.customerBirthday}</td>
                    <c:choose>
                        <c:when test="${item.customerGender == 0}">
                            <td class="customer_gender">Nữ</td>
                        </c:when>
                        <c:when test="${item.customerGender == 1}">
                            <td class="customer_gender">Nam</td>
                        </c:when>
                        <c:otherwise>
                            <td class="customer_gender">Khác</td>
                        </c:otherwise>
                    </c:choose>
                    <td class="customer_id_card">${item.customerIdCard}</td>
                    <td class="customer_phone">${item.customerPhone}</td>
                    <td class="customer_email">${item.customerEmail}</td>
                    <td class="customer_type_name">${item.customerType}</td>
                    <td class="customer_address">${item.customerAddress}</td>
                    <td>
                        <a class="btn btn-danger btn_delete" data-bs-toggle="modal"
                           data-id="${item.customerId}" data-bs-target="#deleteModal">Xóa</a>
                        <a type="button" data-bs-toggle="modal" data-bs-target="#createModal"
                           data-id="${item.customerId}" class="btn btn-warning btn_edit">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty list}">
            <tr>
                <td colspan="11"><p style="text-align: center; color: red">Không có dữ liệu</p></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<!-- Create Modal HTML -->
<div id="createModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form id="form-create" action="/customer?action=create" method="post">
                <input type="hidden" class="customer_id" name="customer_id" value="0">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới khách hàng</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"
                            onclick="this.form.reset()"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-7 form-group mb-2">
                            <label>Tên</label>
                            <input type="text" class="form-control mt-2 customer_name" name="customer_name" value=""
                                   required>
                        </div>
                        <div class="col-5 form-group mb-2">
                            <label>Ngày Sinh</label>
                            <input type="date" class="form-control mt-2 customer_birthday" name="customer_birthday"
                                   value=""
                                   required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-4">
                            <div class="form-group mb-2">
                                <label>Giới tính</label>
                                <select class="form-select mt-2 customer_gender" aria-label="Default select example"
                                        name="customer_gender" id="dropdown_customer_gender">
                                    <option value="0">Nữ</option>
                                    <option value="1" selected>Nam</option>
                                    <option value="2">Khác</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-4 form-group mb-2">
                            <label>Chứng minh nhân dân</label>
                            <input type="number" class="form-control mt-2 customer_id_card" name="customer_id_card"
                                   value=""
                                   required>
                        </div>
                        <div class="col-4 form-group mb-2">
                            <label>Số điện thoại</label>
                            <input type="number" class="form-control mt-2 customer_phone" name="customer_phone" value=""
                                   required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-6">
                            <div class="form-group mb-2">
                                <label>Loại khách</label>
                                <select class="form-select mt-2 customer_type" aria-label="Default select example"
                                        name="customer_type" id="dropdown_customer_type">
                                    <option value="1" selected>Diamond</option>
                                    <option value="2">Platinium</option>
                                    <option value="3">Gold</option>
                                    <option value="4">Silver</option>
                                    <option value="5">Member</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group mb-2">
                                <label>Email</label>
                                <input type="email" class="form-control mt-2 customer_email" name="customer_email"
                                       value=""
                                       required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group mb-2">
                            <label>Địa chỉ</label>
                            <textarea type="text" class="form-control mt-2 customer_address" name="customer_address"
                                      value=""
                                      style="height: 100px"
                                      required></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default btn_cancel" data-bs-dismiss="modal" value="Hủy"
                           onclick="this.form.reset()">
                    <input type="submit" class="btn btn-primary btn_confirm_create" value="Xác nhận">
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
                <h4 class="modal-title">Xóa khách hàng</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Bạn có muốn xóa khách hàng?</p>
            </div>
            <div class="modal-footer">
                <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                <a type="button" class="btn btn-danger btn_confirm_delete" href="">Có</a>
            </div>
        </div>
    </div>
</div>
<%--View toast notification --%>
<div class="container mt-3">
    <div class="toast-container mt-3">
        <div id="bt" class="toast" style="position: absolute; top: 5%; left:80%; border-radius: 20px">
            <c:if test="${not empty status}">
                <c:choose>
                    <c:when test="${status == 'createSuccess'}">
                        <div class="toast-body bg-primary text-light text-center"
                             style="border-radius: 20px; font-weight: bold">
                            Thêm mới thành công!
                        </div>
                    </c:when>
                    <c:when test="${status == 'editSuccess'}">
                        <div class="toast-body bg-warning text-dark text-center"
                             style="border-radius: 20px; font-weight: bold">
                            Chỉnh sửa thành công!
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="toast-body bg-danger text-light text-center"
                             style="border-radius: 20px; font-weight: bold">
                            Xoá thành công!
                        </div>
                    </c:otherwise>
                </c:choose>

            </c:if>
        </div>
    </div>
</div>

<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.js"></script>

<c:if test="${not empty status}">
    <script>
        new bootstrap.Toast($('#bt'), {delay: 1700}).show();
    </script>
</c:if>
<c:if test="${not empty key || not empty value}">
    <script>
        $(`#select_sort option[value='${key}']`).prop('selected', true);
        $('#input_search').val(${value});
    </script>
</c:if>
</body>
</html>
