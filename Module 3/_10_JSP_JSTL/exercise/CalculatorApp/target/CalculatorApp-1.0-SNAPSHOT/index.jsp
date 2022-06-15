<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <div style="width: 400px; margin: 0 auto; padding-top: 100px">
        <h2>Simple Calculator</h2>
        <form action="/calculator" method="post">
            <div class="mb-3">
                <label for="firstOperand" class="form-label">First operand</label>
                <input type="text" class="form-control" id="firstOperand" name="firstOperand">
            </div>
            <div class="mb-3">
                <label for="operator" class="form-label">Operator</label>
                <select class="form-select" aria-label="Default select example" id="operator" name="operator">
                    <option selected value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="secondOperand" class="form-label">Second operand</label>
                <input type="text" class="form-control" id="secondOperand" name="secondOperand">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</div>
</body>
</html>