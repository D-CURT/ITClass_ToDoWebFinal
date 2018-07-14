package by.itClass.model.beans;

import java.sql.Date;

public class Task {
    public int id;
    private String title;
    private String contentTask;
    private Date dateTask;
    private int flagFix;
    private int flagRecycle;

    public Task() {}

    public Task(int id, String title, String contentTask, Date dateTask, int flagFix, int flagRecycle) {
        this.id = id;
        this.title = title;
        this.contentTask = contentTask;
        this.dateTask = dateTask;
        this.flagFix = flagFix;
        this.flagRecycle = flagRecycle;
    }

    public Task(int id, String title, String contentTask, Date dateTask) {
        this.id = id;
        this.title = title;
        this.contentTask = contentTask;
        this.dateTask = dateTask;
    }

    public Task(String contentTask, Date dateTask) {
        this.contentTask = contentTask;
        this.dateTask = dateTask;
    }

    /*public Task(String title, Date dateTask) {
        this.title = title;
        this.dateTask = dateTask;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) throws NumberFormatException {
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
