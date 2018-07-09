<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>View Task</title>
</head>
<body>
    <table border="1px">
        <tr></tr>
        <tr><td>Task</td></tr>
        <c:forEach items = "${listTask}" var = "task">
            <tr></tr>
            <tr>
                <td><c:out value="${task.contentTask}"></c:out></td>
                <%--<td>${task.dateTask}</td>--%>
            </tr>
        </c:forEach>
    </table>
</body>
</html>