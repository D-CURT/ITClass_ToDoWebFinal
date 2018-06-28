<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="loginForm" action="<c:url value='/login'/>" method="POST">
    <h1>Login</h1>
    <input type="text" name="<%= Constants.KEY_LOGIN%>" value="" placeholder="login">
    <input type="password" name="<%= Constants.KEY_PASSWORD%>" value="" placeholder="password">
    <input type="submit" name="Log in">

</form>

</body>
</html>