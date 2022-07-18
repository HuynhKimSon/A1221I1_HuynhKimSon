<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<form style="margin-left: 200px" method="post" action="/">
    <legend>Sandwich Condiments</legend>
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="Lettuce" name="condiment" checked>
            <label class="form-check-label">
                Lettuce
            </label>
        </div>
    </div>
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="Tomato" name="condiment">
            <label class="form-check-label">
                Tomato
            </label>
        </div>
    </div>
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="Mustard" name="condiment">
            <label class="form-check-label">
                Mustard
            </label>
        </div>
    </div>
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="Sprouts" name="condiment">
            <label class="form-check-label">
                Sprouts
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </fieldset>
</form>
</body>
</html>
