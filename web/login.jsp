<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>Login</title>
    <style>
        <%@include file='Content/css/style.css'%>
    </style>
</head>
<body>
<div class="wrapper">
    <form name="loginForm" action="login" method="POST">
        <h1>Login</h1>
        <hr>
        <div class="content">
            <input type="text" name="<%= Constants.KEY_LOGIN%>" value="" placeholder="<%=Constants.KEY_LOGIN%>">
            <input type="password" name="<%= Constants.KEY_PASSWORD%>" value="" placeholder="<%=Constants.KEY_PASSWORD%>">
            <input type="submit" name="Sign in" value="Sign in">
        </div>
        <hr>
    </form>
</div>
</body>
</html>