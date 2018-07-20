package by.itClass.model.beans;

import by.itClass.impl.TaskDBImplementation;
import by.itClass.interfaces.ITaskDAO;

import java.sql.Date;
import java.sql.SQLException;

public class OldTaskCollector {
    private static volatile OldTaskCollector instance;
    private volatile Date date;

    private OldTaskCollector(Date date) {
        this.date = date;
    }

    public static OldTaskCollector getInstance(User user) {
        OldTaskCollector localInstance = null;
        Date dateTask;
        TaskDBImplementation tmp = new TaskDBImplementation();
        try {
            dateTask = tmp.getOldTaskDate(user);
            localInstance = instance;
            if (localInstance == null) {
                synchronized (OldTaskCollector.class) {
                    localInstance = instance;
                    if (localInstance == null) {
                        tmp.moveOldTaskToTrash(user);
                        return instance = localInstance = new OldTaskCollector(dateTask);
                    }
                }
            } else if (dateTask.compareTo(instance.date) == 1) {
                return instance = new OldTaskCollector(dateTask);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return localInstance;
    }
}
