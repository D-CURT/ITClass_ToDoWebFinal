<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
<head>
    <title>Task Menu</title>
    <script type="text/javascript" src="Content/JS/sendChangedData.js"></script>
</head>
<body>
<form action="task" name="next" value="" method="POST">
    <input type="hidden" name="<%= Constants.KEY_PARAM_LIST%>" value="">
    <table>
        <tr>
            <td><a href="JavaScript:sendChangedData('today')">Today</a></td>
            <td><a href="JavaScript:sendChangedData('tomorrow')">Tomorrow</a></td>
            <td><a href="JavaScript:sendChangedData('someday')">Someday</a></td>
            <td><a href="JavaScript:sendChangedData('fixed')">Fixed</a></td>
            <td><a href="JavaScript:sendChangedData('recycle')">Recycle Bin</a></td>
        </tr>
    </table>
</form>

</body>
</html>
