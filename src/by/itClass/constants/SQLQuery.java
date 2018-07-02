package by.itClass.constants;

public final class SQLQuery {
    public static final String SELECT_FOUND_USERS = "SELECT * FROM User WHERE login=? AND password=?";
    public static final String SELECT_FOUND_LOGIN = "SELECT * FROM User WHERE login=?";

    public static final String INSERT_USERS = "INSERT INTO User (login, password, firstName, eMail) VALUES (?, ?, ?, ?)";

    public static final int LOGIN_POSITION = 1;
    public static final int PASSWORD_POSITION = 2;
    public static final int FIRST_NAME_POSITION = 3;
    public static final int EMAIL_POSITION = 4;

}
