<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
    <title>Task</title>
    <style>
        <%@include file='Content/css/style.css'%>
    </style>
</head>
<body>
<div class="wrapper">
    <%@ include file="header.jsp"%>
    <hr>
    <%@ include file="taskMenu.jsp"%>
    <br>
    <c:if test="${not empty errorMessage}">
        <p style="color: red"><c:out value="${errorMessage}"/></p>
    </c:if>
    <%@ include file="viewTask.jsp"%>
    <br>
    <%@include file="editTaskMenu.jsp"%>
    <hr>
    <%@include file="footer.jsp"%>
</div>
</body>
</html>
