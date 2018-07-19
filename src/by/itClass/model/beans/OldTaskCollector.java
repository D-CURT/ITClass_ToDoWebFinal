package by.itClass.model.beans;

import by.itClass.impl.TaskDBImplementation;
import by.itClass.interfaces.ITaskDAO;

import java.sql.Date;
import java.sql.SQLException;

public class OldTaskCollector {
    /*public static class CollectorHolder {
        public static final OldTaskCollector HOLDER_INSTANCE = new OldTaskCollector();
    }

    public static OldTaskCollector getInstance(User user) throws SQLException {
        OldTaskCollector localInstance = CollectorHolder.HOLDER_INSTANCE;
        if (localInstance == null) {
            TaskDBImplementation tmp = new TaskDBImplementation();
            try {
                if (tmp.searchOldTask(user))
                    tmp.moveOldTaskToTrash(user);

                return CollectorHolder.HOLDER_INSTANCE;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return localInstance;
    }*/

    private static volatile OldTaskCollector instance;

    public static OldTaskCollector getInstance(User user) {
        OldTaskCollector localInstance = instance;
        if (localInstance == null) {
            synchronized (OldTaskCollector.class) {
                localInstance = instance;
                if (localInstance == null) {
                    TaskDBImplementation tmp = new TaskDBImplementation();
                    try {
                        if (tmp.searchOldTask(user))
                            tmp.moveOldTaskToTrash(user);

                        return instance = localInstance = new OldTaskCollector();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return localInstance;
    }
}
