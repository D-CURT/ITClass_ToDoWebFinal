package by.itClass.impl;

import by.itClass.interfaces.IUserDAO;
import by.itClass.model.beans.User;

import java.util.HashMap;
import java.util.Map;

public class UserMemoryImplementation implements IUserDAO {
    public Map<User, String> users = new HashMap<>();
    static {
        users.put()
    }
    public User getUser(String login, String password) {
        Role role = null;
        if ("sys".equals(login) && "111".equals(password)) {
            role = role.ADMIN;
        } else {
            if ("boss".equals(login) && "222".equals(password)) {
                role = role.USER;
            } else {
                role = role.VISITER;
            }
        }
        return new User(login, role);
    }

    @Override
    public boolean isFoundUser(User user, String password) throws Exception {
        return false;
    }

    @Override
    public boolean addUser(User user, String password) throws Exception {
        return false;
    }
}
