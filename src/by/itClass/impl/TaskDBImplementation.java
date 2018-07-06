package by.itClass.impl;

import by.itClass.Section.SectionTask;
import by.itClass.constants.SQLQuery;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.ConnectionManager;
import by.itClass.model.beans.Task;
import by.itClass.model.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDBImplementation implements ITaskDAO {
    @Override
    public List<Task> getTasks(User user, Enum<?> section) throws Exception {
        List<Task> list = new ArrayList<>();
        String sql = ((SectionTask) section).getSqlString();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(SQLQuery.NAME_FIELD_ID);
                String contentTask = resultSet.getString(SQLQuery.NAME_FIELD_CONTENT);
                Date dateTask = resultSet.getDate(SQLQuery.NAME_FIELD_DATE);
                int flagFix = resultSet.getInt(SQLQuery.NAME_FIELD_FIXED);
                int flagRecycle = resultSet.getInt(SQLQuery.NAME_FIELD_RECYCLE);
                list.add(new Task(id, contentTask, dateTask, flagFix, flagRecycle));
            }
            return list;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public void addTask(User user, Task task, Enum<?> section) throws Exception {

    }

    @Override
    public void doEditTask(String[] listId, Enum<?> section) throws Exception {

    }
}
