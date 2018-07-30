package by.itClass.model.beans;

import by.itClass.interfaces.ITaskDAO;
import java.sql.Date;

public class OldTaskManager {
    /*private static volatile OldTaskManager instance;
    private volatile Date date;

    private OldTaskManager(Date date) {
        this.date = date;
    }

    public static OldTaskManager getInstance(User user, ITaskDAO taskDAO) {
        System.out.println("\nIn OldTask method getInstance();");

        OldTaskManager localInstance = null;
        Date dateTask;
        try {
            System.out.println("getInstance(): in try block;");

            //dateTask = getCurrentDate();
            System.out.println("getInstance(): dateTask initialized;");

            synchronized (OldTaskManager.class) {
                localInstance = instance;
                System.out.println("getInstance(): localInstance initilized;");

                if (localInstance == null) {
                    System.out.println("getInstance(): instance is null;");

                    taskDAO.moveOldTaskToTrash(user);
                    System.out.println("getInstance(): old task moved;");

                    //return instance = localInstance = new OldTaskManager(dateTask);
                } else if (dateTask.compareTo(instance.date) == 1) {
                    System.out.println("getInstance(): instance is not null;");

                    return instance = new OldTaskManager(dateTask);
                }
            }
        } catch (Exception e) {
            System.out.println("getInstance(): exception;");
            e.printStackTrace();
        }
        return localInstance;
    }

    @Override
    public String toString() {
        return "OldTaskManager{" +
                "date=" + date +
                '}';
    }*/
}
