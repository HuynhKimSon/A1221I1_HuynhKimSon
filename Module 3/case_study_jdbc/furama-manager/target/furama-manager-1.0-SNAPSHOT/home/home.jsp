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
<div class="container-fluids">
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
<main>
  <section class="hero-section">
    <div class="container">
      <h1>FURAMA ĐÀ NẴNG</h1>
      <p>Khu nghỉ dưỡng ẩm thực. Tọa lạc tại bãi biển Đà Nẵng, một trong những bãi biển đẹp nhất thế giới</p>
      <button type="button" id="btn-create-account">BOOKING NOW</button>
      <hr>
      <h2>CÁC LOẠI PHÒNG</h2>
      <p>Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết hợp với phong cách
        Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt đới xanh
        tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi ướt, phòng
        xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các lớp tập yoga và
        Thái Cực Quyền trên bãi biển.</p>
    </div>
  </section>
  <section class="free-forever-section">
    <div class="container">
      <div class="row">
        <div class="text">
          <h2 class="text-center">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ
            DƯỠNG ẨM THỰC TẠI VIỆT
            NAM.</h2>
          <p>Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản
            văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng
            với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo
            phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành
            khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới
            hoàng gia, chính khách, ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.</p>
        </div>
        <div class="image text-center">
          <img src="https://file4.batdongsan.com.vn/2021/06/17/JGcIp0rf/20210617172417-2f9e.jpg" width="1000"
               height="500">
        </div>
      </div>
    </div>
  </section>
</main>
<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/popper.js/2.9.3/umd/popper.js"></script>
</body>