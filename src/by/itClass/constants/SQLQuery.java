package by.itClass.constants;

public final class SQLQuery {
    public static final String SELECT_FOUND_USERS = "SELECT * FROM User WHERE login=? AND password=?";
    public static final String SELECT_FOUND_LOGIN = "SELECT * FROM User WHERE login=?";

    public static final int LOGIN_POSITION = 1;
    public static final int PASSWORD_POSITION = 2;

}
