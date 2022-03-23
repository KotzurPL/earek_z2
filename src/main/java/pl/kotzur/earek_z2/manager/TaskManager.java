package pl.kotzur.earek_z2.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kotzur.earek_z2.model.Status;
import pl.kotzur.earek_z2.model.Task;
import pl.kotzur.earek_z2.model.User;
import pl.kotzur.earek_z2.repo.StatusRepo;
import pl.kotzur.earek_z2.repo.TaskRepo;
import pl.kotzur.earek_z2.repo.UserRepo;

import java.util.Optional;
import java.util.Set;

@Service
public class TaskManager {

    private TaskRepo taskRepo;
    private StatusRepo statusRepo;
    private UserRepo userRepo;

    @Autowired
    public TaskManager(TaskRepo taskRepo, StatusRepo statusRepo, UserRepo userRepo) {
        this.taskRepo = taskRepo;
        this.statusRepo = statusRepo;
        this.userRepo = userRepo;
    }

    public Optional<Task> findById(Long index) {
        return taskRepo.findById(index);
    }

    public Iterable<Task> findAll() {
        return taskRepo.findAll();
    }

    public Task save(Task task) {
        return taskRepo.save(task);
    }

    public void deleteById(Long index) {
        taskRepo.deleteById(index);
    }

    public void changeStatus(Long id_task, Long id_status) {
        Task task = taskRepo.findById(id_task).get();
        Status status = statusRepo.findById(id_status).get();
        task.setStatus(status);
        taskRepo.save(task);
    }

    public void addUser(Long id_task, Long id_user) {
        Task task = taskRepo.findById(id_task).get();
        User user = userRepo.findById(id_user).get();
        Set<User> users = task.getUsers();
        users.add(user);
        task.setUsers(users);
        taskRepo.save(task);
    }

}
