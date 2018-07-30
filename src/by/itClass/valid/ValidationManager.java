package by.itClass.valid;

import by.itClass.constants.Constants;
import by.itClass.model.beans.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ValidationManager {

    public static Date getCurrentDate() {
        String formattedDate = Constants.GET_DATE_FORMAT.format(new java.util.Date());
        return getValidDate(formattedDate);
    }

    public static Date getValidDate(String date) {
        Date dateTask = null;
        String tmpDate = date.replace(".",":").replace("-",":");
        try {
            return new Date((Constants.GET_DATE_FORMAT.parse(tmpDate)).getTime());
        } catch (Exception e) {
            return dateTask;
        }
    }

    public static Task getTask(String titleTask, String contentTask, String dateTask) {
        Task task = null;
        Date date = getValidDate(dateTask);
        if (date == null) return task;
        return new Task(titleTask, contentTask, date);
    }
}
