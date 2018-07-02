package by.itClass.impl;

import by.itClass.interfaces.IUserDAO;
import by.itClass.model.beans.User;

public class UserDBImplementation implements IUserDAO {

    @Override
    public boolean isFoundUser(User user, String password) throws Exception {

        return false;
    }

    @Override
    public boolean addUser(User user, String password) throws Exception {
        return false;
    }
}
