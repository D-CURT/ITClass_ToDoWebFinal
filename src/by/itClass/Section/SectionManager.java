package by.itClass.Section;

public class SectionManager {
    public static Enum<?> getKindSectionTask(String paramList) {
        try {
            return SectionTask.valueOf(paramList.toUpperCase());
        } catch (IllegalArgumentException e) {
            return SectionTask.TODAY;
        }
    }

    public static Enum<?> getKindSectionEditTaskMenu(String paramEdit) {
        try {
            return SectionEditTaskMenu.valueOf(paramEdit);
        } catch (IllegalArgumentException e) {
            return SectionEditTaskMenu.OTHER;
        }
    }
}
