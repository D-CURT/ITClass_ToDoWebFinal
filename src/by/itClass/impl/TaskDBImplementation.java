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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

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

    @Override
    public void addTask(User user, Task task, Enum<?> section) throws Exception {
        SectionEditTaskMenu sect = (SectionEditTaskMenu) section;
        String sql = sect.getSqlString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement);
            if (sect == SectionEditTaskMenu.ADD) {
                preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
                preparedStatement.setString(SQLQuery.TITLE_POSITION, task.getTitle());
                preparedStatement.setString(SQLQuery.CONTENT_POSITION, task.getContentTask());
                preparedStatement.setDate(SQLQuery.DATE_POSITION, task.getDateTask());
            } else {
                preparedStatement.setString(SQLQuery.CONTENT_EDIT_POSITION, task.getContentTask());
                preparedStatement.setDate(SQLQuery.DATE_EDIT_POSITION, task.getDateTask());
                preparedStatement.setInt(SQLQuery.ID_EDIT_POSITION, task.getId());
                System.out.println(preparedStatement);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public void doEditTask(String[] arrayId, Enum<?> section) throws Exception {
        String sql = ((SectionEditTaskMenu) section).getSqlString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            System.out.println(1);
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (String id: arrayId) {
                int idTask = Integer.parseInt(id);
                preparedStatement.setInt(SQLQuery.ID_TASK_POSITION, idTask);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
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

    public void moveOldTaskToTrash(User user) throws SQLException {
        String sql = SQLQuery.MOVE_OLD_TASK_TO_RECYCLE_BIN;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            System.out.println(preparedStatement);
            preparedStatement.execute();
            /*resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.e
            }*/

        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    public boolean searchOldTask(User user) throws SQLException {
        String sql = SQLQuery.SELECT_LIST_TASK + SQLQuery.WHERE_OLD_TASK;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return true;
            else return false;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }
}