<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<form name="editTaskForm" method="post" action='<c:url value="/edit"/>'>
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="paramEdit" value="edit">
    <table>
        <tr>
            <td>Edit Task</td>
        </tr>
        <tr>
            <td>
                <input type="text" name="contentTask" value="${param.contentTask}">
            </td>
            <td>
                <input type="Date" name="dateTask" value="${task.dateTask}">
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
