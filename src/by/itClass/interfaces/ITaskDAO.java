package by.itClass.interfaces;

import by.itClass.model.beans.Task;
import by.itClass.model.beans.User;

import java.sql.Date;
import java.util.List;

public interface ITaskDAO {
    Task getTask(String id, Enum<?> section) throws Exception;

    List<Task> getTasks(User user, Enum<?> section) throws Exception;

    List<Task> getTasks(User user, Date date, Enum<?> section) throws Exception;

    void addTask(User user, Task task, Enum<?> section) throws Exception;

    void doEditTask(String[] arrayId, Enum<?> section) throws Exception;

    void moveOldTaskToRecycle_bin(User user) throws Exception;


}
