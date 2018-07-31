<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<form name="editTaskForm" method="post" action='edit'>
    <input type="hidden" name="<%=Constants.PARAM_ID_TASK%>" value="${param.id}">
    <input type="hidden" name="<%=Constants.KEY_PARAM_EDIT%>" value="edit">
    <table>
        <tr>
            <td>Edit Task</td>
        </tr>
        <tr>
            <td>
                <input type="text" name="<%=Constants.PARAM_TITLE_TASK%>" value="${param.titleTask}">
            </td>
            <td>
                <input type="text" name="<%=Constants.PARAM_CONTENT_TASK%>" value="${param.contentTask}">
            </td>
            <td>
                <input type="Date" name="<%=Constants.PARAM_DATE_TASK%>" value="${task.dateTask}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Edit Task">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
