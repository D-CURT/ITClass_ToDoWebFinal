package by.itClass.model.beans;

import by.itClass.impl.TaskDBImplementation;
import by.itClass.interfaces.ITaskDAO;

import java.sql.Date;
import java.sql.SQLException;

public class OldTaskCollector {
    private static volatile OldTaskCollector instance;

    public static OldTaskCollector getInstance(User user) {
        OldTaskCollector localInstance = null;
        TaskDBImplementation tmp = new TaskDBImplementation();
        try {
            if (tmp.searchOldTask(user)) {
                localInstance = instance;
                if (localInstance == null) {
                    synchronized (OldTaskCollector.class) {
                        localInstance = instance;
                        if (localInstance == null)
                            tmp.moveOldTaskToTrash(user);
                        return instance = localInstance = new OldTaskCollector();
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return localInstance;
    }
}
