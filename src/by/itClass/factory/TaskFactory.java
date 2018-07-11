package by.itClass.factory;

import by.itClass.section.SectionManager;
import by.itClass.impl.TaskDBImplementation;
import by.itClass.interfaces.ITaskDAO;

public class TaskFactory {
    public static ITaskDAO getITaskDAO() {
        return new TaskDBImplementation();
    }

    public static Enum<?> getKindSectionTask(String paramList) {
        return SectionManager.getKindSectionTask(paramList);
    }

    public static  Enum<?> getKindSectionEditTask(String paramEdit) {
        return SectionManager.getKindSectionTask(paramEdit);
    }
}
