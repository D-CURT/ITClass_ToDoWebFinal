package by.itClass.valid;

import by.itClass.model.beans.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ValidationManager {


    public static Date getValidateDate(String date) {
        final SimpleDateFormat GET_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd");
        Date dateTask = null;
        String tmpDate = date.replace(".",":").replace("-",":");
        try {
            return new Date((GET_DATE_FORMAT.parse(tmpDate)).getTime());
        } catch (Exception e) {
            return dateTask;
        }

    }

    public static Task getTask(String contentTask, String dateTask) {
        Task task = null;
        Date date = getValidateDate(dateTask);
        if (date == null) {
            return task;
        }

        return new Task(contentTask, date);
    }
}
