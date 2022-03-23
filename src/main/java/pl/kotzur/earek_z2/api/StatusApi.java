package pl.kotzur.earek_z2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kotzur.earek_z2.manager.StatusManager;
import pl.kotzur.earek_z2.model.Status;

import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusApi {

    private StatusManager statusManager;

    @Autowired
    public StatusApi(StatusManager statusManager) {
        this.statusManager = statusManager;
    }

    @GetMapping("/all")
    public Iterable<Status> getAll() {
        return statusManager.findAll();
    }

    @GetMapping
    public Optional<Status> getById(@RequestParam Long index) {
        return statusManager.findById(index);
    }

    @PostMapping
    public Status addStatus(@RequestBody Status status) {
        return statusManager.save(status);
    }

    @PutMapping
    public Status updateStatus(@RequestBody Status status) {
        return statusManager.save(status);
    }

    @DeleteMapping
    public void deleteStatus(@RequestParam Long index) {
        statusManager.deleteById(index);
    }

}
