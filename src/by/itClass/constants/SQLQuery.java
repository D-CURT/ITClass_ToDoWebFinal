package by.itClass.constants;

public final class SQLQuery {
    public static final String SELECT_FOUND_USERS = "SELECT * FROM User WHERE login=? AND password=?";
    public static final String SELECT_FOUND_LOGIN = "SELECT * FROM User WHERE login=?";

    public static final String SELECT_LIST_TASK = "SELECT * FROM task WHERE idUSER = (SELECT id FROM user WHERE login=?) ";
    public static final String WHERE_TODAY_LIST_TASK = "AND dateTask = curdate() AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_TOMORROW_LIST_TASK = "AND dateTask = DATE_ADD(curdate(), INTERVAL 1 DAY) AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_SOMEDAY_LIST_TASK = "AND dateTask > DATE_ADD(curdate(). INTERVAL 1 DAY) AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_FIX_LIST_TASK = "AND flagFix = 1 AND flagRecycle = 0";
    public static final String WHERE_RECYCLE_LIST_TASK = "AND flagRecycle = 1";

    public static final String NAME_FIELD_ID = "id";
    public static final String NAME_FIELD_CONTENT = "contentTask";
    public static final String NAME_FIELD_DATE = "dateTask";
    public static final String NAME_FIELD_FIXED = "flagFix";
    public static final String NAME_FIELD_RECYCLE = "flagRecycle";

    public static final String INSERT_USERS = "INSERT INTO User (login, password, firstName, eMail) VALUES (?, ?, ?, ?)";

    public static final int LOGIN_POSITION = 1;
    public static final int PASSWORD_POSITION = 2;
    public static final int FIRST_NAME_POSITION = 3;
    public static final int EMAIL_POSITION = 4;

}
