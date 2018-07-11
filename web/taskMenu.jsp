<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Menu</title>
    <script type="text/javascript" src="Content/JS/sendNextForm.js"></script>
</head>
<body>
<form action="task" name="next" value="" method="GET">
    <input type="hidden" name="paramList" value="">
</form>
    <table>
        <tr>
            <td><a href="JavaScript:sendNextForm('today')">Today</a></td>
            <td><a href="JavaScript:sendNextForm('tomorrow')">Tomorrow</a></td>
            <td><a href="JavaScript:sendNextForm('someday')">Someday</a></td>
            <td><a href="JavaScript:sendNextForm('fixed')">Fixed</a></td>
            <td><a href="JavaScript:sendNextForm('recycle')">Recycle_Bin</a></td>
        </tr>
    </table>



</body>
</html>
