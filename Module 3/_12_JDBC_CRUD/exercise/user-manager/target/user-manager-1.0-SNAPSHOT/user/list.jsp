<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
        <h1 style="margin: 40px 0; text-align: center">Danh sách người dùng</h1>
        <a type="button" class="btn btn-success" data-bs-toggle="modal"
           data-bs-target="#createModal">Thêm mới</a>
        <a class="btn btn-danger btn-delete" style="margin-left: 15px" data-bs-toggle="modal"
           data-bs-target="#deleteModal">Xóa</a>
        <thead>
        <tr>
            <th scope="col">
                <div class="form-check">
                    <input style="margin-top: 5px" class="form-check-input" type="checkbox"
                           id="checkAll">
                </div>
            </th>
            <th scope="col">ID</th>
            <th scope="col">Email</th>
            <th scope="col">Country</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty listUser}">
            <c:forEach items="${listUser}" var="userItem" varStatus="index">
                <tr>
                    <td>
                        <div class="form-check">
                            <input class="form-check-input file_id" value="${userItem.id}" type="checkbox">
                        </div>
                    </td>
                    <td class="id">${userItem.id}</td>
                    <td class="name">${userItem.name}</td>
                    <td class="email">${userItem.email}</td>
                    <td class="country">${userItem.country}</td>
                    <td>
                        <a class="btn btn-danger btn-delete" data-bs-toggle="modal"
                           data-id="${userItem.id}" data-bs-target="#deleteModal">Xóa</a>
                        <a type="button" data-bs-toggle="modal" data-bs-target="#createModal"
                           class="btn btn-warning btn-edit">Sửa</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty listUser}">
            <tr>
                <td colspan="5"><p style="text-align: center; color: red">Không có dữ liệu</p></td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
<!-- Create Modal HTML -->
<div id="createModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/user?action=create" method="post">
                <input type="hidden" class="id" name="id" value="0">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới người dùng</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"
                            onclick="this.form.reset()"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group mb-2">
                        <label>Name</label>
                        <input type="text" class="form-control mt-2 name" name="name" value="" placeholder="Name"
                               required>
                    </div>
                    <div class="form-group mb-2">
                        <label>Email</label>
                        <input type="email" class="form-control mt-2 email" name="email" value="" placeholder="Email"
                               required>
                    </div>

                    <div class="form-group mb-2">
                        <label>Country</label>
                        <input type="text" class="form-control mt-2 country" name="country" value=""
                               placeholder="Country" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default btn-cancel" data-bs-dismiss="modal" value="Hủy"
                           onclick="this.form.reset()">
                    <input type="submit" class="btn btn-primary" value="Xác nhận">
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


<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.js"></script>
<script type="text/javascript" src="/user/list.js"></script>
s
</body>
</html>
