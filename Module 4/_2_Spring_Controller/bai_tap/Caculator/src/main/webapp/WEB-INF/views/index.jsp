<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="margin-left: 200px" method="post" action="/">
    <h2>Caculator</h2>
    <input name="value1" type="number" autofocus>
    <input name="value2" type="number">
    <button type="submit" value="+" name="operator">Addition(+)</button>
    <button type="submit" value="-" name="operator">Subtraction(-)</button>
    <button type="submit" value="*" name="operator">Multiplication(x)</button>
    <button type="submit" value="/" name="operator">Division(/)</button>
    <p>Result Division: <span>${result}</span></p>
</form>
</body>
</html>
