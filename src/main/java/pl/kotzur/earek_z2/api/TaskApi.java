package pl.kotzur.earek_z2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kotzur.earek_z2.manager.TaskManager;
import pl.kotzur.earek_z2.model.Task;

import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskApi {

    private TaskManager taskManager;

    @Autowired
    public TaskApi(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @GetMapping("/all")
    public Iterable<Task> getAll() {
        return taskManager.findAll();
    }

    @GetMapping
    public Optional<Task> getById(@RequestParam Long index) {
        return taskManager.findById(index);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskManager.save(task);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return taskManager.save(task);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam Long index) {
        taskManager.deleteById(index);
    }

    @PutMapping("/changeStatus")
    public void changeTaskStatus(@RequestParam Long taskIndex, @RequestParam Long newStatus) {
        taskManager.changeStatus(taskIndex, newStatus);
    }

    @PutMapping("/addUser")
    public void addUser(@RequestParam Long taskIndex, @RequestParam Long newUser) {
        taskManager.addUser(taskIndex, newUser);
    }

}
