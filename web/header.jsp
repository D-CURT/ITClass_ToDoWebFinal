<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<table>
    <tr>
        <th>
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
        </th>
        <th style="padding: 10px 0 0 50px" <c:if test="${user.login == null}">hidden</c:if>>
            <%@include file="searchTask.jsp"%>
        </th>
        <th>
            <a style="padding-left: 205px"
               <c:if test="${user.login != null}">hidden</c:if>
               href="login.jsp">Login</a>
        </th>
        <th>
            <a <c:if test="${user.login != null}">hidden</c:if>
               href="registration.jsp">Registration</a>
        </th>
        <th>
            <a style="padding-left: 185px"
               <c:if test="${user.login == null}">hidden</c:if>
               href="\logout">Logout</a>
        </th>
    </tr>
</table>

</body>
</html>
