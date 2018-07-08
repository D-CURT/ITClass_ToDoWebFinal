<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Menu</title>
    <script type="text/javascript" src="Content/JS/sendFormDate.js"></script>
</head>
<body>
<%--<form action="task" name="paramList" value="" method="GET">
    <input type="hidden" name="paramList" value="">
</form>--%>
<jsp:include page="task" flush="true"/>

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
