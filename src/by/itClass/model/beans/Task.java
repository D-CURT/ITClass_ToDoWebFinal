package by.itClass.model.beans;

import java.sql.Date;

public class Task {
    private String id;
    private String titleTask;
    private String contentTask;
    private Date dateTask;
    private int flagFix;
    private int flagRecycle;

    public Task() {}

    public Task(String id, String titleTask, String contentTask, Date dateTask, int flagFix, int flagRecycle) {
        this.id = id;
        this.titleTask = titleTask;
        this.contentTask = contentTask;
        this.dateTask = dateTask;
        this.flagFix = flagFix;
        this.flagRecycle = flagRecycle;
    }

    public Task(String id, String titleTask, String contentTask, Date dateTask) {
        this.id = id;
        this.titleTask = titleTask;
        this.contentTask = contentTask;
        this.dateTask = dateTask;
    }

    public Task(String titleTask, String contentTask,Date dateTask) {
        this.titleTask = titleTask;
        this.contentTask = contentTask;
        this.dateTask = dateTask;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public void setId(String id) throws NumberFormatException {
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

    }*/

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getContentTask() {
        return contentTask;
    }

    public void setContentTask(String contentTask) {
        this.contentTask = contentTask;
    }

    public Date getDateTask() {
        return dateTask;
    }

    public void setDateTask(Date dateTask) {
        this.dateTask = dateTask;
    }

    public int getFlagFix() {
        return flagFix;
    }

    public void setFlagFix(int flagFix) {
        this.flagFix = flagFix;
    }

    public int getFlagRecycle() {
        return flagRecycle;
    }

    public void setFlagRecycle(int flagRecycle) {
        this.flagRecycle = flagRecycle;
    }
}
