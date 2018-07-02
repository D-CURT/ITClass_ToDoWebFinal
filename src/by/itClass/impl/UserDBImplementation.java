package by.itClass.impl;

import by.itClass.constants.SQLQuery;
import by.itClass.interfaces.IUserDAO;
import by.itClass.model.beans.ConnectionManager;
import by.itClass.model.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBImplementation implements IUserDAO {

    @Override
    public boolean isFoundUser(User user, String password) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.SELECT_FOUND_USERS);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            preparedStatement.setString(SQLQuery.PASSWORD_POSITION, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    @Override
    public boolean addUser(User user, String password) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            if (!isFoundLogin(user)) {
                connection = ConnectionManager.createConnection();
                preparedStatement = connection.prepareStatement(SQLQuery.INSERT_USERS);

                preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
                preparedStatement.setString(SQLQuery.PASSWORD_POSITION, password);
                preparedStatement.setString(SQLQuery.FIRST_NAME_POSITION, user.getFirstName());
                preparedStatement.setString(SQLQuery.EMAIL_POSITION, user.getEmail());

                preparedStatement.executeUpdate();
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }

    public boolean isFoundLogin(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.createConnection();
            preparedStatement = connection.prepareStatement(SQLQuery.SELECT_FOUND_LOGIN);
            preparedStatement.setString(SQLQuery.LOGIN_POSITION, user.getLogin());
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            ConnectionManager.closeResultSet(resultSet);
            ConnectionManager.closeStatement(preparedStatement);
            ConnectionManager.closeConnection(connection);
        }
    }
}
