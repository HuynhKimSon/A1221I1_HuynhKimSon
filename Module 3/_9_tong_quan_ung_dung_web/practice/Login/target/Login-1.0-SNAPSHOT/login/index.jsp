<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<form action="/login" method="post">
    <div class="row mb-3">
        <label for="inputUsername" class="col-sm-2 col-form-label">UserName</label>
        <div class="col-sm-10">
            <input type="username" class="form-control" id="inputUsername" name="inputUsername">
        </div>
    </div>
    <div class="row mb-3">
        <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword" name="inputPassword">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
</form>

<%--<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>--%>
<%--<script src="webjars/popper.js/2.9.3/umd/popper.js"></script>--%>
</body>
</html>
