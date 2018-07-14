<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
    <%@include file="searchTask.jsp"%>
    <hr>

    <table>
        <c:forEach items="${listTask}" var="task">
            <a href="task">
                <input type="hidden" name="">
            </a>
        </c:forEach>
        <tr>

        </tr>
    </table>
</body>
</html>
