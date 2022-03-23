package pl.kotzur.earek_z2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kotzur.earek_z2.model.Status;

@Repository
public interface StatusRepo extends CrudRepository<Status, Long> {
}
