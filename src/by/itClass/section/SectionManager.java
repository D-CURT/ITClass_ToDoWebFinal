package by.itClass.section;

public class SectionManager {
    public static Enum<?> getKindSectionTask(String paramList) {
        try {
            System.out.println(3);
            return SectionTask.valueOf(paramList.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println(4);
            return SectionTask.TODAY;
        }
    }

    public static Enum<?> getKindSectionEditTaskMenu(String paramEdit) {
        try {
            return SectionEditTaskMenu.valueOf(paramEdit.toUpperCase());
        } catch (IllegalArgumentException e) {
            return SectionEditTaskMenu.OTHER;
        }
    }
}
