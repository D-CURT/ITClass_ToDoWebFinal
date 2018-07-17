<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>Add task</title>
</head>
<body>

<c:if test="${not empty errorMessage}">
    <p style="color: red"><c:out value="${errorMessage}"/></p>
</c:if>

    <form action="edit" method="post" name="add">
        <input type="hidden" name="<%= Constants.KEY_PARAM_EDIT%>" value="add">
        <table border="1">
            <tr><td>Add Task</td></tr>
            <tr><td><input type="text" name="<%=Constants.PARAM_TITLE_TASK%>" placeholder="Title" value=""></td></tr>
            <tr>
                <td><input type="text" name="<%= Constants.PARAM_CONTENT_TASK%>" value=""></td>
                <td><input type="date" name="<%= Constants.PARAM_DATE_TASK%>" value=""></td>
                <td><input type="submit" value="Add new task"></td>
            </tr>
        </table>
    </form>
</body>
</html>
