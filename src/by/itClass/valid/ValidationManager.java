package by.itClass.valid;

import by.itClass.model.beans.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ValidationManager {
    public static final SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd");

    public static Date getValidDate(String date) {
        /*final SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd");*/
        Date dateTask = null;
        String tmpDate = date.replace(".",":").replace("-",":");
        try {
            return new Date((GET_DATE_FORMAT.parse(tmpDate)).getTime());
        } catch (Exception e) {
            return dateTask;
        }
    }

    public static boolean isValidDate(String date) {
        try {
            date = GET_DATE_FORMAT.format(date.replace(".","-").replace(":","-"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Task getTask(String title, String contentTask, String dateTask) {
        Task task = null;
        Date date = getValidDate(dateTask);
        if (date == null) return task;
        return new Task(title, contentTask, date);
    }
}
