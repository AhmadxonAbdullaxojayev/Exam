import java.util.Date;

public class Reminder {
    private String task;
    private Date time;
    private boolean completed;

    public Reminder(String task, Date time, boolean completed) {
        this.task = task;
        this.time = time;
        this.completed = completed;
    }

    public Reminder(String task, Date time) {
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
