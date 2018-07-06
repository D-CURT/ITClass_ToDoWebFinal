<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form name="regForm" action="<c:url value='/regist'/>" method="POST">
         <h1>Registration</h1>
         <input type="text" name="<%= Constants.KEY_LOGIN%>" value="" placeholder="login">
         <input type="password" name="<%= Constants.KEY_PASSWORD%>" value="" placeholder="password">
         <input type="text" name="<%= Constants.KEY_FIRST_NAME%>" value="" placeholder="firstName">
         <input type="email" name="<%= Constants.KEY_EMAIL%>" value="" placeholder="email">
         <input type="submit" name="Registration" value="Registration">
    </form>

</body>
</html>
