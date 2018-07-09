package by.itClass.Section;

import by.itClass.constants.SQLQuery;

public enum SectionEditTaskMenu {
    ADD(SQLQuery.ADD_TASK),
    EDIT(SQLQuery.EDIT_TASK),
    FIX(SQLQuery.FIX_TASK),
    RECYCLE(SQLQuery.MOVE_TASK_TO_RECYCLE_BIN),
    REMOVE(SQLQuery.REMOVE_TASK),
    RESTORE(SQLQuery.RESTORE_TASK);

    private String sqlString;

    SectionEditTaskMenu(String sqlString) {
        this.sqlString = sqlString;
    }

    public String getSqlString() {
        return sqlString;
    }
}
