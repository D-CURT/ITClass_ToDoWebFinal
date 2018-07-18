<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Task</title>
    <script type="text/javascript" src="Content/JS/sendNextForm.js"></script>
</head>
<body>
<form action="edit" name="editForm" method="POST">
    <input type="hidden" name="<%=Constants.KEY_PARAM_EDIT%>" value="">
    <table border="1px">
        <tr><td></td><td>Task</td><td>Edit Task</td></tr>
        <c:forEach items = "${listTask}" var = "task">
            <tr>
                <td><input type="checkbox" name="<%=Constants.KEY_PARAM_EDIT_CHECK%>" value="${task.id}"></td>
                <td><c:out value="${task.title}"></c:out></td>
                <td><c:out value="${task.dateTask}"></c:out></td>
                <td><c:out value="${task.contentTask}"></c:out></td>
                <td><input type="button" value="Edit" onclick="JavaScript:sendToEditTask(${task.id},${task.contentTask})"></td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>