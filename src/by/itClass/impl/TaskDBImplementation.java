package by.itClass.impl;

import by.itClass.constants.Constants;
import by.itClass.section.SectionEditTaskMenu;
import by.itClass.section.SectionTask;
import by.itClass.constants.SQLQuery;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.ConnectionManager;
import by.itClass.model.beans.Task;
import by.itClass.model.beans.User;
import by.itClass.valid.ValidationManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            list.addAll(getListFromResultSet(resultSet));
            return list;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    public List<Task> getTasks(User user, String dateTask, Enum<?> section) throws Exception {
        List<Task> list = new ArrayList<>();
        String sql = ((SectionTask) section).getSqlString();
        System.out.println(sql);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            preparedStatement.setDate(2, ValidationManager.getValidateDate(dateTask));
            resultSet = preparedStatement.executeQuery();
            list.addAll(getListFromResultSet(resultSet));
            return list;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    private static List<Task> getListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Task> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(SQLQuery.NAME_FIELD_ID);
                String title = resultSet.getString(SQLQuery.NAME_FIELD_TITLE);
                String contentTask = resultSet.getString(SQLQuery.NAME_FIELD_CONTENT);
                Date dateTask = resultSet.getDate(SQLQuery.NAME_FIELD_DATE);
                int flagFix = resultSet.getInt(SQLQuery.NAME_FIELD_FIXED);
                int flagRecycle = resultSet.getInt(SQLQuery.NAME_FIELD_RECYCLE);
                list.add(new Task(id, title, contentTask, dateTask, flagFix, flagRecycle));
            }
            return list;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
        }
    }

    @Override
    public void addTask(User user, Task task, Enum<?> section) throws Exception {
        SectionEditTaskMenu sect = (SectionEditTaskMenu) section;
        String sql = sect.getSqlString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            preparedStatement.setString(SQLQuery.TITLE_POSITION, task.getTitle());
            preparedStatement.setString(SQLQuery.CONTENT_POSITION, task.getContentTask());
            preparedStatement.setDate(SQLQuery.DATE_POSITION, task.getDateTask());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public void doEditTask(String[] listId, List<Task> list, Enum<?> section) throws Exception {
        String sql = ((SectionEditTaskMenu) section).getSqlString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (String id: listId) {
                for (Task task: list) {
                    if (task.id == Integer.parseInt(id)) {
                        preparedStatement.setString(1, task.getTitle());
                        preparedStatement.setString(2, task.getContentTask());
                        preparedStatement.setDate(3, task.getDateTask());
                        preparedStatement.setInt(4, task.id);
                        preparedStatement.execute();
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }
}