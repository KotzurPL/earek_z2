package pl.kotzur.earek_z2.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kotzur.earek_z2.model.Status;
import pl.kotzur.earek_z2.repo.StatusRepo;

import java.util.Optional;

@Service
public class StatusManager {

    private StatusRepo statusRepo;

    @Autowired
    public StatusManager(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }

    public Optional<Status> findById(Long id) {
        return statusRepo.findById(id);
    }

    public Iterable<Status> findAll() {
        return statusRepo.findAll();
    }

    public Status save(Status status) {
        return statusRepo.save(status);
    }

    public void deleteById(Long id) {
        statusRepo.deleteById(id);
    }

}
