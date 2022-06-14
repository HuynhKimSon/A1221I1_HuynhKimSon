<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        td {
            height: 30px;
        }
    </style>
</head>
<body>
<h2>Tính chiết khấu cho sản phẩm mua hàng online</h2>
<form action="/discount" method="post">
    <table>
        <tr>
            <td>Product Description:</td>
            <td><input type="text" name="description" placeholder="Mô tả của sản phẩm"/></td>
        </tr>
        <tr>
            <td>List Price:</td>
            <td><input type="text" name="price" placeholder="Giá niêm yết của sản phẩm"/></td>
        </tr>
        <tr>
            <td>Discount Percent:</td>
            <td><input type="text" name="percent" placeholder="Tỷ lệ chiết khấu (phần trăm)"/></td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="Submit"/></td>
        </tr>
    </table>

</form>
</body>
</html>