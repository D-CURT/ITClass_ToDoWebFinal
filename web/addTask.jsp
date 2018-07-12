<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
</head>
<body>
    <form action="edit" method="post" name="addTask">
        <input type="hidden" name="paramEdit" value="add">
        <table border="1">
            <tr><td>Add Task</td></tr>
            <tr>
                <td><input type="text" name="contentTask" value=""></td>
                <td><input type="date" name="dateTask" value=""></td>
                <td><input type="submit" value="Add new task"></td>
            </tr>
        </table>
    </form>
</body>
</html>
