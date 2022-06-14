<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table>
            <tr>
                <td>Mô tả của sản phẩm: </td>
                <td>${description}</td>
            </tr>
            <tr>
                <td>Lượng chiết khấu: </td>
                <td>${discountAmount}</td>
            </tr>
            <tr>
                <td>Giá sau khi đã được chiết khấu: </td>
                <td>${discountPrice}</td>
            </tr>
        </table>
</body>
</html>
