
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "by.itClass.constants.Constants" %>
<%@page import="by.itClass.impl.UserMemoryImplementation" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<table>
    <tr>
        <th>
            <p>User:
                <c:choose>
                    <c:when test="${!UserMemoryImplementation.isFoundLogin(user)}">
                        <c:out value="guest"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${user.login}"/>
                    </c:otherwise>
                </c:choose>
            </p>
        </th>
        <th>
            <a href="login.jsp">Login</a>
        </th>
        <th>
            <a href="registration.jsp">Registration</a>
        </th>
    </tr>
</table>

</body>
</html>
