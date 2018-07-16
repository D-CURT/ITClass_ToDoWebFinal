<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
    <%@include file="searchTask.jsp"%>
    <hr>
    <form action="edit" name="edit" method="post">
        <input type="hidden" name="<%=Constants.KEY_PARAM_EDIT%>" value="edit">
        <table border="1">
            <c:forEach items="${listTask}" var="task">
                <form action="edit" name="edit" method="post">
                    <input type="hidden" name="<%=Constants.KEY_PARAM_EDIT%>" value="edit">
                    <tr>
                        <td><input type="checkbox" name="<%=Constants.PARAM_CHECKBOX%>" value="${task.id}"></td>
                        <td><input type="text" name="<%=Constants.PARAM_TITLE_TASK%>" value="${task.title}"></td>
                        <td><input type="date" name="<%=Constants.PARAM_DATE_TASK%>" value=""></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="<%=Constants.PARAM_CONTENT_TASK%>" value="${task.contentTask}"></td>
                    </tr>
                </form>
            </c:forEach>
            <tr>
                <td><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
