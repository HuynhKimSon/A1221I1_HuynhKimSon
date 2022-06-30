<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ứng Dụng Quản Lý Khu Nghỉ Dưỡng Furama</title>
  <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
  <script type="text/javascript" src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>
  <style>
    <%@include file="/contract/contract.css" %>
  </style>
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


<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.js"></script>
</body>
</html>