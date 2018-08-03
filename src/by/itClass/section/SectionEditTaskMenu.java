package by.itClass.section;

import by.itClass.constants.SQLQuery;

public enum SectionEditTaskMenu {
    ADD(SQLQuery.ADD_TASK),
    EDIT(SQLQuery.EDIT_TASK),
    FIX(SQLQuery.FIX_TASK),
    UNFIX(SQLQuery.UNFIX_TASK),
    RECYCLE(SQLQuery.MOVE_TASK_TO_RECYCLE_BIN),
    REMOVE(SQLQuery.REMOVE_TASK),
    RESTORE(SQLQuery.RESTORE_TASK),
    VIEW(SQLQuery.SELECT_TASK),
    OTHER("");

    private String sqlString;

    SectionEditTaskMenu(String sqlString) {
        this.sqlString = sqlString;
    }

    public String getSqlString() {
        return sqlString;
    }
}
