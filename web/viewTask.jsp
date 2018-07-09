<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Task</title>
</head>
<body>
    <table>
        <c:forEach items = "${paramList}" var = "task">
            <tr>
                <td>${task.contentTask}</td>
                <td>${task.dateTask}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>