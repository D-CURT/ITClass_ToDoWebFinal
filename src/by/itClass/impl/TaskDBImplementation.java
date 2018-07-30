package by.itClass.impl;

import by.itClass.section.SectionEditTaskMenu;
import by.itClass.section.SectionTask;
import by.itClass.constants.SQLQuery;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.ConnectionManager;
import by.itClass.model.beans.Task;
import by.itClass.model.beans.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskDBImplementation implements ITaskDAO {
    @Override
    public List<Task> getTasks(User user, Enum<?> section) throws Exception {
        System.out.println("\nIn DAO method getTasks();");

        List<Task> list = new ArrayList<>();
        String sql = ((SectionTask) section).getSqlString();
        System.out.println("getTasks(): query taken:\n" + sql);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("getTasks(): in try block;");

            connection = ConnectionManager.createConnection();
            System.out.println("getTasks(): connection taken;");

            preparedStatement = connection.prepareStatement(sql);
            System.out.println("getTasks(): statement taken;");

            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            System.out.println("getTasks(): login in query set;");

            System.out.println("getTasks(): query in statement now is:");
            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();
            System.out.println("getTasks(): resultSet taken;");

            list.addAll(getListFromResultSet(resultSet));
            System.out.println("getTasks(): list taken;");

            return list;
        } catch (SQLException e) {
            System.out.println("getTasks(): exception;");
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public List<Task> getTasks(User user, Date date, Enum<?> section) throws Exception {
        System.out.println("\nIn DAO method getTasks()[date];");

        List<Task> list = new ArrayList<>();
        String sql = ((SectionTask) section).getSqlString();
        System.out.println("getTasks()[date]: query taken:\n" + sql);

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("getTasks()[date]: in try block;");

            connection = ConnectionManager.createConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            statement.setDate(SQLQuery.DATE_CHOSEN_POSITION, date);
            System.out.println("getTasks()[date]: query in statement now is:");
            System.out.println(statement);

            resultSet = statement.executeQuery();
            System.out.println("getTasks()[date]: resultSet taken;");

            list.addAll(getListFromResultSet(resultSet));
            System.out.println("getTasks()[date]: list taken;");

            return list;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(statement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public void addTask(User user, Task task, Enum<?> section) throws Exception {
        System.out.println("\nIn DAO method addTask();");

        SectionEditTaskMenu sect = (SectionEditTaskMenu) section;
        String sql = sect.getSqlString();
        System.out.println("addTask(): query taken:\n" + sql);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            System.out.println("addTask(): in try block;");

            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (sect == SectionEditTaskMenu.ADD) {
                System.out.println("addTask(): in ADD section;");

                preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
                preparedStatement.setString(SQLQuery.TITLE_POSITION, task.getTitleTask());
                preparedStatement.setString(SQLQuery.CONTENT_POSITION, task.getContentTask());
                preparedStatement.setDate(SQLQuery.DATE_POSITION, task.getDateTask());
            } else {
                System.out.println("addTask(): in EDIT section;");

                preparedStatement.setString(SQLQuery.TITLE_EDIT_POSITION, task.getTitleTask());
                preparedStatement.setString(SQLQuery.CONTENT_EDIT_POSITION, task.getContentTask());
                preparedStatement.setDate(SQLQuery.DATE_EDIT_POSITION, task.getDateTask());
                preparedStatement.setInt(SQLQuery.ID_EDIT_POSITION, Integer.parseInt(task.getId()));
                System.out.println(preparedStatement);
            }
            System.out.println("addTask(): query in statement now is:");
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("addTask(): exception;");
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public void doEditTask(String[] arrayId, Enum<?> section) throws Exception {
        System.out.println("\nIn DAO method doEditTask();");

        String sql = ((SectionEditTaskMenu) section).getSqlString();
        System.out.println("doEditTask(): query taken:\n" + sql);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            System.out.println("doEditTask(): in try block;");

            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (String id: arrayId) {
                int idTask = Integer.parseInt(id);
                preparedStatement.setInt(SQLQuery.ID_TASK_POSITION, idTask);
                preparedStatement.executeUpdate();
            }
            System.out.println("doEditTask(): edit completed;");

        } catch (SQLException e) {
            System.out.println("doEditTask(): exception;");
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    private static List<Task> getListFromResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("\nIn DAO method getListFromResultSet();");

        List<Task> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String id = resultSet.getString(SQLQuery.NAME_FIELD_ID);
                String titleTask = resultSet.getString(SQLQuery.NAME_FIELD_TITLE);
                String contentTask = resultSet.getString(SQLQuery.NAME_FIELD_CONTENT);
                Date dateTask = resultSet.getDate(SQLQuery.NAME_FIELD_DATE);
                int flagFix = resultSet.getInt(SQLQuery.NAME_FIELD_FIXED);
                int flagRecycle = resultSet.getInt(SQLQuery.NAME_FIELD_RECYCLE);
                list.add(new Task(id, titleTask, contentTask, dateTask, flagFix, flagRecycle));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("getListFromResultSet(): exception;");
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
        }
    }

    @Override
    public void moveOldTaskToRecycle_bin(User user) throws SQLException {
        System.out.println("\nIn DAO method moveOldTaskToRecycle_bin();");

        String sql = SQLQuery.MOVE_OLD_TASK_TO_RECYCLE_BIN;
        System.out.println("moveOldTaskToRecycle_bin(): query taken:\n" + sql);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            System.out.println("moveOldTaskToRecycle_bin(): in try block;");

            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());

            System.out.println("moveOldTaskToRecycle_bin(): query in statement now is:");
            System.out.println(preparedStatement);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("moveOldTaskToRecycle_bin(): exception;");
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }
}