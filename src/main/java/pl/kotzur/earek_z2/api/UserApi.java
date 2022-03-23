package pl.kotzur.earek_z2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kotzur.earek_z2.manager.UserManager;
import pl.kotzur.earek_z2.model.User;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApi {

    private UserManager userManager;

    @Autowired
    public UserApi(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/all")
    public Iterable<User> getAll() {
        return userManager.findAll();
    }

    @GetMapping
    public Optional<User> getById(@RequestParam Long index) {
        return userManager.findById(index);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userManager.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userManager.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long index) {
        userManager.deleteById(index);
    }

}
