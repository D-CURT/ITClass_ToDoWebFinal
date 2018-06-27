package by.itClass.interfaces;

import by.itClass.model.beans.User;

public interface IUserDAO {
    boolean isFoundUser(User user, String password) throws Exception;
    boolean addUser(User user, String password) throws Exception;
}
