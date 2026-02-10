package taskmanagement.rw.TaskManagement;

public class Task {
    Long taskId;
    String title;
    String description;
    boolean complete;
    String priority;
    String dueDate;

    public Task(Long taskId,String title,String description,boolean complete,String priority,String dueDate){
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.complete = complete;
        this.priority = priority;
        this.dueDate = dueDate;
    }
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}
