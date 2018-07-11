package by.itClass.section;

import by.itClass.constants.SQLQuery;

public enum SectionTask {
    TODAY(SQLQuery.WHERE_TODAY_LIST_TASK),
    TOMORROW(SQLQuery.WHERE_TOMORROW_LIST_TASK),
    SOMEDAY(SQLQuery.WHERE_SOMEDAY_LIST_TASK),
    RECYCLE(SQLQuery.WHERE_RECYCLE_LIST_TASK),
    FIXED(SQLQuery.WHERE_FIX_LIST_TASK);

    private String sqlString;

    SectionTask(String sqlString) {
        this.sqlString = SQLQuery.SELECT_LIST_TASK + sqlString;
    }

    public String getSqlString() {
        return sqlString;
    }
}
