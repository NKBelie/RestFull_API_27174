package taskmanagement.rw.TaskManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    List<Task> tasks = new ArrayList<>();
    
    public TaskController() {
        tasks.add(new Task(1L, "Task 1", "JAVA assignment", false, "High", "2026-02-12"));
        tasks.add(new Task(2L, "Task 2", "Software Engineering", true, "Medium", "2026-01-30"));
        tasks.add(new Task(3L, "Task 3", "Web Tech ", false, "Low", "2026-02-10"));
        tasks.add(new Task(4L, "Task 4", "Innovaction Center", true, "High", "2026-02-22"));
        tasks.add(new Task(5L, "Task 5", "Data Science", false, "Medium", "2026-02-15"));

    }
    @GetMapping
    public List<Task> getAllTasks(){
        return tasks;
    }
    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long id){
        return tasks.stream().filter(task -> task.getTaskId().equals(id)).findFirst().orElse(null);
    }
    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam boolean complete){
        return tasks.stream().filter(task -> task.isComplete() == complete).collect(Collectors.toList());
    }
    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority){
        return tasks.stream().filter(task -> task.getPriority().equals(priority)).collect(Collectors.toList());
    }
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        tasks.add(task);
        return task;
    }
    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask){
        Optional<Task> existingTask = tasks.stream().filter(task -> task.getTaskId().equals(taskId)).findFirst();
        if(existingTask.isPresent()){
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setComplete(updatedTask.isComplete());
            task.setPriority(updatedTask.getPriority());
            task.setDueDate(updatedTask.getDueDate());
            return task;
        }
        return null;
    }
    @PatchMapping("/{taskId}")
    public Task updateTaskStatus(@PathVariable Long taskId, @RequestParam boolean complete){
        Optional<Task> existingTask = tasks.stream().filter(task -> task.getTaskId().equals(taskId)).findFirst();
        if(existingTask.isPresent()){
            Task task = existingTask.get();
            task.setComplete(complete);
            return task;
        }
        return null;
    }
    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable Long taskId){
        boolean removed = tasks.removeIf(task -> task.getTaskId().equals(taskId));
        if(removed){
            return "Task with ID "+ taskId + " deleted successfully";
        }else{
            return "Task with ID "+ taskId + " not found";
        }
    }


}
