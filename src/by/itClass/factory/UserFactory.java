package by.itClass.factory;

import by.itClass.impl.UserDBImplementation;
import by.itClass.impl.UserMemoryImplementation;
import by.itClass.interfaces.IUserDAO;

public class UserFactory {
    public static IUserDAO getClassFromFactory() {
        //return new UserMemoryImplementation();
        return new UserDBImplementation();
    }
}
