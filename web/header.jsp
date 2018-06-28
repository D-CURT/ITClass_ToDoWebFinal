
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<table>
    <tr>
        <th>
            <p>
                <c:choose>
                    <c:when test="${user.login == null}">
                        <c:out value="User: guest"/>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${'sys'.equals(user.login)}">
                                <c:out value="ADMINISTRATOR: ${user.login}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="User: ${user.login}"/>
                            </c:otherwise>
                        </c:choose>
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
        <th>
            <a href="<c:url value='/logout'/>">Logout</a>
        </th>
    </tr>
</table>

</body>
</html>
