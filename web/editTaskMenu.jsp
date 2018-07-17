<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Menu</title>
</head>
<body>
    <%--<form name="checker" method="GET">
        <input type="hidden" name="flagCheck" value="">
    </form>--%>
    <table>
        <tr>
            <td><a href="addTask.jsp">Add task</a></td>
            <td><a href="#">Edit task</a></td>
            <td><a href="JavaScript:sendEditForm('fix')">Fix task</a></td>
            <td><a href="JavaScript:sendEditForm('recycle')">to Trash</a></td>
            <td><a href="JavaScript:sendEditForm('remove')">Remove task</a></td>
            <td><a <%--<c:if test="${flagCheck != 'can_restore'}">hidden</c:if>--%> href="JavaScript:sendEditForm('restore')">Restore task</a></td>
        </tr>
    </table>
</body>
</html>
