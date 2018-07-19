<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Task</title>
    <style>
        <%@include file='Content/css/style.css'%>
    </style>
</head>
<body>
<div class="wrapper">
    <c:if test="${not empty errorMessage}">
        <p style="color: red"><c:out value="${errorMessage}"/></p>
    </c:if>

    <%@ include file="header.jsp"%>
    <hr>
    <%@ include file="taskMenu.jsp"%>
    <br>
    <%@ include file="viewTask.jsp"%>
    <br>
    <%@include file="editTaskMenu.jsp"%>
    <hr>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
