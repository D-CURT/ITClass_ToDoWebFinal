<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search task</title>
</head>
<body>
    <form action="task" name="edit" method="post">
        <input type="hidden" name="<%=Constants.KEY_PARAM_EDIT%>" value="search">
        <table border="1">
            <tr>
                <td>Enter date for searching: </td>
                <td><input type="date" name="<%=Constants.PARAM_DATE_TASK%>" value=""></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
</body>
</html>
