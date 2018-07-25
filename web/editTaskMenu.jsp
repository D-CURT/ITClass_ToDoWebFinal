<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Menu</title>
    <script type="text/javascript" src="Content/JS/sendNextForm.js"></script>
</head>
<body>
    <table>
        <tr>
            <td><a href="addTask.jsp">Add task</a></td>
            <td><a href="JavaScript:sendEditForm('fix')">Fix task</a></td>
            <td><a href="JavaScript:sendEditForm('recycle')">to Trash</a></td>
            <td><a href="JavaScript:sendEditForm('remove')">Remove task</a></td>
            <td><a href="JavaScript:sendEditForm('restore')">Restore task</a></td>
        </tr>
    </table>
</body>
</html>
