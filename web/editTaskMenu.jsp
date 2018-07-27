<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Edit Menu</title>
    <script type="text/javascript" src="Content/JS/sendChangedData.js"></script>
</head>
<body>
${fixMark}
${recycleMark}
    <table>
        <tr>
            <td><a href="<%=Constants.TASK_ADD_JSP%>">Add task</a></td>
            <td><a <c:if test="${fixMark != null}">hidden</c:if> href="JavaScript:sendEditForm('fix')">Fix task</a></td>
            <td><a <c:if test="${fixMark == null}">hidden</c:if> href="JavaScript:sendEditForm('unfix')">Unfix task</a></td>
            <td><a <c:if test="${recycleMark != null}">hidden</c:if> href="JavaScript:sendEditForm('recycle')">to Recycle Bin</a></td>
            <td><a href="JavaScript:sendEditForm('remove')">Remove task</a></td>
            <td><a <c:if test="${recycleMark == null}">hidden</c:if> href="JavaScript:sendEditForm('restore')">Restore task</a></td>
        </tr>
    </table>
</body>
</html>
