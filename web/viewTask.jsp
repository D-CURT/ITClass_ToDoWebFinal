<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Task</title>
</head>
<body>
    <c:forEach items = "${param}" var = "task">
        <c:out value = "${task}"/>
    </c:forEach>
</body>
</html>
