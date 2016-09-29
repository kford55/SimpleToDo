package kennethford.simpletodo;

/**
 * Created by kennethford on 9/28/16.
 */
public class Task {

    private String taskDescription;
    private String priority;
    private boolean isDone;

    //May make the priority an enum, but I know there are memory issues
    //and efficiency in android with enums, looking for better solution
    public Task(String description, String priority) {
        this.taskDescription = description;
        this.priority = priority;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
