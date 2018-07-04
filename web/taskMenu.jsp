
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="Content/JS/sendFormDate.js"></script>
</head>
<body>
    <form name="next" method="POST" action='<c:url value="/task"/>'>
        <input type="hidden" name="paramList" value="">
    </form>
    <table>
        <tr>
            <td><a href="JavaScript:sendNextForm('today')">Today</a></td>
            <td><a href="JavaScript:sendNextForm('tomorrow')">Tomorrow</a></td>
            <td><a href="JavaScript:sendNextForm('someday')">Someday</a></td>
            <td><a href="JavaScript:sendNextForm('recycle')">Fixed</a></td>
            <td><a href="JavaScript:sendNextForm('fixed')">Recycle_Bin</a></td>
        </tr>
    </table>
</body>
</html>
