<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import="by.itClass.constants.Constants" %>
<html>
<head>
    <title>Search task</title>
</head>
<body>
    <form action="task" name="edit" method="GET">
        <input type="hidden" name="<%= Constants.KEY_PARAM_LIST%>" value="<%=Constants.PARAM_LIST_CHOSEN%>">
        <table border="1">
            <tr>
                <td><input type="date" name="<%=Constants.PARAM_DATE_TASK%>" value=""></td>
                <td><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form>
</body>
</html>
