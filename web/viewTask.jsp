<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>View Task</title>
</head>
<body>
    <c:forTokens items = "${param}" var = "task">
        <c:out value = "${task}"/>
    </c:forTokens>
</body>
</html>
