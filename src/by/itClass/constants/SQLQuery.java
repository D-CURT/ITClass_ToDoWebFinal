package by.itClass.constants;

public final class SQLQuery {
    public static final String SELECT_FOUND_USERS = "SELECT * FROM User WHERE login=? AND password=?";
    public static final String SELECT_FOUND_LOGIN = "SELECT * FROM User WHERE login=?";

    public static final String SELECT_LIST_TASK = "SELECT * FROM task WHERE idUSER = (SELECT id FROM user WHERE login=?) ";
    public static final String WHERE_TODAY_LIST_TASK = "AND dateTask = curdate() AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_TOMORROW_LIST_TASK = "AND dateTask = DATE_ADD(curdate(), INTERVAL 1 DAY) AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_SOMEDAY_LIST_TASK = "AND dateTask > DATE_ADD(curdate(), INTERVAL 1 DAY) AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_FIX_LIST_TASK = "AND flagFix = 1 AND flagRecycle = 0";
    public static final String WHERE_RECYCLE_LIST_TASK = "AND flagRecycle = 1";
    public static final String WHERE_OLD_TASK = "AND dateTask < curdate() AND flagFix = 0 AND flagRecycle = 0";
    public static final String WHERE_CHOSEN_TASK = "AND dateTask=? AND flagFix = 0 AND flagRecycle = 0";

    public static final String NAME_FIELD_ID = "id";
    public static final String NAME_FIELD_TITLE = "titleTask";
    public static final String NAME_FIELD_CONTENT = "contentTask";
    public static final String NAME_FIELD_DATE = "dateTask";
    public static final String NAME_FIELD_FIXED = "flagFix";
    public static final String NAME_FIELD_RECYCLE = "flagRecycle";

    public static final String INSERT_USERS = "INSERT INTO user (login, password, firstName, eMail) VALUES (?, ?, ?, ?)";
    public static final String WHERE_TASK_ID = "AND id=?";
    public static final String ADD_TASK = "INSERT INTO task (idUser, titleTask, contentTask, dateTask) VALUES ((SELECT id FROM user WHERE login=?),?,?,?)";
    public static final String EDIT_TASK = "UPDATE task SET contentTask=?, dateTask=? WHERE id=?";
    public static final String FIX_TASK = "UPDATE task SET flagFix=1 WHERE id=?";
    public static final String UNFIX_TASK = "UPDATE task SET flagFix=0 WHERE id=?";
    public static final String MOVE_TASK_TO_RECYCLE_BIN = "UPDATE task SET flagRecycle=1 WHERE id=?";
    public static final String MOVE_OLD_TASK_TO_RECYCLE_BIN = "UPDATE task SET flagRecycle=1 WHERE idUser = (SELECT id FROM user WHERE login=?) AND dateTask < curdate()";
    public static final String REMOVE_TASK = "DELETE FROM task WHERE id=?";
    public static final String RESTORE_TASK = "UPDATE task SET flagRecycle=0 WHERE id=?";

    public static final int LOGIN_POSITION = 1;
    public static final int PASSWORD_POSITION = 2;
    public static final int FIRST_NAME_POSITION = 3;
    public static final int EMAIL_POSITION = 4;

    public static final int ID_TASK_POSITION = 1;
    public static final int TITLE_POSITION = 2;
    public static final int CONTENT_POSITION = 3;
    public static final int DATE_POSITION = 4;
    public static final int TITLE_EDIT_POSITION = 1;
    public static final int CONTENT_EDIT_POSITION = 2;
    public static final int DATE_EDIT_POSITION = 3;
    public static final int ID_EDIT_POSITION = 4;

}
