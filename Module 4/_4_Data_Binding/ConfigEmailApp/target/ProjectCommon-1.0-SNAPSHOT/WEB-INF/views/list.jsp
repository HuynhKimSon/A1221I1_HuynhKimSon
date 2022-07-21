<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h2 style="color: green">${message}</h2>
        <table class="table" border="1">
            <thead>
            <tr>
                <th>#</th>
                <th>Language</th>
                <th>Page Size</th>
                <th>Spams Filter</th>
                <th>Signature</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item" varStatus="count">
                    <tr>
                        <td>${count.index + 1}</td>
                        <td>${item.languages}</td>
                        <td>${item.pageSize}</td>
                        <c:choose>
                            <c:when test="${item.spamsFilter == true}">
                                <td>Có</td>
                            </c:when>
                            <c:otherwise>
                                <td>Không</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${item.signature}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
