<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>--%>
<html>
<head>
    <title>View Task</title>
</head>
<body>
    <c:forTokens items = "${paramValues}" delim="," var = "task">
        <c:out value = "${task}"/><p>
    </c:forTokens>
</body>
</html>
