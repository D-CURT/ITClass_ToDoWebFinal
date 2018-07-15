<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
    <%@include file="searchTask.jsp"%>
    <hr>
    <input type="hidden" name="<%=Constants.KEY_PARAM_LIST%>" value="<%=session.getAttribute(Constants.KEY_PARAM_LIST)%>">
    <%--<p><c:out value="${sessionScope.}"/></p>--%>
    <form <c:if test="${paramList != Constants.PARAM_LIST_CHOSEN}" /> action="edit" name="edit" method="post">
        <table border="1">
            <c:forEach items="${listTask}" var="task">
                <form action="edit" name="edit" method="post">
                    <input type="hidden" name="<%=Constants.KEY_PARAM_EDIT%>" value="edit">
                    <tr>
                        <td><input type="text" name="<%=Constants.PARAM_TITLE_TASK%>" value="${task.title}"></td>
                        <td><input type="date" name="<%=Constants.PARAM_DATE_TASK%>" value=""></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="<%=Constants.PARAM_CONTENT_TASK%>" value="${task.contentTask}"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Edit"></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </form>
</body>
</html>
