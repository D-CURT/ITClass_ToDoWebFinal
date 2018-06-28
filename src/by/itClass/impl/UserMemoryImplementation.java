package by.itClass.impl;

import by.itClass.interfaces.IUserDAO;
import by.itClass.model.beans.User;

import java.util.HashMap;
import java.util.Map;

public class UserMemoryImplementation implements IUserDAO {
    public static Map<User, String> users = new HashMap<>();
    static {
        users.put(new User("sys", "Alex", "Decurt@mail.ru"), "111");
    }

    @Override
    public boolean isFoundUser(User user, String password) throws Exception {
        String pass = users.get(user);
        if (pass != null) {
            return password.equals(pass);
        }
        return false;
    }

    @Override
    public boolean addUser(User user, String password) throws Exception {
        if (!isFoundLogin(user)) {
            users.put(user, password);
        }
        return false;
    }

    public static boolean isFoundLogin(User user) {
        if (users.get(user) != null) return true;
        return false;
    }
}
