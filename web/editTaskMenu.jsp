<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Menu</title>
    <%--<script type="text/javascript" src="Content/JS/sendEditForm.js"></script>--%>
</head>
<body>
    <table>
        <tr>
            <td><a href="addTask.jsp">Add task</a></td>
            <td><a href="#">Edit task</a></td>
            <td><a href="JavaScript:sendNextForm('fix')">Fix task</a></td>
            <td><a href="JavaScript:sendNextForm('recycle')">Recycle task</a></td>
            <td><a href="JavaScript:sendNextForm('remove')">Remove task</a></td>
            <td><a href="JavaScript:sendNextForm('restore')">Restore task</a></td>
        </tr>
    </table>
</body>
</html>
