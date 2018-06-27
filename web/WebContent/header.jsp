<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:choose>
            <c:when test="${not empty user}">
                <td>
                    <c:out value="User">
                </td>
            </c:when>
        </c:choose>
    </table>
</body>
</html>
