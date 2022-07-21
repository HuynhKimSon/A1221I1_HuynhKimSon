<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            padding-left: 50px;
        }

        tr {
            line-height: 50px;
        }
    </style>
</head>
<body>
<h1>Setting</h1>
<form:form modelAttribute="email" method="post">
    <table class="table">
        <tr>
            <th>Languages:</th>
            <td>
                <form:select path="languages">
                    <form:options items="${languageList}"></form:options>
                </form:select>
            </td>
        </tr>

        <tr>
            <th>Page Size:</th>
            <td>
                    <span>
                        Show
                              <form:select path="pageSize">
                                  <form:options items="${pageSizeList}"></form:options>
                              </form:select>
                        emails per page
                    </span>
            </td>
        </tr>

        <tr>
            <th>Spams filter:</th>
            <td>
                    <span>
                        <form:checkbox path="spamsFilter" label="Enable spams filter" value="1"></form:checkbox>
                    </span>
            </td>
        </tr>

        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2">
               <button type="submit">
                    Submit
               </button>
            </td>
        </tr>

    </table>
</form:form>
</body>
</html>
