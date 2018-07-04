package by.itClass.factory;

import by.itClass.Section.SectionManager;
import by.itClass.impl.TaskDBImplementation;
import by.itClass.interfaces.ITaskDAO;

public class TaskFactory {
    public static ITaskDAO getITaskDAO() {
        return new TaskDBImplementation();
    }

    public static Enum<?> getKindSectionTask(String paramList) {
        return SectionManager.getKindSectionTask(paramList);
    }
}
