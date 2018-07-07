<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Menu</title>
    <script type="text/javascript" src="Content/JS/sendFormDate.js"></script>
</head>
<body>
<jsp:include page="task"><input type="hidden" name="paramList" value=""></jsp:include>

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
