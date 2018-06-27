
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="loginForm" action='<c:url value="/login">' method="POST">
    <h1>Login</h1>
    <input type="text" name="<%= Constants.KEY_LOGIN%>" value="" placeholder="login">
    <input type="password" name="<%= Constants.KEY_PASSWORD%>" value="" placeholder="password">
    <input type="submit" name="Log in">

    </form>

</form>
</body>
</html>
